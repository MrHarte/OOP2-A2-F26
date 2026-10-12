package com.champlain.oop2assignment3;

import java.util.Comparator;

/**
 *Comparator for sorting Card objects by Suit in descending order
 *<p>
 *If two cards have the same suit, they are then sub-sorted by their
 *rank in ascending order.
 *</p>
 */
public class ReverseSuitFirstComparator implements Comparator<Card> {
    /**
     * Compares two cards for ordering.
     *
     * @param card1 the first object to be compared.
     * @param card2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first card
     * is less than, equal to, or greater than the second card based on
     * descending suit, then ascending rank ordering.
     */
    @Override
    public int compare(Card card1, Card card2) {
        int rankDiff = card1.getRank().compareTo(card2.getRank());
        int suitDiff = card2.getSuit().compareTo(card1.getSuit());
        if (suitDiff == 0) {
            return rankDiff;
        } else {
            return suitDiff;
        }
    }
}
