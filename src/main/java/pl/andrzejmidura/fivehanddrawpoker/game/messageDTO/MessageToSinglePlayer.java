package pl.andrzejmidura.fivehanddrawpoker.game.messageDTO;

import lombok.Getter;
import lombok.Setter;
import pl.andrzejmidura.fivehanddrawpoker.entity.User;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Action;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Card;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Hand;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class MessageToSinglePlayer {
    private PlayerState playerState;
    private Map<User, Action> otherPlayers;
    private List<Card> cards;
    private List<Action> availableActions;
    private Hand hand;
    private Long credits;

    public MessageToSinglePlayer() {
    }
}
