package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<PlayingCard> cardDeck = new ArrayList<PlayingCard>();
    public CardDeck()
    {
        for(var cardType : PlayingCardTypes.values())
        {
            for(var cardValue : PlayingCardValue.values())
            {
                cardDeck.add(new PlayingCard(cardType, cardValue));
            }
        }
    }
    public List<PlayingCard> getCards()
    {
        return Collections.unmodifiableList(cardDeck);
    }

    public int getNumberOfCards() {
        return cardDeck.size();
    }
}
