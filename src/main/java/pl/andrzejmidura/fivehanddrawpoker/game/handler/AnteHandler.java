package pl.andrzejmidura.fivehanddrawpoker.game.handler;

import pl.andrzejmidura.fivehanddrawpoker.game.GameDataDTO;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToAllSubscribers;

public class AnteHandler implements StageHandler{
    @Override
    public MessageToAllSubscribers handle(GameDataDTO gameDataDTO) {
        return null;
    }

    @Override
    public StageHandler getNextStageHandlerIfStageEnded() {
        return null;
    }
}
