package pl.andrzejmidura.fivehanddrawpoker.game.messageDTO;

import java.util.Map;

public class MessageToAllSubscribers {
    private Map<String, PlayerMessage> playersActions;
    private Integer pot;
}
