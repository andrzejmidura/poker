package pl.andrzejmidura.fivehanddrawpoker.game.handler;

import pl.andrzejmidura.fivehanddrawpoker.game.GameDataDTO;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToAllSubscribers;

public interface StageHandler {
    MessageToAllSubscribers handle(GameDataDTO gameDataDTO);
    StageHandler getNextStageHandlerIfStageEnded();
}
