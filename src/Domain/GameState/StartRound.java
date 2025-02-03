package Domain.GameState;

import Domain.CommandTypes;
import Domain.Game;
import Domain.OutputDevice;
import Domain.RoundResult;

import java.util.ArrayList;
import java.util.List;

public class StartRound extends State{
    public StartRound(Game game) {
        super(game, StateType.StartRound);
    }

    @Override
    public void startGame(OutputDevice od) {
        game.startRound(od);
        if(game.getGameResult() != RoundResult.NoResult)
            game.setState(StateType.EndRound);
        else
            game.setState(StateType.PlayRound);
    }

    @Override
    public List<CommandTypes> getSpecificCommands() {
        ArrayList<CommandTypes> list = new ArrayList<>();
        list.add(CommandTypes.StartRound);
        list.add(CommandTypes.Exit);
        return list;
    }

    @Override
    public void hitcard(OutputDevice od) {
        assert(false);
    }

    @Override
    public void continueGame(OutputDevice od) {
        assert(false);
    }

    @Override
    public void stand(OutputDevice od) {
        assert(false);
    }

    @Override
    public void Double(OutputDevice od) {
        assert(false);
    }
}
