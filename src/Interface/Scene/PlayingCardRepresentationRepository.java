package Interface.Scene;

import Domain.CardDeck;
import Domain.PlayingCard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlayingCardRepresentationRepository {
    List<PlayingCardRepresentationKernel> playingCardRepresentationKernels = new ArrayList<>();
    BufferedImage deckImage;
    String imageCardPath = "C:/Users/sergi/Documents/Java/BlackJack/BlackJack images/";
    public void load(){
        CardDeck deck = new CardDeck();
        for(var card : deck.getCards())
        {
            try {
                playingCardRepresentationKernels.add(new PlayingCardRepresentationKernel(card, getImage(card)));
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        loadDeckImage();
    }
    private BufferedImage getImage(PlayingCard card) {
        String filePath = imageCardPath + card.toString() + ".png";
        return loadImage(filePath);
    }

    private static BufferedImage loadImage(String filePath) {
        try {
            File imagefile = new File(filePath);
            BufferedImage image = ImageIO.read(imagefile);
            return image;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadDeckImage()
    {
        String filePath = imageCardPath +  "DeckImage.jpg";
        deckImage = loadImage(filePath);
    }

    public PlayingCardRepresentationKernel getCard(PlayingCard card)
    {
        return playingCardRepresentationKernels.stream().filter(e -> e.isCard(card)).findFirst().get();
    }

    public Image getDeckImage() {
        return deckImage;
    }
}
