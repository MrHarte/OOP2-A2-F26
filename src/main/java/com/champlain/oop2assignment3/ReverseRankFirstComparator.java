package com.champlain.oop2assignment3;

import java.util.Comparator;

/**
 * Comparator for the comparison of 2 Card objects, starting with their respective rank.
 * <p>
 * This class allows to compare 2 Card objects to each other through their rank first.
 * Their ranks are compared in descending order.
 * </p>
 *
 * @author Sydney Gendron
 */
public class ReverseRankFirstComparator implements Comparator<Card> {
    /**
     * Compares 2 Card objects to each other, starting with their respective rank.
     *
     * @param card1 The first object to be compared.
     * @param card2 The second object to be compared.
     * @return suitDifference if the object's ranks are equal (0), or rankDifference if they are different.
     */
    @Override
    public int compare(Card card1, Card card2) {
        int rankDifference = card2.getRank().compareTo(card1.getRank());
        int suitDifference = card1.getSuit().ordinal() - card2.getSuit().ordinal();

        if (rankDifference == 0) {
            return suitDifference;
        } else {
            return rankDifference;
        }
    }
}
