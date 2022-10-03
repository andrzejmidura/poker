package pl.andrzejmidura.fivehanddrawpoker.game.hand;

import pl.andrzejmidura.fivehanddrawpoker.game.utils.Card;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HandComparator implements Comparator<HandWithCards> {
    @Override
    public int compare(HandWithCards o1, HandWithCards o2) {
        int result;
        if (o1.getHand().equals(o2.getHand())) result = compareSameHands(o1, o2);
        else result = o1.getHand().compareTo(o2.getHand());

        return normalize(result);
    }

    private int compareSameHands(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        int result;

        switch(handWithCards1.getHand()) {
            case HIGH_CARD ->       result = compareHighCard(handWithCards1, handWithCards2);
            case PAIR ->            result = comparePair(handWithCards1, handWithCards2);
            case TWO_PAIRS ->       result = compareTwoPairs(handWithCards1, handWithCards2);
            case THREE_OF_A_KIND -> result = compareThreeOfAKind(handWithCards1, handWithCards2);
            case STRAIGHT ->        result = compareStraight(handWithCards1, handWithCards2);
            case FLUSH ->           result = compareFlush(handWithCards1, handWithCards2);
            case FULL_HOUSE ->      result = compareFullHouse(handWithCards1, handWithCards2);
            case FOUR_OF_A_KIND ->  result = compareFourOfAKind(handWithCards1, handWithCards2);
            case STRAIGHT_FLUSH ->  result = compareStraightFlush(handWithCards1, handWithCards2);
            case ROYAL_FLUSH ->     result = compareRoyalFlush(handWithCards1, handWithCards2);
            default ->              throw new RuntimeException("Unable to compare hand: " + handWithCards1.getHand());
        }
        return result;
    }

    private int normalize(int result) {
        return Integer.compare(result, 0);
    }

    private int compareRoyalFlush(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        return 0;
    }
    private int compareStraightFlush(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        return compareStraight(handWithCards1, handWithCards2);
    }
    private int compareFourOfAKind(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        int result = handWithCards1.getCardsRepresentingHand().get(0)
                .compareTo(handWithCards2.getCardsRepresentingHand().get(0));
        if (result==0) {
            throw new RuntimeException("Two FourOfAKind of the same rank can't exist! " + handWithCards1 + "\n" + handWithCards2);
        }
        return result;
    }
    private int compareFullHouse(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        return compareThreeOfAKind(handWithCards1, handWithCards2);
    }
    private int compareFlush(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        return compareCards(handWithCards1.getCardsRepresentingHand(), handWithCards2.getCardsRepresentingHand());
    }
    private int compareStraight(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        return handWithCards1.getCardsRepresentingHand().get(0)
                .compareTo(handWithCards2.getCardsRepresentingHand().get(0));
    }
    private int compareThreeOfAKind(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        int result = handWithCards1.getCardsRepresentingHand().get(0)
                .compareTo(handWithCards2.getCardsRepresentingHand().get(0));
        if (result==0) {
            throw new RuntimeException("Two ThreeOfAKind of the same rank can't exist! " + handWithCards1 + "\n" + handWithCards2);
        }
        return result;
    }
    private int compareTwoPairs(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        int result = handWithCards1.getCardsRepresentingHand().get(2)
                .compareTo(handWithCards2.getCardsRepresentingHand().get(2));
        if (result==0) {
            result = handWithCards1.getCardsRepresentingHand().get(0)
                    .compareTo(handWithCards2.getCardsRepresentingHand().get(0));
        }
        return result!=0 ? result : compareKickers(handWithCards1, handWithCards2);
    }
    private int comparePair(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        int result = handWithCards1.getCardsRepresentingHand().get(0)
                .compareTo(handWithCards2.getCardsRepresentingHand().get(0));
        return result!=0 ? result : compareKickers(handWithCards1, handWithCards2);
    }
    private int compareHighCard(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        Card card1 = handWithCards1.getCardsRepresentingHand().get(0);
        Card card2 = handWithCards2.getCardsRepresentingHand().get(0);
        return card1.compareTo(card2);
    }
    private int compareKickers(HandWithCards handWithCards1, HandWithCards handWithCards2) {
        List<Card> cardsWithoutHand1 = getSortedCardsWithoutHand(handWithCards1);
        List<Card> cardsWithoutHand2 = getSortedCardsWithoutHand(handWithCards2);
        return compareCards(cardsWithoutHand1, cardsWithoutHand2);

    }
    private List<Card> getSortedCardsWithoutHand(HandWithCards handWithCards) {
        List<Card> cardsWithoutHand = handWithCards.getAllCards();
        cardsWithoutHand.removeAll(handWithCards.getCardsRepresentingHand());
        cardsWithoutHand.sort(Collections.reverseOrder());
        return cardsWithoutHand;
    }
    private int compareCards(List<Card> cards1, List<Card> cards2) {
        cards1.sort(Collections.reverseOrder());
        cards2.sort(Collections.reverseOrder());
        int result;
        for (int i=0; i<cards1.size(); i++) {
            result = cards1.get(i).compareTo(cards2.get(i));
            if (result!=0) return result;
        }
        return 0;
    }
}
