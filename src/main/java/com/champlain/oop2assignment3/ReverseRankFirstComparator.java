package com.champlain.oop2assignment3;

import java.util.Comparator;

/**
 *Comparator for sorting Card objects by Rank in descending order
 *<p>
 *If two cards have the same rank, they are then sub-sorted by their
 *suit in ascending order.
 *</p>
 */
public class ReverseRankFirstComparator implements Comparator<Card> {
    /**
     * Compares two cards for ordering.
     *
     * @param card1 the first object to be compared.
     * @param card2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first card
     * is less than, equal to, or greater than the second card based on
     * descending rank, then ascending suit ordering.
     */
    @Override
    public int compare(Card card1, Card card2) {
        int rankDiff = card2.getRank().compareTo(card1.getRank());
        int suitDiff = card1.getSuit().compareTo(card2.getSuit());
        if (rankDiff == 0) {
            return suitDiff;
        } else {
            return rankDiff;
        }
    }
}
