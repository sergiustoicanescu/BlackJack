package Interface.Scene;

import Domain.PlayingCard;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayingCardRepresentationKernel
{
    PlayingCard playingCard;
    BufferedImage image;

    public PlayingCardRepresentationKernel(PlayingCard _playingCard, BufferedImage _image)
    {
        playingCard = _playingCard;
        image = _image;
    }
    public void drawCard(Graphics2D g2d, Point point)
    {
        g2d.drawImage(image, point.x, point.y, 150,200, null);
    }
    boolean isCard(PlayingCard card)
    {
        return playingCard.equals(card);
    }
}
