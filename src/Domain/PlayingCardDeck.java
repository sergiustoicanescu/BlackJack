package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PlayingCardDeck {
    private List<PlayingCard> cards = new ArrayList<>();
    private final int cuttingCard = 100;
    void clear()
    {
        cards.clear();
        CardDeck cardDeck = new CardDeck();
        IntStream.range(0, 3).forEach(i -> cards.addAll(cardDeck.getCards()));
    }

    void shuffleCards()
    {
        clear();
        Collections.shuffle(cards);
    }
    PlayingCard getCard()
    {
        PlayingCard card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public boolean checkForReshuffle() {
        CardDeck cardDeck = new CardDeck();
        int totalCount = cardDeck.getNumberOfCards() * 3;
        int burnedCards = totalCount - cards.size();
        return burnedCards > cuttingCard;
    }
}
