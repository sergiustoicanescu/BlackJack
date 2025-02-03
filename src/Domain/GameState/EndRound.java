package Domain.GameState;

import Domain.CommandTypes;
import Domain.Game;
import Domain.OutputDevice;

import java.util.ArrayList;
import java.util.List;

public class EndRound extends State {
    public EndRound(Game game) {
        super(game, StateType.EndRound);
    }

    @Override
    public void startGame(OutputDevice od) {
        assert(false);
    }

    @Override
    public List<CommandTypes> getSpecificCommands() {
        ArrayList<CommandTypes> list = new ArrayList<>();
        list.add(CommandTypes.Continue);
        return list;
    }

    @Override
    public void hitcard(OutputDevice od) {
        assert(false);
    }

    @Override
    public void continueGame(OutputDevice od) {
        game.resetBet();
        game.resetGame();
        if(game.checkForReshuffle())
        {
            game.shuffleCards();
            od.reshuffleMessage();
        }
        game.setState(StateType.StartRound);
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
