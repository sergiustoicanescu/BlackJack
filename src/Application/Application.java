package Application;

import Domain.*;
import Interface.ApplicationSpace.ApplicationSpace;
import Domain.CommandTypes;
import Interface.Scene.GameScene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Application {
    GameScene gameScene;
    ApplicationSpace applicationSpace;
    Game game;
    OutputDeviceService od;

    public Application() {

        game = new Game(StorageUserData.existUserData());
        gameScene = new GameScene();
        applicationSpace = new ApplicationSpace(gameScene, initCommands());
        applicationSpace.setVisibleCommands(game.getCurrentCommands());
        od = new OutputDeviceService(gameScene, applicationSpace);
    }

    public void run()
    {
        SwingUtilities.invokeLater(() -> applicationSpace.setVisible(true));
    }
    Map<CommandTypes, ActionListener> initCommands()
    {
        Map<CommandTypes, ActionListener> map = new HashMap<>();
        map.put(CommandTypes.StartGame, createStartGameAction());
        map.put(CommandTypes.Resume, createResume());
        map.put(CommandTypes.Hit, hitCard());
        map.put(CommandTypes.Continue, continueGame());
        map.put(CommandTypes.Double, Double());
        map.put(CommandTypes.Stand, stand());
        map.put(CommandTypes.StartRound, startRound());
        map.put(CommandTypes.Exit, exit());

        return map;
    }
    public ActionListener createStartGameAction()
    {
        return event -> {
            startGame();
        };
    }

    private void startGame() {
        gameScene.clear();
        game.startGameEvent(od);
        applicationSpace.disableLogPanel();
        applicationSpace.initSettingsPanel(game.getBudget(), game.getBet());
        updateApplication();
    }

    public ActionListener createResume()
    {
        return event -> {
            StorageUserData storage = new StorageUserData();
            game.setBudget(storage.load());
            startGame();
        };
    }

    public ActionListener hitCard()
    {
        return event -> {
            game.hitCardEvent(od);
            updateApplication();
        };
    }
    public ActionListener stand()
    {
        return event -> {
            game.standEvent(od);
            updateApplication();
        };
    }
    public ActionListener Double()
    {
        return event -> {
            game.doubleEvent(od);
            updateApplication();
        };
    }
    public ActionListener continueGame()
    {
        return event -> {
            gameScene.clear();
            game.continueGameEvent(od);
            applicationSpace.initSettingsPanel(game.getBudget(), game.getBet());
            applicationSpace.hideResultPanel();
            updateApplication();
        };
    }
    public ActionListener startRound()
    {
        return event -> {
            gameScene.clear();
            game.setBet(applicationSpace.getBetAmount());
            applicationSpace.hideSettingsPanel();
            game.startRoundEvent(od);
            updateApplication();
        };
    }
    public ActionListener exit()
    {
        return event -> {
            StorageUserData storage = new StorageUserData();
            storage.save(game.getBudget());
            System.exit(0);
        };
    }

    private void updateApplication() {
        od.animateCards(() -> {
            applicationSpace.setVisibleCommands(game.getCurrentCommands());
            applicationSpace.displayCardCount(game.getDealerCardCount(), game.getPlayerCardCount());
            applicationSpace.repaint();
            displayResult();
        });
    }

    private void displayResult() {
        if(game.inEndRound())
        {
            if(game.getGameResult() == RoundResult.Draw)
                applicationSpace.initResultPanel("   It's a Draw", 0, Color.ORANGE);
            else if(game.getGameResult() == RoundResult.BlackJack)
                applicationSpace.initResultPanel("You Win", game.getBlackJackBet(), Color.GREEN);
            else if(game.getGameResult() == RoundResult.Win)
                applicationSpace.initResultPanel("You Win", game.getBet(), Color.GREEN);
            else
                applicationSpace.initResultPanel("You Lose", game.getBet(), Color.RED);
        }
    }
}
