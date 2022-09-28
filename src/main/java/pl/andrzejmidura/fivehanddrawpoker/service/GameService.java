package pl.andrzejmidura.fivehanddrawpoker.service;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserRepository userRepository;
    @Autowired
    Game game;

    public MessageToSinglePlayer messageToSinglePlayer(String username) {
        return game.getMessageToSinglePlayer(username);
    }
    public MessageToAllSubscribers messageToAllSubscribers(String username, MessageFromPlayer message) {
        return game.getMessageToAllSubscribers(username, message);
    }

    public int getCredits(String username) {
        Optional<User> requestingUser = userRepository.findUserByUsername(username);
        if(requestingUser.isPresent()) {
            return requestingUser.get().getCredits();
        }
        else {
            throw new UsernameNotFoundException("Cannot find user with username '" + username + "'");
        }
    }

}
