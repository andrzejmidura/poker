package pl.andrzejmidura.fivehanddrawpoker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import pl.andrzejmidura.fivehanddrawpoker.entity.User;
import pl.andrzejmidura.fivehanddrawpoker.game.response.GameMessage;
import pl.andrzejmidura.fivehanddrawpoker.game.response.PlayerState;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/game")
public class GameController {

    @GetMapping("/")
    public String index(Model model) {

        // TESTING UI
        GameMessage gameMessage = new GameMessage();
        gameMessage.setResponseType(PlayerState.WAIT);
        gameMessage.setAvailableActions(List.of(Action.BET, Action.FOLD));
        gameMessage.setCards(List.of(  new Card(Suit.HEART,    Rank.ACE),
                                        new Card(Suit.SPADE,    Rank.ACE),
                                        new Card(Suit.DIAMOND,  Rank.NINE),
                                        new Card(Suit.DIAMOND,  Rank.JACK),
                                        new Card(Suit.CLUB,     Rank.THREE)));
        gameMessage.setCredits(200L);
        gameMessage.setHand(Hand.PAIR);
        gameMessage.setPot(0L);
        User user1 = new User();
        user1.setUsername("Andrzej");
        User user2 = new User();
        user2.setUsername("Maciek");
        Map<User, Action> map = Map.of( user1, Action.NO_ACTION,
                                        user2, Action.NO_ACTION);
        gameMessage.setOtherPlayers(map);

        model.addAttribute("gameResponse", gameMessage);
        // END

        return "game";
    }

    @GetMapping("/action")
    public String action(@RequestParam(name = "name") String action) {
        System.out.println("Session id[" + RequestContextHolder.currentRequestAttributes().getSessionId() + "]: " + action);
        return "redirect:/";
    }

}
