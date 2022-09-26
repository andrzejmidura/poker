package pl.andrzejmidura.fivehanddrawpoker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.andrzejmidura.fivehanddrawpoker.game.messageDTO.MessageToSinglePlayer;
import pl.andrzejmidura.fivehanddrawpoker.service.GameService;

import java.security.Principal;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/")
    public String index() {
        return "game";
    }

    @GetMapping("/newRound")
    @ResponseBody
    public MessageToSinglePlayer newRound(Principal principal) {
        String username = principal.getName();
        return gameService.messageToSinglePlayer(username);
    }

}
