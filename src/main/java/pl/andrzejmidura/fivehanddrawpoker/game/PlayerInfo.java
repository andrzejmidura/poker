package pl.andrzejmidura.fivehanddrawpoker.game;

import lombok.Getter;
import lombok.Setter;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Action;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Card;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlayerInfo {
    private final List<Action> availableActions = new ArrayList<>();
    private final List<Card> cards = new ArrayList<>(5);
    private int credits;
    private int stake;
}
