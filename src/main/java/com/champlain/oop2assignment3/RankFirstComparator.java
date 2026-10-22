package com.champlain.oop2assignment3;

import java.util.Comparator;

/**
 *
 Comparator that sorts cards by rank first, then by suit if ranks are equal.
 * @implNote The comparison relies on the ordinal values of the {@code Rank} enum.
 **/
public class RankFirstComparator implements Comparator<Card> {

    /**
     * Compares two Card objects.
     * Cards are sorted by rank first.
     * If both cards have the same rank, they are sorted by suit.
     * @param card1 the first card to compare
     * @param card2 the second card to compare
     * @return a negative number if card1 comes before card2,
     * a positive number if card1 comes after card2 or 0 if they are equal
     */

    @Override
    public int compare(Card card1, Card card2) {
        int compareRank = card1.getRank().ordinal() - card2.getRank().ordinal();

        if (compareRank != 0) {
            return compareRank;
        }
        return card1.getSuit().ordinal() - card2.getSuit().ordinal();
    }
}