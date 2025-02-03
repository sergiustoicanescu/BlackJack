package Application;

import Interface.ApplicationSpace.ApplicationSpace;
import Interface.Scene.MovePlayingCard;

import java.util.List;
import java.util.Timer;

public class Animation{
    private Timer timer;
    private List<MovePlayingCard> movingCards;
    private ApplicationSpace applicationSpace;
    public Animation(List<MovePlayingCard> moveCards, ApplicationSpace applicationSpace, Runnable run)
    {
        this.movingCards = moveCards;
        this.applicationSpace = applicationSpace;
        timer = new Timer();
        TimerAction action = new TimerAction(timer, movingCards, applicationSpace, run);
        timer.schedule(action, 15, 15);
    }
}
