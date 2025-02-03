package Interface.Scene;

import java.awt.*;

public class PlayingCardRepresentation {
    PlayingCardRepresentationKernel card;
    Point position;
    PlayingCardRepresentation(PlayingCardRepresentationKernel _card, Point _point)
    {
        card = _card;
        position = (Point) _point.clone();
    }
    public void drawCard(Graphics2D g2d)
    {
        card.drawCard(g2d, position);
    }

    public void translate(Point point) {
        position.translate(point.x, point.y);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point end) {
        position.setLocation(end);
    }
}
