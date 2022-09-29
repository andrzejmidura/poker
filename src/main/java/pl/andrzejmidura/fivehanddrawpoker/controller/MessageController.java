package pl.andrzejmidura.fivehanddrawpoker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import pl.andrzejmidura.fivehanddrawpoker.game.Game;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToAllSubscribers;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageFromPlayer;
import pl.andrzejmidura.fivehanddrawpoker.service.GameService;

import java.security.Principal;

@Controller
public class MessageController {
    @Autowired
    private GameService gameService;
    @Autowired
    private Game game;

    @MessageMapping("/message")
    @SendTo("/topic/game")
    public MessageToAllSubscribers getMessage(Principal principal, MessageFromPlayer messageFromPlayer) {
        String username = principal.getName();
        return gameService.messageToAllSubscribers(username, messageFromPlayer);
    }

    @EventListener
    public void handleSessionConnected(SessionConnectEvent event) {
        Principal principal = event.getUser();
        if (principal == null) {
            throw new UsernameNotFoundException("Authentication failed - principal is null, cannot queue new player.");
        }
        else {
            String username = principal.getName();
            game.queueNewPlayer(username);
        }
    }

    @EventListener
    public void handleSessionDisconnect(SessionDisconnectEvent event) {
        Principal principal = event.getUser();
        if (principal == null) {
            throw new UsernameNotFoundException("Authentication failed - principal is null, cannot unqueue player.");
        }
        else {
            String username = principal.getName();
            game.unqueuePlayer(username);
        }
    }

}
