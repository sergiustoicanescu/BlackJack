package Interface.ApplicationSpace;
import Domain.CommandTypes;
import Interface.Scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ApplicationSpace extends JFrame {
    CommandPanel commandPanel;
    NamePanel namePanel;
    SettingsPanel settings;
    CardCountPanel cardCount;
    ResultPanel resultPanel;

    public ApplicationSpace(Scene scene, Map<CommandTypes, ActionListener> commands) {
        super("Blackjack");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(size);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        JPanel panel = new MainPanel(scene, size);
        add(panel);
        commandPanel = new CommandPanel(commands, size);
        add(commandPanel);
        namePanel = new NamePanel(size);
        add(namePanel);
        settings = new SettingsPanel(size);
        add(settings);
        settings.setVisible(false);
        cardCount = new CardCountPanel(size);
        add(cardCount);
        cardCount.setVisible(false);
        resultPanel = new ResultPanel(size);
        add(resultPanel);
        resultPanel.setVisible(false);

    }

    public void setVisibleCommands(List<CommandTypes> currentCommands) {
        commandPanel.setVisibleCommands(currentCommands);
    }
    public void disableLogPanel()
    {
        namePanel.setVisible(false);
    }

    public void displayCardCount(int dealerCardCount, int playerCardCount)
    {
        cardCount.setVisible(true);
        cardCount.displayCardCountLabel(dealerCardCount, playerCardCount);
    }

    public int getBetAmount()
    {
        return settings.getBetAmount();
    }

    public void initSettingsPanel(int budget, int bet) {
        settings.displayBudget(budget);
        settings.setBetAmount(bet);
        settings.setVisible(true);
    }

    public void hideSettingsPanel() {
        settings.setVisible(false);
    }

    public void initResultPanel(String message, int bet, Color color)
    {
        resultPanel.displayResult(message, bet, color);
        resultPanel.setVisible(true);
    }

    public void hideResultPanel()
    {
        resultPanel.setVisible(false);
    }

    public void hideVisibleCommandsAndCardCount() {
        cardCount.setVisible(false);
        setVisibleCommands(new ArrayList<CommandTypes>());
    }
}
