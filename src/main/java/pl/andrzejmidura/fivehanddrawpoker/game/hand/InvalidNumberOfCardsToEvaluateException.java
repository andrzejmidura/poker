package pl.andrzejmidura.fivehanddrawpoker.game.hand;

public class InvalidNumberOfCardsToEvaluateException extends RuntimeException {
    public InvalidNumberOfCardsToEvaluateException(String message) {
        super(message);
    }
}
