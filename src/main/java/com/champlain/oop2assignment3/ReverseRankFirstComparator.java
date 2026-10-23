package com.champlain.oop2assignment3;
import java.util.Comparator;

/**
 * class allows for sorting a deck by the rank first but in reverse
 * returns the difference between the cards from rank first then suits
 */
public class ReverseRankFirstComparator implements Comparator<Card> {
    /**
     * compares the cards
     *
     * @param card1 the first object to be compared.
     * @param card2 the second object to be compared.
     * @return the difference of the rank, if the ranks are the same will return the difference in the suits instead
     */
    @Override
    public int compare(Card card1, Card card2) {
        int rankDiff = card2.getRank().compareTo(card1.getRank());
        int suitDiff = card1.getSuit().ordinal() - card2.getSuit().ordinal();

        if (rankDiff == 0)
            return suitDiff;
        else
            return rankDiff;
    }
}
