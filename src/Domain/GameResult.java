package Domain;

public class GameResult {
    private RoundResult result = RoundResult.NoResult;
    private int budget = 10000;
    private int bet = 100;
    private int startBet = bet;

    public void setResult(RoundResult result) {
        this.result = result;
        if (result == RoundResult.Win)
            budget += bet;
        else if (result == RoundResult.Lose)
            budget -= bet;
        else if (result == RoundResult.BlackJack)
            budget += bet * 3 / 2;
    }

    public RoundResult getRoundResult() {
        return result;
    }

    public int getBudget() {
        return budget;
    }

    public void setBet(int amount) {
        bet = amount;
    }

    public int getBet() {
        return bet;
    }

    public int getBlackJackBet() {
        return bet * 3 / 2;
    }

    public void doubleBet() {
        bet *= 2;
    }

    public void resetBet() {
        bet = startBet;
    }

    public void setStartBet() {
        startBet = bet;
    }

    public void setBudget(int value) {
        budget = value;
    }
}
