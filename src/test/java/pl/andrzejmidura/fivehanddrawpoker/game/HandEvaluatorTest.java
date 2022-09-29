package pl.andrzejmidura.fivehanddrawpoker.game;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import pl.andrzejmidura.fivehanddrawpoker.game.hand.HandEvaluator;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Card;
import pl.andrzejmidura.fivehanddrawpoker.game.hand.Hand;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Rank;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Suit;

import java.util.ArrayList;
import java.util.List;

public class HandEvaluatorTest {
    HandEvaluator handEvaluator = new HandEvaluator();

    @Test
    void testForHighCard() {
        List<Card> cardsWithHighCard = new ArrayList<>(5);
        cardsWithHighCard.add(new Card(Suit.DIAMOND,    Rank.NINE));
        cardsWithHighCard.add(new Card(Suit.HEART,      Rank.ACE));
        cardsWithHighCard.add(new Card(Suit.CLUB,       Rank.EIGHT));
        cardsWithHighCard.add(new Card(Suit.CLUB,       Rank.TWO));
        cardsWithHighCard.add(new Card(Suit.SPADE,      Rank.QUEEN));

        Hand hand = handEvaluator.evaluate(cardsWithHighCard);

        assertEquals(Hand.HIGH_CARD, hand);
    }

    @Test
    void testForPair() {
        List<Card> cardsWithPair = new ArrayList<>(5);
        cardsWithPair.add(new Card(Suit.DIAMOND,    Rank.NINE));
        cardsWithPair.add(new Card(Suit.HEART,      Rank.ACE));
        cardsWithPair.add(new Card(Suit.CLUB,       Rank.NINE));
        cardsWithPair.add(new Card(Suit.CLUB,       Rank.TWO));
        cardsWithPair.add(new Card(Suit.SPADE,      Rank.QUEEN));

        Hand hand = handEvaluator.evaluate(cardsWithPair);

        assertEquals(Hand.PAIR, hand);
    }

    @Test
    void testForTwoPairs() {
        List<Card> cardsWithTwoPairs = new ArrayList<>(5);
        cardsWithTwoPairs.add(new Card(Suit.DIAMOND,    Rank.NINE));
        cardsWithTwoPairs.add(new Card(Suit.HEART,      Rank.ACE));
        cardsWithTwoPairs.add(new Card(Suit.CLUB,       Rank.NINE));
        cardsWithTwoPairs.add(new Card(Suit.CLUB,       Rank.TWO));
        cardsWithTwoPairs.add(new Card(Suit.SPADE,      Rank.TWO));

        Hand hand = handEvaluator.evaluate(cardsWithTwoPairs);

        assertEquals(Hand.TWO_PAIRS, hand);
    }

    @Test
    void testForThreeOfAKind() {
        List<Card> cardsWithThreeOfAKind = new ArrayList<>(5);
        cardsWithThreeOfAKind.add(new Card(Suit.DIAMOND,    Rank.NINE));
        cardsWithThreeOfAKind.add(new Card(Suit.HEART,      Rank.ACE));
        cardsWithThreeOfAKind.add(new Card(Suit.CLUB,       Rank.NINE));
        cardsWithThreeOfAKind.add(new Card(Suit.CLUB,       Rank.TWO));
        cardsWithThreeOfAKind.add(new Card(Suit.SPADE,      Rank.NINE));

        Hand hand = handEvaluator.evaluate(cardsWithThreeOfAKind);

        assertEquals(Hand.THREE_OF_A_KIND, hand);
    }

    @Test
    void testForStraight() {
        List<Card> cardsWithStraight = new ArrayList<>(5);
        cardsWithStraight.add(new Card(Suit.HEART,      Rank.TEN));
        cardsWithStraight.add(new Card(Suit.CLUB,       Rank.EIGHT));
        cardsWithStraight.add(new Card(Suit.SPADE,      Rank.NINE));
        cardsWithStraight.add(new Card(Suit.DIAMOND,    Rank.SIX));
        cardsWithStraight.add(new Card(Suit.HEART,      Rank.SEVEN));

        Hand hand = handEvaluator.evaluate(cardsWithStraight);

        assertEquals(Hand.STRAIGHT, hand);
    }

    @Test
    void testForFlush() {
        List<Card> cardsWithFlush = new ArrayList<>(5);
        cardsWithFlush.add(new Card(Suit.CLUB, Rank.KING));
        cardsWithFlush.add(new Card(Suit.CLUB, Rank.TEN));
        cardsWithFlush.add(new Card(Suit.CLUB, Rank.EIGHT));
        cardsWithFlush.add(new Card(Suit.CLUB, Rank.SEVEN));
        cardsWithFlush.add(new Card(Suit.CLUB, Rank.FIVE));

        Hand hand = handEvaluator.evaluate(cardsWithFlush);

        assertEquals(Hand.FLUSH, hand);
    }

    @Test
    void testForFullHouse() {
        List<Card> cardsWithFullHouse = new ArrayList<>(5);
        cardsWithFullHouse.add(new Card(Suit.HEART,     Rank.ACE));
        cardsWithFullHouse.add(new Card(Suit.HEART,     Rank.THREE));
        cardsWithFullHouse.add(new Card(Suit.CLUB,      Rank.ACE));
        cardsWithFullHouse.add(new Card(Suit.DIAMOND,   Rank.ACE));
        cardsWithFullHouse.add(new Card(Suit.SPADE,     Rank.THREE));

        Hand hand = handEvaluator.evaluate(cardsWithFullHouse);

        assertEquals(Hand.FULL_HOUSE, hand);
    }

    @Test
    void testForFourOfAKind() {
        List<Card> cardsWithFourOfAKind = new ArrayList<>(5);
        cardsWithFourOfAKind.add(new Card(Suit.HEART, Rank.NINE));
        cardsWithFourOfAKind.add(new Card(Suit.CLUB, Rank.NINE));
        cardsWithFourOfAKind.add(new Card(Suit.CLUB, Rank.FIVE));
        cardsWithFourOfAKind.add(new Card(Suit.SPADE, Rank.NINE));
        cardsWithFourOfAKind.add(new Card(Suit.DIAMOND, Rank.NINE));

        Hand hand = handEvaluator.evaluate(cardsWithFourOfAKind);

        assertEquals(Hand.FOUR_OF_A_KIND, hand);
    }

    @Test
    void testForStraightFlush() {
        List<Card> cardsWithStraightFlush = new ArrayList<>(5);
        cardsWithStraightFlush.add(new Card(Suit.SPADE, Rank.JACK));
        cardsWithStraightFlush.add(new Card(Suit.SPADE, Rank.EIGHT));
        cardsWithStraightFlush.add(new Card(Suit.SPADE, Rank.TEN));
        cardsWithStraightFlush.add(new Card(Suit.SPADE, Rank.SEVEN));
        cardsWithStraightFlush.add(new Card(Suit.SPADE, Rank.NINE));

        Hand hand = handEvaluator.evaluate(cardsWithStraightFlush);

        assertEquals(Hand.STRAIGHT_FLUSH, hand);
    }

    @Test
    void testForRoyalFlush() {
        List<Card> cardsWithRoyalFlush = new ArrayList<>(5);
        cardsWithRoyalFlush.add(new Card(Suit.DIAMOND, Rank.ACE));
        cardsWithRoyalFlush.add(new Card(Suit.DIAMOND, Rank.TEN));
        cardsWithRoyalFlush.add(new Card(Suit.DIAMOND, Rank.JACK));
        cardsWithRoyalFlush.add(new Card(Suit.DIAMOND, Rank.KING));
        cardsWithRoyalFlush.add(new Card(Suit.DIAMOND, Rank.QUEEN));

        Hand hand = handEvaluator.evaluate(cardsWithRoyalFlush);

        assertEquals(Hand.ROYAL_FLUSH, hand);
    }

}
