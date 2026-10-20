package com.champlain.oop2assignment3;

import java.util.Comparator;

/**
 * Comparator for the comparison of 2 Card objects, starting with their respective suit.
 * <p>
 * This class allows to compare 2 Card objects to each other through their suit first.
 * Their suits are compared in descending order.
 * </p>
 *
 * @author Sydney Gendron
 */
public class ReverseSuitFirstComparator implements Comparator<Card> {
    /**
     * Compares 2 Card objects to each other, starting with their respective suit.
     *
     * @param card1 The first object to be compared.
     * @param card2 The second object to be compared.
     * @return rankDifference if the objects' suits are equal (0), or suitDifference if they are different.
     */
    @Override
    public int compare(Card card1, Card card2) {
        int rankDifference = card2.getRank().compareTo(card1.getRank());
        int suitDifference = card2.getSuit().ordinal() - card1.getSuit().ordinal();

        if (suitDifference == 0) {
            return rankDifference;
        } else {
            return suitDifference;
        }
    }
}
