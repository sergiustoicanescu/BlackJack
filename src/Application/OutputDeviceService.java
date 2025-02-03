package Application;

import Domain.OutputDevice;
import Domain.PlayingCard;
import Interface.ApplicationSpace.ApplicationSpace;
import Interface.Scene.GameScene;
import Interface.Scene.MovePlayingCard;
import Interface.Tool.Message;

import java.util.ArrayList;
import java.util.List;


public class OutputDeviceService implements OutputDevice {
    private GameScene scene;
    private ApplicationSpace applicationSpace;
    private List<MovePlayingCard> movePlayingCardList = new ArrayList<>();
    public OutputDeviceService(GameScene scene, ApplicationSpace applicationSpace)
    {
        this.scene = scene;
        this.applicationSpace = applicationSpace;
    }
    @Override
    public void setPlayerCard(PlayingCard card) {
        var movingCard = scene.createMovePlayingCard(card);
        movePlayingCardList.add(movingCard);
    }

    @Override
    public void setDealerCard(PlayingCard card) {
        var movingCard = scene.createMoveDealerCard(card);
        movePlayingCardList.add(movingCard);
    }

    @Override
    public void reshuffleMessage() {
        Message message = new Message();
        message.reshuffle(applicationSpace);
    }
    public void animateCards(Runnable run) {
        if (movePlayingCardList.isEmpty())
        {
            run.run();
            return;
        }
        applicationSpace.hideVisibleCommandsAndCardCount();
        Animation animation = new Animation(movePlayingCardList, applicationSpace, run);
        movePlayingCardList = new ArrayList<>();
    }
}
