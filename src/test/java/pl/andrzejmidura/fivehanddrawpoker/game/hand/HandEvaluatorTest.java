package pl.andrzejmidura.fivehanddrawpoker.game.hand;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import pl.andrzejmidura.fivehanddrawpoker.game.utils.Card;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Rank;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Suit;

import java.util.ArrayList;
import java.util.List;

// TODO: add assertTrue for checking if correct cards are saved in handWithCards after handEvaluator.evaluate()
public class HandEvaluatorTest {
    HandEvaluator handEvaluator = new HandEvaluator();

    @Test
    void testForHighCard() throws InvalidNumberOfCardsToEvaluateException {
        List<Card> cardsWithHighCard = new ArrayList<>(5);
        cardsWithHighCard.add(new Card(Suit.DIAMOND,    Rank.NINE));
        cardsWithHighCard.add(new Card(Suit.HEART,      Rank.ACE));
        cardsWithHighCard.add(new Card(Suit.CLUB,       Rank.EIGHT));
        cardsWithHighCard.add(new Card(Suit.CLUB,       Rank.TWO));
        cardsWithHighCard.add(new Card(Suit.SPADE,      Rank.QUEEN));

        HandWithCards handWithCards = handEvaluator.evaluate(cardsWithHighCard);

        assertEquals(Hand.HIGH_CARD, handWithCards.getHand());
    }

    @Test
    void testForPair() throws InvalidNumberOfCardsToEvaluateException {
        List<Card> cardsWithPair = new ArrayList<>(5);
        cardsWithPair.add(new Card(Suit.DIAMOND,    Rank.NINE));
        cardsWithPair.add(new Card(Suit.HEART,      Rank.ACE));
        cardsWithPair.add(new Card(Suit.CLUB,       Rank.NINE));
        cardsWithPair.add(new Card(Suit.CLUB,       Rank.TWO));
        cardsWithPair.add(new Card(Suit.SPADE,      Rank.QUEEN));

        HandWithCards handWithCards = handEvaluator.evaluate(cardsWithPair);

        assertEquals(Hand.PAIR, handWithCards.getHand());
    }

    @Test
    void testForTwoPairs() throws InvalidNumberOfCardsToEvaluateException {
        List<Card> cardsWithTwoPairs = new ArrayList<>(5);
        cardsWithTwoPairs.add(new Card(Suit.DIAMOND,    Rank.NINE));
        cardsWithTwoPairs.add(new Card(Suit.HEART,      Rank.ACE));
        cardsWithTwoPairs.add(new Card(Suit.CLUB,       Rank.NINE));
        cardsWithTwoPairs.add(new Card(Suit.CLUB,       Rank.TWO));
        cardsWithTwoPairs.add(new Card(Suit.SPADE,      Rank.TWO));

        HandWithCards handWithCards = handEvaluator.evaluate(cardsWithTwoPairs);

        assertEquals(Hand.TWO_PAIRS, handWithCards.getHand());
    }

    @Test
    void testForThreeOfAKind() throws InvalidNumberOfCardsToEvaluateException {
        List<Card> cardsWithThreeOfAKind = new ArrayList<>(5);
        cardsWithThreeOfAKind.add(new Card(Suit.DIAMOND,    Rank.NINE));
        cardsWithThreeOfAKind.add(new Card(Suit.HEART,      Rank.ACE));
        cardsWithThreeOfAKind.add(new Card(Suit.CLUB,       Rank.NINE));
        cardsWithThreeOfAKind.add(new Card(Suit.CLUB,       Rank.TWO));
        cardsWithThreeOfAKind.add(new Card(Suit.SPADE,      Rank.NINE));

        HandWithCards handWithCards = handEvaluator.evaluate(cardsWithThreeOfAKind);

        assertEquals(Hand.THREE_OF_A_KIND, handWithCards.getHand());
    }

    @Test
    void testForStraight() throws InvalidNumberOfCardsToEvaluateException {
        List<Card> cardsWithStraight = new ArrayList<>(5);
        cardsWithStraight.add(new Card(Suit.HEART,      Rank.TEN));
        cardsWithStraight.add(new Card(Suit.CLUB,       Rank.EIGHT));
        cardsWithStraight.add(new Card(Suit.SPADE,      Rank.NINE));
        cardsWithStraight.add(new Card(Suit.DIAMOND,    Rank.SIX));
        cardsWithStraight.add(new Card(Suit.HEART,      Rank.SEVEN));

        HandWithCards handWithCards = handEvaluator.evaluate(cardsWithStraight);

        assertEquals(Hand.STRAIGHT, handWithCards.getHand());
    }

    @Test
    void testForFlush() throws InvalidNumberOfCardsToEvaluateException {
        List<Card> cardsWithFlush = new ArrayList<>(5);
        cardsWithFlush.add(new Card(Suit.CLUB, Rank.KING));
        cardsWithFlush.add(new Card(Suit.CLUB, Rank.TEN));
        cardsWithFlush.add(new Card(Suit.CLUB, Rank.EIGHT));
        cardsWithFlush.add(new Card(Suit.CLUB, Rank.SEVEN));
        cardsWithFlush.add(new Card(Suit.CLUB, Rank.FIVE));

        HandWithCards handWithCards = handEvaluator.evaluate(cardsWithFlush);

        assertEquals(Hand.FLUSH, handWithCards.getHand());
    }

    @Test
    void testForFullHouse() throws InvalidNumberOfCardsToEvaluateException {
        List<Card> cardsWithFullHouse = new ArrayList<>(5);
        cardsWithFullHouse.add(new Card(Suit.HEART,     Rank.ACE));
        cardsWithFullHouse.add(new Card(Suit.HEART,     Rank.THREE));
        cardsWithFullHouse.add(new Card(Suit.CLUB,      Rank.ACE));
        cardsWithFullHouse.add(new Card(Suit.DIAMOND,   Rank.ACE));
        cardsWithFullHouse.add(new Card(Suit.SPADE,     Rank.THREE));

        HandWithCards handWithCards = handEvaluator.evaluate(cardsWithFullHouse);

        assertEquals(Hand.FULL_HOUSE, handWithCards.getHand());
    }

    @Test
    void testForFourOfAKind() throws InvalidNumberOfCardsToEvaluateException {
        List<Card> cardsWithFourOfAKind = new ArrayList<>(5);
        cardsWithFourOfAKind.add(new Card(Suit.HEART, Rank.NINE));
        cardsWithFourOfAKind.add(new Card(Suit.CLUB, Rank.NINE));
        cardsWithFourOfAKind.add(new Card(Suit.CLUB, Rank.FIVE));
        cardsWithFourOfAKind.add(new Card(Suit.SPADE, Rank.NINE));
        cardsWithFourOfAKind.add(new Card(Suit.DIAMOND, Rank.NINE));

        HandWithCards handWithCards = handEvaluator.evaluate(cardsWithFourOfAKind);

        assertEquals(Hand.FOUR_OF_A_KIND, handWithCards.getHand());
    }

    @Test
    void testForStraightFlush() throws InvalidNumberOfCardsToEvaluateException {
        List<Card> cardsWithStraightFlush = new ArrayList<>(5);
        cardsWithStraightFlush.add(new Card(Suit.SPADE, Rank.JACK));
        cardsWithStraightFlush.add(new Card(Suit.SPADE, Rank.EIGHT));
        cardsWithStraightFlush.add(new Card(Suit.SPADE, Rank.TEN));
        cardsWithStraightFlush.add(new Card(Suit.SPADE, Rank.SEVEN));
        cardsWithStraightFlush.add(new Card(Suit.SPADE, Rank.NINE));

        HandWithCards handWithCards = handEvaluator.evaluate(cardsWithStraightFlush);

        assertEquals(Hand.STRAIGHT_FLUSH, handWithCards.getHand());
    }

    @Test
    void testForRoyalFlush() throws InvalidNumberOfCardsToEvaluateException {
        List<Card> cardsWithRoyalFlush = new ArrayList<>(5);
        cardsWithRoyalFlush.add(new Card(Suit.DIAMOND, Rank.ACE));
        cardsWithRoyalFlush.add(new Card(Suit.DIAMOND, Rank.TEN));
        cardsWithRoyalFlush.add(new Card(Suit.DIAMOND, Rank.JACK));
        cardsWithRoyalFlush.add(new Card(Suit.DIAMOND, Rank.KING));
        cardsWithRoyalFlush.add(new Card(Suit.DIAMOND, Rank.QUEEN));

        HandWithCards handWithCards = handEvaluator.evaluate(cardsWithRoyalFlush);

        assertEquals(Hand.ROYAL_FLUSH, handWithCards.getHand());
    }

}
