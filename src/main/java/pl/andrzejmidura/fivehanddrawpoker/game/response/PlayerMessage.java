package pl.andrzejmidura.fivehanddrawpoker.game.response;

import pl.andrzejmidura.fivehanddrawpoker.game.utils.Action;

public class PlayerMessage {
    private Action action;
    private Integer value;

    public PlayerMessage(Action action, Integer value) {
        this.action = action;
        this.value = value;
    }
}
