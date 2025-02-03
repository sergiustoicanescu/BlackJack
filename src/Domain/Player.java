package Domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<PlayingCard> cards = new ArrayList<>();
    void addCard(PlayingCard card)
    {
        cards.add(card);
    }
    public void resetGame() {
        cards.clear();
    }
    List<PlayingCard> getCards()
    {
        return cards;
    }
    public PlayingCard getLastCard() {
        return cards.get(cards.size() - 1);
    }
    public int getCardsValue()
    {
        int sum = cards.stream().reduce(0, (a, b) -> a + b.getValue(), Integer::sum);
        long aceCount = cards.stream().filter(e -> e.getFaceValue().equals(PlayingCardValue.Ace)).count();
        while (aceCount != 0 && sum > 21)
        {
            sum -= 10;
            aceCount--;
        }
        return sum;
    }
}
