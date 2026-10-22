package com.champlain.oop2assignment3;

import java.util.Comparator;

/**
 * Compares two Card objects by suit in reverse order. If the cards have the
 * same suit, they are compared by rank in reverse order.
 */
public class ReverseSuitFirstComparator implements Comparator<Card> {
    /**
     * Compares two cards first by suit in reverse order, and then by rank in
     * reverse order if the suits are the same.
     *
     * @param pCard1 the first card to be compared
     * @param pCard2 the second card to be compared
     * @return a negative integer, zero, or a positive integer as the first card
     * is less than, equal to, or greater than the second card
     * @author Owen Huxter
     */
    @Override
    public int compare(Card pCard1, Card pCard2) {
        // Compare by suit first (in reverse order)
        int suitComparison = pCard2.getSuit().compareTo(pCard1.getSuit());
        if (suitComparison != 0) {
            return suitComparison;
        }
        // If suits are the same, compare by rank (in reverse order)
        return pCard2.getRank().compareTo(pCard1.getRank());
    }

}
