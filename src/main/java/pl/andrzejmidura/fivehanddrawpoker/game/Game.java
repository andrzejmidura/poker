package pl.andrzejmidura.fivehanddrawpoker.game;

import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageFromPlayer;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToAllSubscribers;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToSinglePlayer;

public interface Game {
    MessageToSinglePlayer getMessageToSinglePlayer(String username);
    MessageToAllSubscribers getMessageToAllSubscribers(String username, MessageFromPlayer message);
    void queueNewPlayer(String username);
    void unqueuePlayer(String username);
}
