package Interface.Scene;

import java.awt.*;
import javax.vecmath.Vector2d;

public class MovePlayingCard {
    private PlayingCardRepresentation card;
    private Point start;
    private Point end;
    private Vector2d vector2d = new Vector2d();
    private int step = 10;
    MovePlayingCard(PlayingCardRepresentation card, Point start, Point end)
    {
        this.card = card;
        this.start = start;
        this.end = new Point(end);
        vector2d.sub(new Vector2d(end.x, end.y), new Vector2d(start.x, start.y));
        vector2d.normalize();
        vector2d.scale(step);
    }

    public void translate() {
        card.translate(new Point((int) vector2d.x, (int) vector2d.y));
        Point point = card.getPosition();
        Vector2d v = new Vector2d();
        v.sub(new Vector2d(end.x, end.y), new Vector2d(point.x, point.y));
        var len = v.length();
        if(len < step || v.x < 0)
        {
            card.setPosition(end);
        }
    }

    public boolean reachEnd() {
        Point point = card.getPosition();
        return point.equals(end);
    }
}
