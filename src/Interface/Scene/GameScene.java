package Interface.Scene;

import Domain.PlayingCard;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameScene implements  Scene {
    private PlayingCardRepresentationRepository repository = new PlayingCardRepresentationRepository();
    private List<PlayingCardRepresentation> cardList = new ArrayList<>();
    private Point playerPosition = null;
    private Point dealerPosition = null;
    private Point deckPosition = new Point(40, 300);
    public GameScene() {
        repository.load();
        initPoints();
    }
    @Override
    public void draw(Graphics g) {
        cardList.forEach(e -> e.drawCard((Graphics2D) g));
        if(!cardList.isEmpty())
            g.drawImage(repository.getDeckImage(), deckPosition.x, deckPosition.y, 150,200, null);
    }
    @Override
    public void addCard(PlayingCard card, Point position) {
        var kernel = repository.getCard(card);
        PlayingCardRepresentation representation = new PlayingCardRepresentation(kernel, position);
        cardList.add(representation);
    }

    public MovePlayingCard createMovePlayingCard(PlayingCard card) {
        PlayingCardRepresentation cardRepresentation = new PlayingCardRepresentation(repository.getCard(card), deckPosition);
        cardList.add(cardRepresentation);
        MovePlayingCard movingCard = new MovePlayingCard(cardRepresentation, deckPosition, playerPosition);
        playerPosition.x += 100;
        return movingCard;
    }

    public void clear() {
        initPoints();
        cardList.clear();
    }
    private void initPoints()
    {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        dealerPosition = new Point((int) (size.getWidth() / 2) - 150, 40);
        playerPosition = new Point((int) (size.getWidth() / 2) - 150, 575);
    }

    public MovePlayingCard createMoveDealerCard(PlayingCard card) {
        PlayingCardRepresentation cardRepresentation = new PlayingCardRepresentation(repository.getCard(card), deckPosition);
        cardList.add(cardRepresentation);
        MovePlayingCard movingCard = new MovePlayingCard(cardRepresentation, deckPosition, dealerPosition);
        dealerPosition.x += 100;
        return movingCard;
    }
}
