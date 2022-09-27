package pl.andrzejmidura.fivehanddrawpoker.game.messageDTO;

import lombok.Getter;
import lombok.Setter;
import pl.andrzejmidura.fivehanddrawpoker.game.GameState;

import java.util.Map;

@Getter
@Setter
public class MessageToAllSubscribers {
    private GameState state;
    private Map<String, MessageFromPlayer> playersActions;
    private String currentlyPlaysUsername;
    private Integer pot;
}
