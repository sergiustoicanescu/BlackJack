package Domain.GameState;

import Domain.CommandTypes;
import Domain.Game;

import java.util.ArrayList;
import java.util.List;

public class PlayRoundStrict extends PlayRound{
    public PlayRoundStrict(Game game) {
        super(game, StateType.PlayRoundStrict);
    }
    @Override
    public List<CommandTypes> getSpecificCommands() {
        ArrayList<CommandTypes> list = new ArrayList<>();
        list.add(CommandTypes.Hit);
        list.add(CommandTypes.Stand);
        return list;
    }
}
