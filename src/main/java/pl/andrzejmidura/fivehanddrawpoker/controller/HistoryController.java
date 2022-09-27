package pl.andrzejmidura.fivehanddrawpoker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.andrzejmidura.fivehanddrawpoker.repository.GameHistoryRepository;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private GameHistoryRepository gameHistoryRepository;

    @GetMapping("")
    public String getHistory() {
        return "history";
    }

}
