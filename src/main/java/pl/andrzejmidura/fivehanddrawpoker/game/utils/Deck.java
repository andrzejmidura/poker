package pl.andrzejmidura.fivehanddrawpoker.game.utils;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>(54);

    public Deck() {
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
    }

    public void shuffle() {}

    public void sort() {}

    public Card getTopCard() { return null; }
}
