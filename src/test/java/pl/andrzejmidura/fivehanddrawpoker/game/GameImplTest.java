package pl.andrzejmidura.fivehanddrawpoker.game;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameImplTest {
    static final GameImpl game = new GameImpl();

    @Test
    @Order(1)
    void testQueueingPlayer() {
        String playerUsername = "player";

        game.queueNewPlayer(playerUsername);

        assertTrue(game.playerQueued(playerUsername));
    }

    @Test
    @Order(2)
    void testUnqueueingPlayer() {
        String playerUsername = "player";

        game.unqueuePlayer(playerUsername);

        assertFalse(game.playerQueued(playerUsername));
    }
}
