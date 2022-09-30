package pl.andrzejmidura.fivehanddrawpoker.game.hand;

import pl.andrzejmidura.fivehanddrawpoker.game.utils.Card;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Rank;
import pl.andrzejmidura.fivehanddrawpoker.game.utils.Suit;

import java.util.Collections;
import java.util.List;

public class HandEvaluator {
    private final HandWithCards handWithCards = new HandWithCards();
    private List<Card> cardsSortedByRank;

    /**
     * This function evaluates cards.
     * The evaluation is achieved by processing multiple checks.
     * The order of checks is determined by hand specificity, eg:
     *  if we checked that there is a PAIR, then we have to check if there are TWO_PAIRS or THREE_OF_A_KIND etc.
     * For better understanding of how this function works, check hand_evaluation.jpg diagram
     * */
    public HandWithCards evaluate(List<Card> cards) throws InvalidNumberOfCardsToEvaluateException {
        if (cards.size() != 5) throw new InvalidNumberOfCardsToEvaluateException("Invalid number of cards passed in parameter; expected: 5, got: " + cards.size());

        this.cardsSortedByRank = cards;
        Collections.sort(cardsSortedByRank);

        if (savedFlush()) {
            if (!savedFullHouse()) {
                if (!savedFourOfAKind()) {
                    if (savedStraightFlush()) {
                        savedRoyalFlush();
                    }
                }
            }
        }
        else if (savedPair()){
            if (savedTwoPairs()) {
                savedFullHouse();
            }
            else if (savedThreeOfAKind()) {
                savedFourOfAKind();
            }
        }
        else {
            savedStraight();
        }

        return handWithCards;
    }

    private boolean savedFlush() {
        boolean isFlush = true;
        Suit suit = cardsSortedByRank.get(0).getSuit();

        for (int i = 1; i < 5; i++) {
            if (!suit.equals(cardsSortedByRank.get(i).getSuit())) {
                isFlush = false;
            }
        }

        if (isFlush) {
            handWithCards.setHand(Hand.FLUSH);
            handWithCards.setCards(cardsSortedByRank);
        }

        return isFlush;
    }
    private boolean savedFullHouse() {
        boolean isFullHouse = true;
        Rank card0rank = cardsSortedByRank.get(0).getRank();
        Rank card1rank = cardsSortedByRank.get(1).getRank();
        Rank card2rank = cardsSortedByRank.get(2).getRank();
        Rank card3rank = cardsSortedByRank.get(3).getRank();
        Rank card4rank = cardsSortedByRank.get(4).getRank();

        if (!card1rank.equals(card0rank)) {
            isFullHouse = false;
        }
        else if (!card3rank.equals(card4rank)) {
            isFullHouse = false;
        }
        else if (!card2rank.equals(card0rank) && !card2rank.equals(card4rank)) {
            isFullHouse = false;
        }

        if (isFullHouse) {
            handWithCards.setHand(Hand.FULL_HOUSE);
            handWithCards.setCards(cardsSortedByRank);
        }

        return isFullHouse;
    }
    private boolean savedFourOfAKind() {
        boolean isFourOfAKind = true;
        Card card0 = cardsSortedByRank.get(0);
        Card card1 = cardsSortedByRank.get(1);

        if (card0.getRank().equals(card1.getRank())) {
            for (int i=0; i<3; i++) {
                if (!cardsSortedByRank.get(i).getRank().equals(cardsSortedByRank.get(i+1).getRank())) {
                    isFourOfAKind = false;
                }
            }
            if (isFourOfAKind) {
                handWithCards.setHand(Hand.FOUR_OF_A_KIND);
                handWithCards.setCards(cardsSortedByRank.subList(0, 4));
            }
        }
        else {
            for (int i=1; i<4; i++) {
                if (!cardsSortedByRank.get(i).getRank().equals(cardsSortedByRank.get(i+1).getRank())) {
                    isFourOfAKind = false;
                }
            }
            if (isFourOfAKind) {
                handWithCards.setHand(Hand.FOUR_OF_A_KIND);
                handWithCards.setCards(cardsSortedByRank.subList(1, 5));
            }
        }

        return isFourOfAKind;
    }
    private boolean savedStraightFlush() {
        boolean isStraightFlush = isStraightFlush();

        if (isStraightFlush) {
            handWithCards.setHand(Hand.STRAIGHT_FLUSH);
            handWithCards.setCards(cardsSortedByRank);
        }

        return isStraightFlush;
    }
    private boolean savedRoyalFlush() {
        boolean isRoyalFlush = true;

        if (cardsSortedByRank.get(0).getRank().equals(Rank.TEN)) {
            isRoyalFlush = isStraightFlush();
        }
        else {
            isRoyalFlush = false;
        }

        if (isRoyalFlush) {
            handWithCards.setHand(Hand.ROYAL_FLUSH);
            handWithCards.setCards(cardsSortedByRank);
        }

        return isRoyalFlush;
    }
    private boolean savedPair() {
        boolean isPair = false;
        Card firstCardOfPair;
        Card secondCardOfPair;
        Card highCard = cardsSortedByRank.get(0);

        for (int i=0; i<3; i++) {
            firstCardOfPair = cardsSortedByRank.get(i);
            secondCardOfPair = cardsSortedByRank.get(i+1);
            if (firstCardOfPair.getRank().equals(secondCardOfPair.getRank())) {
                handWithCards.setHand(Hand.PAIR);
                handWithCards.setCards(List.of(firstCardOfPair, secondCardOfPair));
                isPair = true;
            }
            else if (highCard.compareTo(secondCardOfPair)<0) {
                highCard = secondCardOfPair;
            }
        }

        if (!isPair) {
            handWithCards.setHand(Hand.HIGH_CARD);
            handWithCards.setCards(List.of(highCard));
        }

        return isPair;
    }
    private boolean savedTwoPairs() {
        boolean isTwoPairs = false;
        Card card0 = cardsSortedByRank.get(0);
        Card card1 = cardsSortedByRank.get(1);
        Card card2 = cardsSortedByRank.get(2);
        Card card3 = cardsSortedByRank.get(3);
        Card card4 = cardsSortedByRank.get(4);

        // 1 1 2 2 3
        if (card0.getRank().equals(card1.getRank()) && card2.getRank().equals(card3.getRank()) && !card0.getRank().equals(card2.getRank())) {
            handWithCards.setHand(Hand.TWO_PAIRS);
            handWithCards.setCards(List.of(card0, card1, card2, card3));
            isTwoPairs = true;
        }
        // 1 1 3 2 2
        else if (card0.getRank().equals(card1.getRank()) && card3.getRank().equals(card4.getRank()) && !card0.getRank().equals(card3.getRank())) {
            handWithCards.setHand(Hand.TWO_PAIRS);
            handWithCards.setCards(List.of(card0, card1, card3, card4));
            isTwoPairs = true;
        }
        // 3 1 1 2 2
        else if (card1.getRank().equals(card2.getRank()) && card3.getRank().equals(card4.getRank()) && !card1.getRank().equals(card3.getRank())) {
            handWithCards.setHand(Hand.TWO_PAIRS);
            handWithCards.setCards(List.of(card1, card2, card3, card4));
            isTwoPairs = true;
        }

        return isTwoPairs;
    }
    private boolean savedThreeOfAKind() {
        boolean isThreeOfAKind = false;
        Card firstCardOfThree;
        Card secondCardOfThree;
        Card thirdCardOfThree;

        for (int i=0; i<2; i++) {
            firstCardOfThree = cardsSortedByRank.get(i);
            secondCardOfThree = cardsSortedByRank.get(i+1);
            thirdCardOfThree = cardsSortedByRank.get(i+2);
            if (firstCardOfThree.getRank().equals(secondCardOfThree.getRank()) && secondCardOfThree.getRank().equals(thirdCardOfThree.getRank())) {
                handWithCards.setHand(Hand.THREE_OF_A_KIND);
                handWithCards.setCards(List.of(firstCardOfThree, secondCardOfThree, thirdCardOfThree));
                isThreeOfAKind = true;
            }
        }

        return isThreeOfAKind;
    }
    private boolean savedStraight() {
        boolean isStraight = true;

        for (int i = 1; i < 5; i++) {
            Card previousCard = cardsSortedByRank.get(i-1);
            Card nextCard = cardsSortedByRank.get(i);
            if (previousCard.getRank().compareTo(nextCard.getRank())!=-1) {
                isStraight = false;
            }
        }

        if (isStraight) {
            handWithCards.setHand(Hand.STRAIGHT);
            handWithCards.setCards(cardsSortedByRank);
        }
        return isStraight;
    }
    private boolean isStraightFlush() {
        Suit suit = cardsSortedByRank.get(0).getSuit();
        boolean result = true;

        for (int i = 1; i < 5; i++) {
            Card previousCard = cardsSortedByRank.get(i-1);
            Card nextCard = cardsSortedByRank.get(i);
            if (!suit.equals(cardsSortedByRank.get(i).getSuit()) || previousCard.getRank().compareTo(nextCard.getRank())!=-1) {
                result = false;
            }
        }
        return result;
    }

}
