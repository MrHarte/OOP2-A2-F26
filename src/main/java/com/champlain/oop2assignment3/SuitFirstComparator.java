package com.champlain.oop2assignment3;

import java.util.Comparator;

/**
 * Comparator that sorts cards by suit first.
 * If two cards have the same suit, they are sorted by rank.
 */

public class SuitFirstComparator implements Comparator<Card> {

    /**
     * Compares two cards.
     * Cards are first compared by suit. If the suits are the same,
     * the cards are then compared by rank.
     *
     * @param card1 the first card to compare
     * @param card2 the second card to compare
     * @return a negative number if card1 comes before card2,
     * zero if they are equal,
     * a positive number if card1 comes after card2
     */

    @Override
    public int compare(Card card1, Card card2) {
        // Compare the suits of both cards using their ordinal values
        int compareSuit = card1.getSuit().ordinal() - card2.getSuit().ordinal();

        // If the suits are different, return the suit comparison result
        if (compareSuit != 0) {
            return compareSuit;
        }
        // If suits are the same, compare the ranks
        return card1.getRank().ordinal() - card2.getRank().ordinal();
    }
}