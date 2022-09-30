package pl.andrzejmidura.fivehanddrawpoker.game.hand;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Card;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Rank;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Suit;

import java.util.List;

public class HandComparatorTest {
    HandComparator handComparator = new HandComparator();

    @Test
    void testHighCardAndPairComparison() {
        List<Card> highCard = List.of(new Card(Suit.HEART, Rank.ACE));
        List<Card> pair = List.of(new Card(Suit.CLUB, Rank.NINE),
                                  new Card(Suit.SPADE, Rank.NINE));
        HandWithCards handWithHighCard = new HandWithCards(Hand.HIGH_CARD, highCard);
        HandWithCards handWithPair = new HandWithCards(Hand.PAIR, pair);

        int result = handComparator.compare(handWithHighCard, handWithPair);

        assertEquals(-1, result);
    }

    @Test
    void testPairAndTwoPairsComparison() {
        List<Card> pair = List.of(new Card(Suit.CLUB, Rank.NINE),
                                  new Card(Suit.SPADE, Rank.NINE));
        List<Card> twoPairs = List.of(new Card(Suit.HEART, Rank.FIVE),
                                      new Card(Suit.SPADE, Rank.TWO),
                                      new Card(Suit.DIAMOND, Rank.TWO),
                                      new Card(Suit.CLUB, Rank.FIVE));
        HandWithCards handWithPair = new HandWithCards(Hand.PAIR, pair);
        HandWithCards handWithTwoPairs = new HandWithCards(Hand.TWO_PAIRS, twoPairs);

        int result = handComparator.compare(handWithPair, handWithTwoPairs);

        assertEquals(-1, result);
    }

    @Test
    void testTwoPairsAndThreeOfAKindComparison() {
        List<Card> twoPairs = List.of(new Card(Suit.HEART, Rank.FIVE),
                                      new Card(Suit.SPADE, Rank.TWO),
                                      new Card(Suit.DIAMOND, Rank.TWO),
                                      new Card(Suit.CLUB, Rank.FIVE));
        List<Card> threeOfAKind = List.of(new Card(Suit.CLUB, Rank.NINE),
                                          new Card(Suit.SPADE, Rank.NINE),
                                          new Card(Suit.HEART, Rank.NINE));
        HandWithCards handWithTwoPairs = new HandWithCards(Hand.TWO_PAIRS, twoPairs);
        HandWithCards handWithThreeOfAKind = new HandWithCards(Hand.THREE_OF_A_KIND, threeOfAKind);

        int result = handComparator.compare(handWithTwoPairs, handWithThreeOfAKind);

        assertEquals(-1, result);
    }

    @Test
    void testThreeOfAKindAndStraightComparison() {
        List<Card> threeOfAKind = List.of(new Card(Suit.CLUB, Rank.NINE),
                                          new Card(Suit.SPADE, Rank.NINE),
                                          new Card(Suit.HEART, Rank.NINE));
        List<Card> straight = List.of(new Card(Suit.HEART,      Rank.TEN),
                                      new Card(Suit.CLUB,       Rank.EIGHT),
                                      new Card(Suit.SPADE,      Rank.NINE),
                                      new Card(Suit.DIAMOND,    Rank.SIX),
                                      new Card(Suit.HEART,      Rank.SEVEN));
        HandWithCards handWithThreeOfAKind = new HandWithCards(Hand.THREE_OF_A_KIND, threeOfAKind);
        HandWithCards handWithStraight = new HandWithCards(Hand.STRAIGHT, straight);

        int result = handComparator.compare(handWithThreeOfAKind, handWithStraight);

        assertEquals(-1, result);
    }

    @Test
    void testStraightAndFlushComparison() {
        List<Card> straight = List.of(new Card(Suit.HEART,      Rank.TEN),
                                      new Card(Suit.CLUB,       Rank.EIGHT),
                                      new Card(Suit.SPADE,      Rank.NINE),
                                      new Card(Suit.DIAMOND,    Rank.SIX),
                                      new Card(Suit.HEART,      Rank.SEVEN));
        List<Card> flush = List.of(new Card(Suit.CLUB, Rank.KING),
                                   new Card(Suit.CLUB, Rank.TEN),
                                   new Card(Suit.CLUB, Rank.EIGHT),
                                   new Card(Suit.CLUB, Rank.SEVEN),
                                   new Card(Suit.CLUB, Rank.FIVE));
        HandWithCards handWithStraight = new HandWithCards(Hand.STRAIGHT, straight);
        HandWithCards handWithFlush = new HandWithCards(Hand.FLUSH, flush);

        int result = handComparator.compare(handWithStraight, handWithFlush);

        assertEquals(-1, result);
    }

    @Test
    void testFlushAndFullHouseComparison() {
        List<Card> flush = List.of(new Card(Suit.CLUB, Rank.KING),
                                   new Card(Suit.CLUB, Rank.TEN),
                                   new Card(Suit.CLUB, Rank.EIGHT),
                                   new Card(Suit.CLUB, Rank.SEVEN),
                                   new Card(Suit.CLUB, Rank.FIVE));
        List<Card> fullHouse = List.of(new Card(Suit.HEART,     Rank.ACE),
                                       new Card(Suit.HEART,     Rank.THREE),
                                       new Card(Suit.CLUB,      Rank.ACE),
                                       new Card(Suit.DIAMOND,   Rank.ACE),
                                       new Card(Suit.SPADE,     Rank.THREE));
        HandWithCards handWithFlush = new HandWithCards(Hand.FLUSH, flush);
        HandWithCards handWithFullHouse = new HandWithCards(Hand.FULL_HOUSE, fullHouse);

        int result = handComparator.compare(handWithFlush, handWithFullHouse);

        assertEquals(-1, result);
    }

    @Test
    void testFullHouseAndFourOfAKindComparison() {
        List<Card> fullHouse = List.of(new Card(Suit.HEART,     Rank.ACE),
                                       new Card(Suit.HEART,     Rank.THREE),
                                       new Card(Suit.CLUB,      Rank.ACE),
                                       new Card(Suit.DIAMOND,   Rank.ACE),
                                       new Card(Suit.SPADE,     Rank.THREE));
        List<Card> fourOfAKind = List.of(new Card(Suit.HEART, Rank.NINE),
                                         new Card(Suit.CLUB, Rank.NINE),
                                         new Card(Suit.SPADE, Rank.NINE),
                                         new Card(Suit.DIAMOND, Rank.NINE));
        HandWithCards handWithFullHouse = new HandWithCards(Hand.FULL_HOUSE, fullHouse);
        HandWithCards handWithFourOfAKind = new HandWithCards(Hand.FOUR_OF_A_KIND, fourOfAKind);

        int result = handComparator.compare(handWithFullHouse, handWithFourOfAKind);

        assertEquals(-1, result);
    }

    @Test
    void testFourOfAKindAndStraightFlushComparison() {
        List<Card> fourOfAKind = List.of(new Card(Suit.HEART, Rank.NINE),
                                         new Card(Suit.CLUB, Rank.NINE),
                                         new Card(Suit.SPADE, Rank.NINE),
                                         new Card(Suit.DIAMOND, Rank.NINE));
        List<Card> straightFlush = List.of(new Card(Suit.SPADE, Rank.JACK),
                                           new Card(Suit.SPADE, Rank.EIGHT),
                                           new Card(Suit.SPADE, Rank.TEN),
                                           new Card(Suit.SPADE, Rank.SEVEN),
                                           new Card(Suit.SPADE, Rank.NINE));
        HandWithCards handWithFourOfAKind = new HandWithCards(Hand.FOUR_OF_A_KIND, fourOfAKind);
        HandWithCards handWithStraightFlush = new HandWithCards(Hand.STRAIGHT_FLUSH, straightFlush);

        int result = handComparator.compare(handWithFourOfAKind, handWithStraightFlush);

        assertEquals(-1, result);
    }

    @Test
    void testStraightFlushAndRoyalFlushComparison() {
        List<Card> straightFlush = List.of(new Card(Suit.SPADE, Rank.JACK),
                                           new Card(Suit.SPADE, Rank.EIGHT),
                                           new Card(Suit.SPADE, Rank.TEN),
                                           new Card(Suit.SPADE, Rank.SEVEN),
                                           new Card(Suit.SPADE, Rank.NINE));
        List<Card> royalFlush = List.of(new Card(Suit.DIAMOND, Rank.ACE),
                                        new Card(Suit.DIAMOND, Rank.TEN),
                                        new Card(Suit.DIAMOND, Rank.JACK),
                                        new Card(Suit.DIAMOND, Rank.KING),
                                        new Card(Suit.DIAMOND, Rank.QUEEN));
        HandWithCards handWithStraightFlush = new HandWithCards(Hand.STRAIGHT_FLUSH, straightFlush);
        HandWithCards handWithRoyalFlush = new HandWithCards(Hand.ROYAL_FLUSH, royalFlush);

        int result = handComparator.compare(handWithStraightFlush, handWithRoyalFlush);

        assertEquals(-1, result);
    }

    @Test
    void testStrongerHighCardToWeakerHighCardComparison() {
        List<Card> strongerHighCard = List.of(new Card(Suit.HEART, Rank.ACE));
        List<Card> weakerHighCard = List.of(new Card(Suit.CLUB, Rank.NINE));
        HandWithCards handWithStrongerHighCard = new HandWithCards(Hand.HIGH_CARD, strongerHighCard);
        HandWithCards handWithWeakerHighCard = new HandWithCards(Hand.HIGH_CARD, weakerHighCard);

        int result = handComparator.compare(handWithWeakerHighCard, handWithStrongerHighCard);

        assertEquals(-1, result);
    }

    @Test
    void testStrongerPairToWeakerPairComparison() {
        List<Card> strongerPair = List.of(
                new Card(Suit.CLUB, Rank.JACK),
                new Card(Suit.SPADE, Rank.JACK));
        List<Card> weakerPair = List.of(
                new Card(Suit.CLUB, Rank.NINE),
                new Card(Suit.SPADE, Rank.NINE));
        HandWithCards handWithStrongerPair = new HandWithCards(Hand.PAIR, strongerPair);
        HandWithCards handWithWeakerPair = new HandWithCards(Hand.PAIR, weakerPair);

        int result = handComparator.compare(handWithWeakerPair, handWithStrongerPair);

        assertEquals(-1, result);
    }

    @Test
    void testStrongerTwoPairsToWeakerTwoPairsComparison() {
        List<Card> strongerTwoPairs = List.of(
                new Card(Suit.HEART, Rank.FIVE),
                new Card(Suit.SPADE, Rank.TWO),
                new Card(Suit.DIAMOND, Rank.TWO),
                new Card(Suit.CLUB, Rank.FIVE));
        List<Card> weakerTwoPairs = List.of(
                new Card(Suit.HEART, Rank.FIVE),
                new Card(Suit.SPADE, Rank.TWO),
                new Card(Suit.DIAMOND, Rank.TWO),
                new Card(Suit.CLUB, Rank.FIVE));
        HandWithCards handWithStrongerTwoPairs = new HandWithCards(Hand.TWO_PAIRS, strongerTwoPairs);
        HandWithCards handWithWeakerTwoPairs = new HandWithCards(Hand.TWO_PAIRS, weakerTwoPairs);

        int result = handComparator.compare(handWithWeakerTwoPairs, handWithStrongerTwoPairs);

        assertEquals(-1, result);
    }

    @Test
    void testStrongerThreeOfAKindToWeakerThreeOfAKindComparison() {
        List<Card> strongerThreeOfAKind = List.of(
                new Card(Suit.SPADE, Rank.TEN),
                new Card(Suit.CLUB, Rank.TEN),
                new Card(Suit.HEART, Rank.TEN));
        List<Card> weakerThreeOfAKind = List.of(
                new Card(Suit.CLUB, Rank.NINE),
                new Card(Suit.SPADE, Rank.NINE),
                new Card(Suit.HEART, Rank.NINE));
        HandWithCards handWithStrongerThreeOfAKind = new HandWithCards(Hand.THREE_OF_A_KIND, strongerThreeOfAKind);
        HandWithCards handWithWeakerThreeOfAKind = new HandWithCards(Hand.THREE_OF_A_KIND, weakerThreeOfAKind);

        int result = handComparator.compare(handWithWeakerThreeOfAKind, handWithStrongerThreeOfAKind);

        assertEquals(-1, result);
    }

    @Test
    void testStrongerStraightToWeakerStraightComparison() {
        List<Card> strongerStraight = List.of(
                new Card(Suit.HEART,      Rank.TEN),
                new Card(Suit.DIAMOND,    Rank.SIX),
                new Card(Suit.CLUB,       Rank.EIGHT),
                new Card(Suit.SPADE,      Rank.NINE),
                new Card(Suit.HEART,      Rank.SEVEN));
        List<Card> weakerStraight = List.of(
                new Card(Suit.CLUB,       Rank.EIGHT),
                new Card(Suit.HEART,      Rank.TEN),
                new Card(Suit.DIAMOND,    Rank.SIX),
                new Card(Suit.SPADE,      Rank.NINE),
                new Card(Suit.HEART,      Rank.JACK));
        HandWithCards handWithStrongerStraight = new HandWithCards(Hand.STRAIGHT, strongerStraight);
        HandWithCards handWithWeakerStraight = new HandWithCards(Hand.STRAIGHT, weakerStraight);

        int result = handComparator.compare(handWithWeakerStraight, handWithStrongerStraight);

        assertEquals(-1, result);
    }

    @Test
    void testStrongerFlushToWeakerFlushComparison() {
        List<Card> strongerFlush = List.of(
                new Card(Suit.DIAMOND, Rank.EIGHT),
                new Card(Suit.DIAMOND, Rank.KING),
                new Card(Suit.DIAMOND, Rank.SEVEN),
                new Card(Suit.DIAMOND, Rank.TEN),
                new Card(Suit.DIAMOND, Rank.FIVE));
        List<Card> weakerFlush = List.of(
                new Card(Suit.CLUB, Rank.TEN),
                new Card(Suit.CLUB, Rank.KING),
                new Card(Suit.CLUB, Rank.SEVEN),
                new Card(Suit.CLUB, Rank.EIGHT),
                new Card(Suit.CLUB, Rank.FIVE));
        HandWithCards handWithStrongerFlush = new HandWithCards(Hand.FLUSH, strongerFlush);
        HandWithCards handWithWeakerFlush = new HandWithCards(Hand.FLUSH, weakerFlush);

        int result = handComparator.compare(handWithWeakerFlush, handWithStrongerFlush);

        assertEquals(-1, result);
    }

    @Test
    void testStrongerFullHouseToWeakerFullHouseComparison() {
        List<Card> strongerFullHouse = List.of(
                new Card(Suit.HEART,     Rank.ACE),
                new Card(Suit.HEART,     Rank.THREE),
                new Card(Suit.CLUB,      Rank.ACE),
                new Card(Suit.DIAMOND,   Rank.ACE),
                new Card(Suit.SPADE,     Rank.THREE));
        List<Card> weakerFullHouse = List.of(
                new Card(Suit.HEART,     Rank.KING),
                new Card(Suit.HEART,     Rank.THREE),
                new Card(Suit.CLUB,      Rank.KING),
                new Card(Suit.DIAMOND,   Rank.KING),
                new Card(Suit.SPADE,     Rank.THREE));
        HandWithCards handWithStrongerFullHouse = new HandWithCards(Hand.FULL_HOUSE, strongerFullHouse);
        HandWithCards handWithWeakerFullHouse = new HandWithCards(Hand.FULL_HOUSE, weakerFullHouse);

        int result = handComparator.compare(handWithWeakerFullHouse, handWithStrongerFullHouse);

        assertEquals(-1, result);
    }

    @Test
    void testStrongerFourOfAKindToWeakerFourOfAKindComparison() {
        List<Card> strongerFourOfAKind = List.of(
                new Card(Suit.HEART, Rank.TEN),
                new Card(Suit.SPADE, Rank.TEN),
                new Card(Suit.CLUB, Rank.TEN),
                new Card(Suit.DIAMOND, Rank.TEN));
        List<Card> weakerFourOfAKind = List.of(
                new Card(Suit.CLUB, Rank.NINE),
                new Card(Suit.SPADE, Rank.NINE),
                new Card(Suit.HEART, Rank.NINE),
                new Card(Suit.DIAMOND, Rank.NINE));
        HandWithCards handWithStrongerFourOfAKind = new HandWithCards(Hand.FOUR_OF_A_KIND, strongerFourOfAKind);
        HandWithCards handWithWeakerFourOfAKind = new HandWithCards(Hand.FOUR_OF_A_KIND, weakerFourOfAKind);

        int result = handComparator.compare(handWithWeakerFourOfAKind, handWithStrongerFourOfAKind);

        assertEquals(-1, result);
    }

    @Test
    void testStrongerStraightFlushToWeakerStraightFlushComparison() {
        List<Card> strongerStraightFlush = List.of(
                new Card(Suit.SPADE, Rank.JACK),
                new Card(Suit.SPADE, Rank.EIGHT),
                new Card(Suit.SPADE, Rank.TEN),
                new Card(Suit.SPADE, Rank.SEVEN),
                new Card(Suit.SPADE, Rank.NINE));
        List<Card> weakerStraightFlush = List.of(
                new Card(Suit.DIAMOND, Rank.EIGHT),
                new Card(Suit.DIAMOND, Rank.SEVEN),
                new Card(Suit.DIAMOND, Rank.TEN),
                new Card(Suit.DIAMOND, Rank.SIX),
                new Card(Suit.DIAMOND, Rank.NINE));
        HandWithCards handWithStrongerStraightFlush = new HandWithCards(Hand.STRAIGHT_FLUSH, strongerStraightFlush);
        HandWithCards handWithWeakerStraightFlush = new HandWithCards(Hand.STRAIGHT_FLUSH, weakerStraightFlush);

        int result = handComparator.compare(handWithWeakerStraightFlush, handWithStrongerStraightFlush);

        assertEquals(-1, result);
    }

    @Test
    void testStrongerRoyalFlushToWeakerRoyalFlushComparison() {
        List<Card> strongerRoyalFlush = List.of(
                new Card(Suit.HEART, Rank.ACE),
                new Card(Suit.HEART, Rank.TEN),
                new Card(Suit.HEART, Rank.JACK),
                new Card(Suit.HEART, Rank.KING),
                new Card(Suit.HEART, Rank.QUEEN));
        List<Card> weakerRoyalFlush = List.of(
                new Card(Suit.DIAMOND, Rank.ACE),
                new Card(Suit.DIAMOND, Rank.TEN),
                new Card(Suit.DIAMOND, Rank.JACK),
                new Card(Suit.DIAMOND, Rank.KING),
                new Card(Suit.DIAMOND, Rank.QUEEN));
        HandWithCards handWithStrongerRoyalFlush = new HandWithCards(Hand.ROYAL_FLUSH, strongerRoyalFlush);
        HandWithCards handWithWeakerRoyalFlush = new HandWithCards(Hand.ROYAL_FLUSH, weakerRoyalFlush);

        int result = handComparator.compare(handWithWeakerRoyalFlush, handWithStrongerRoyalFlush);

        assertEquals(-1, result);
    }

}
