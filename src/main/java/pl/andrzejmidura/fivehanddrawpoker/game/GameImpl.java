package pl.andrzejmidura.fivehanddrawpoker.game;

import pl.andrzejmidura.fivehanddrawpoker.game.handler.StageHandler;
import pl.andrzejmidura.fivehanddrawpoker.game.handler.StoppedHandler;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageFromPlayer;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToAllSubscribers;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToSinglePlayer;

public class GameImpl implements Game{
    GameDataDTO gameDataDTO;
    StageHandler stageHandler;

    public GameImpl() {
        this.gameDataDTO = new GameDataDTO();
        this.stageHandler = new StoppedHandler();
    }

    @Override
    public MessageToSinglePlayer getMessageToSinglePlayer(String username) {
        return null;
    }
    @Override
    public MessageToAllSubscribers getMessageToAllSubscribers(String username, MessageFromPlayer message) {
        return null;
    }
    @Override
    public void queueNewPlayer(String username) {

    }
    @Override
    public void unqueuePlayer(String username) {

    }
}
