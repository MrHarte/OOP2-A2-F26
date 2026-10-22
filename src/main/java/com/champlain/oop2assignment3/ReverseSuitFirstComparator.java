package com.champlain.oop2assignment3;

import java.util.Comparator;

/**
 * Compares cards by suit first in reversed order, then by rank.
 */
public class ReverseSuitFirstComparator implements Comparator<Card> {

    /**
     * Compares two cards by their suits and ranks.
     *
     * @param pCard1 the first card
     * @param pCard2 the second card
     * @return the comparison result
     */
    @Override
    public int compare(Card pCard1, Card pCard2) {
        int rankDiff = pCard1.getRank().compareTo(pCard2.getRank());
        int suitDiff = pCard2.getSuit().ordinal() - pCard1.getSuit().ordinal();

        if (suitDiff == 0) {
            return rankDiff;
        } else {
            return suitDiff;
        }
    }
}
