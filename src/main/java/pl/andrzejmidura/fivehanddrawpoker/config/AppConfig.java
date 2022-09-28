package pl.andrzejmidura.fivehanddrawpoker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.andrzejmidura.fivehanddrawpoker.game.Game;
import pl.andrzejmidura.fivehanddrawpoker.game.GameImpl;

@Configuration
public class AppConfig {
    @Bean
    public Game game() {
        return new GameImpl();
    }
}
