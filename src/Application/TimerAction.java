package Application;

import Interface.ApplicationSpace.ApplicationSpace;
import Interface.Scene.MovePlayingCard;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimerAction extends TimerTask {
    private List<MovePlayingCard> movingCards;
    private ApplicationSpace applicationSpace;
    Timer timer;
    private int currentCard = 0;
    private Runnable run;
    public TimerAction(Timer timer, List<MovePlayingCard> movingCards, ApplicationSpace applicationSpace, Runnable run) {
        this.timer = timer;
        this.movingCards = movingCards;
        this.applicationSpace = applicationSpace;
        this.run = run;
    }
    @Override
    public void run() {
        movingCards.get(currentCard).translate();
        applicationSpace.repaint();
        if(movingCards.get(currentCard).reachEnd())
        {
            currentCard++;
            if(currentCard == movingCards.size())
            {
                timer.cancel();
                run.run();
            }
        }
    }

}
