package Domain.GameState;

import Domain.CommandTypes;
import Domain.Game;
import Domain.OutputDevice;
import Domain.RoundResult;

import java.util.List;

public abstract class State {
    Game game;
    StateType type;
    public State(Game game, StateType type)
    {
        this.game = game;
        this.type = type;
    }

    public abstract void startGame(OutputDevice od);
    public abstract List<CommandTypes> getSpecificCommands();

    public abstract void hitcard(OutputDevice od);

    public abstract void continueGame(OutputDevice od);

    public abstract void stand(OutputDevice od);
    public abstract void Double(OutputDevice od);
    public StateType getType()
    {
        return type;
    }
    protected void startRound(OutputDevice od, StateType type) {
        game.startRound(od);
        if(game.getGameResult() != RoundResult.NoResult)
            game.setState(StateType.EndRound);
        else
            game.setState(type);
    }
}
