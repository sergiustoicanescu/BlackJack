package Interface.Scene;

import Domain.PlayingCard;

import java.awt.*;

public interface Scene {
    void draw(Graphics g);
    void addCard(PlayingCard card, Point position);

}
