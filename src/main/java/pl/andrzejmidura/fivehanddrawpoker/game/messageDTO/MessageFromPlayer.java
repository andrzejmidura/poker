package pl.andrzejmidura.fivehanddrawpoker.game.messageDTO;

import pl.andrzejmidura.fivehanddrawpoker.game.utils.Action;

public class MessageFromPlayer {
    private Action action;
    private Integer value;

    public MessageFromPlayer(Action action, Integer value) {
        this.action = action;
        this.value = value;
    }
}
