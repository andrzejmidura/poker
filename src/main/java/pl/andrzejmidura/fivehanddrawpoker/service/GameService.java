package pl.andrzejmidura.fivehanddrawpoker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.andrzejmidura.fivehanddrawpoker.entity.User;
import pl.andrzejmidura.fivehanddrawpoker.game.Game;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToAllSubscribers;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToSinglePlayer;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageFromPlayer;
import pl.andrzejmidura.fivehanddrawpoker.repository.UserRepository;

import java.util.Optional;

@Service
public class GameService {
    private final UserRepository userRepository;
    private final Game game;
    private final SimpMessagingTemplate messageSender;


    @Autowired
    public GameService(UserRepository userRepository, Game game, SimpMessagingTemplate messageSender) {
        this.userRepository = userRepository;
        this.game = game;
        this.messageSender = messageSender;
    }

    public MessageToSinglePlayer messageToSinglePlayer(String username) {
        return game.getMessageToSinglePlayer(username);
    }
    public MessageToAllSubscribers messageToAllSubscribers(String username, MessageFromPlayer message) {
        return game.getMessageToAllSubscribers(username, message);
    }
    public int getCredits(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with username '" + username + "'"))
                .getCredits();
    }

}
