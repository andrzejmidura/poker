package pl.andrzejmidura.fivehanddrawpoker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToAllSubscribers;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.PlayerMessage;
import pl.andrzejmidura.fivehanddrawpoker.service.GameService;

import java.security.Principal;

@Controller
public class MessageController {
    @Autowired
    private GameService gameService;

    @MessageMapping("/message")
    @SendTo("/topic/game")
    public MessageToAllSubscribers getMessage(Principal principal, PlayerMessage playerMessage) {
        String username = principal.getName();
        return gameService.messageToAllSubscribers(username, playerMessage);
    }

}
