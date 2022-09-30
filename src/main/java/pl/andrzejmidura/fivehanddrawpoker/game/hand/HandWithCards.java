package pl.andrzejmidura.fivehanddrawpoker.game.hand;

import lombok.Getter;
import lombok.Setter;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Card;

import java.util.List;

@Getter
@Setter
public class HandWithCards {
    private Hand hand;
    private List<Card> cards;

    public HandWithCards() {}
    public HandWithCards(Hand hand, List<Card> cards) {
        this.hand = hand;
        this.cards = cards;
    }
}
