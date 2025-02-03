package Domain;

import Domain.GameState.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int blackJack = 21;
    private Player player = new Player();
    private Dealer dealer = new Dealer();
    private static PlayingCardDeck deck = new PlayingCardDeck();
    private List<State> stateList = new ArrayList<>();
    private State currentState;
    private GameResult gameResult = new GameResult();
    public Game(boolean existUserData)
    {
        stateList.add(new LaunchGame(this, existUserData));
        stateList.add(new PlayRound(this));
        stateList.add(new PlayRoundStrict(this));
        stateList.add(new EndRound(this));
        stateList.add(new StartRound(this));
        setState(StateType.LaunchGame);
    }
    public void setState(StateType type)
    {
        currentState = stateList.stream().filter(e -> e.getType().equals(type)).findFirst().get();
    }
    public void startGameEvent(OutputDevice od)
    {
        currentState.startGame(od);
    }
    public void hitCardEvent(OutputDevice od)
    {
        currentState.hitcard(od);
    }
    public void doubleEvent(OutputDevice od)
    {
        currentState.Double(od);
    }
    public void continueGameEvent(OutputDevice od)
    {
        currentState.continueGame(od);
    }
    public void standEvent(OutputDevice od)
    {
        currentState.stand(od);
    }
    public void startRoundEvent(OutputDevice od)
    {
        currentState.startGame(od);
    }
    public void startRound(OutputDevice od)
    {
        resetGame();

        player.addCard(deck.getCard());
        dealer.addCard(deck.getCard());
        player.addCard(deck.getCard());

        player.getCards().forEach(od::setPlayerCard);
        dealer.getCards().forEach(od::setDealerCard);

        checkForBlackJack(od);
    }

    public void resetGame() {
        gameResult.setStartBet();
        gameResult.setResult(RoundResult.NoResult);
        player.resetGame();
        dealer.resetGame();
    }

    private void checkForBlackJack(OutputDevice od)
    {
        if(player.getCardsValue() == blackJack)
        {
            dealer.addCard(deck.getCard());
            od.setDealerCard(dealer.getLastCard());
            if(dealer.getCardsValue() == blackJack)
                gameResult.setResult(RoundResult.Draw);
            else
                gameResult.setResult(RoundResult.BlackJack);
        }
    }

    public void hitCard(OutputDevice od)
    {
        player.addCard(deck.getCard());
        od.setPlayerCard(player.getLastCard());
        if(bust(player))
        {
            dealer.addCard(deck.getCard());
            od.setDealerCard(dealer.getLastCard());
            gameResult.setResult(RoundResult.Lose);
        }
        else if(player.getCardsValue() == blackJack)
        {
            stand(od);
        }
    }
    public void stand(OutputDevice od)
    {
        setDealerHand(od);
        if(bust(dealer))
        {
            gameResult.setResult(RoundResult.Win);
            return;
        }
        if(dealer.getCardsValue() == player.getCardsValue())
        {
            if(dealer.getCardsValue() == blackJack && dealer.getCards().size() == 2)
                gameResult.setResult(RoundResult.Lose);
            else
                gameResult.setResult(RoundResult.Draw);
        }
        else if(dealer.getCardsValue() < player.getCardsValue())
            gameResult.setResult(RoundResult.Win);
        else
            gameResult.setResult(RoundResult.Lose);
    }
    public void Double(OutputDevice od)
    {
        gameResult.doubleBet();
        player.addCard(deck.getCard());
        od.setPlayerCard(player.getLastCard());
        if(bust(player))
        {
            dealer.addCard(deck.getCard());
            od.setDealerCard(dealer.getLastCard());
            gameResult.setResult(RoundResult.Lose);
        }
        else
        {
            stand(od);
        }
    }
    boolean bust(Player player)
    {
        return player.getCardsValue() > blackJack;
    }

    public List<CommandTypes> getCurrentCommands() {
        return currentState.getSpecificCommands();
    }

    public boolean inEndRound() {
        if(currentState instanceof EndRound)
        {
            return true;
        }
        return false;
    }
    private void setDealerHand(OutputDevice od)
    {
        int sum = dealer.getCardsValue();
        while(sum < 17)
        {
            dealer.addCard(deck.getCard());
            od.setDealerCard(dealer.getLastCard());
            sum = dealer.getCardsValue();
        }
    }
    public RoundResult getGameResult()
    {
        return gameResult.getRoundResult();
    }

    public void shuffleCards() {
        deck.shuffleCards();
    }

    public int getDealerCardCount() {
        return dealer.getCardsValue();
    }

    public int getPlayerCardCount() {
        return player.getCardsValue();
    }

    public int getBudget() {
        return gameResult.getBudget();
    }
    public int getBet(){return gameResult.getBet();}
    public void setBet(int amount)
    {
        gameResult.setBet(amount);
    }
    public int getBlackJackBet()
    {
        return gameResult.getBlackJackBet();
    }

    public void resetBet() {
        gameResult.resetBet();
    }
    public boolean checkForReshuffle() {
        return deck.checkForReshuffle();
    }

    public void setBudget(int value) {
        gameResult.setBudget(value);
    }
}
