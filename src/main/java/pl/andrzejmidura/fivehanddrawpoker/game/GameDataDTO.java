package pl.andrzejmidura.fivehanddrawpoker.game;

import lombok.Getter;
import lombok.Setter;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Deck;

import java.util.*;

@Getter
@Setter
public class GameDataDTO {
    private static final int MAX_PLAYERS = 8;
    private final Deck deck;
    private GameState state;
    private LinkedList<String> playersQueuedForNewGame;
    private Set<String> playersInGame;
    private PlayerQueue playerQueue;
    private Map<String, PlayerInfo> playerInfoMap;
    private int highestStake;

    public GameDataDTO() {
        this.deck = new Deck();
        this.state = GameState.STOPPED;
        this.playersQueuedForNewGame = new LinkedList<>();
        this.playersInGame = new HashSet<>(MAX_PLAYERS);
        this.playerQueue = new PlayerQueue();
        this.playerInfoMap = new HashMap<>(MAX_PLAYERS);
    }
}
