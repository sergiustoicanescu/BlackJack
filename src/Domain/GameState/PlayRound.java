package Domain.GameState;

import Domain.CommandTypes;
import Domain.Game;
import Domain.OutputDevice;
import Domain.RoundResult;

import java.util.ArrayList;
import java.util.List;

public class PlayRound extends State {
    public PlayRound(Game game) {
        super(game, StateType.PlayRound);
    }
    protected PlayRound(Game game, StateType type)
    {
        super(game, type);
    }



    @Override
    public void startGame(OutputDevice od) {
        assert(false);
    }

    @Override
    public List<CommandTypes> getSpecificCommands() {
        ArrayList<CommandTypes> list = new ArrayList<>();
        list.add(CommandTypes.Hit);
        list.add(CommandTypes.Stand);
        list.add(CommandTypes.Double);
        return list;
    }

    @Override
    public void hitcard(OutputDevice od) {
        game.hitCard(od);
        if(game.getGameResult() == RoundResult.NoResult)
            game.setState(StateType.PlayRoundStrict);
        else
            game.setState(StateType.EndRound);
    }

    @Override
    public void continueGame(OutputDevice od) {
        assert(false);
    }

    @Override
    public void stand(OutputDevice od) {
        game.stand(od);
        game.setState(StateType.EndRound);

    }

    @Override
    public void Double(OutputDevice od) {
        game.Double(od);
        game.setState(StateType.EndRound);
    }
}
