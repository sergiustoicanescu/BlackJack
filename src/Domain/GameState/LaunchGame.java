package Domain.GameState;

import Domain.CommandTypes;
import Domain.Game;
import Domain.OutputDevice;

import java.util.ArrayList;
import java.util.List;

public class LaunchGame extends State {
    boolean existUserData;
    public LaunchGame(Game game, boolean existUserData) {
        super(game, StateType.LaunchGame);
        this.existUserData = existUserData;

    }

    @Override
    public void startGame(OutputDevice od) {
        game.shuffleCards();
        game.setState(StateType.StartRound);
    }

    @Override
    public List<CommandTypes> getSpecificCommands() {
        ArrayList<CommandTypes> list = new ArrayList<>();
        list.add(CommandTypes.StartGame);
        if(existUserData)
            list.add(CommandTypes.Resume);
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
