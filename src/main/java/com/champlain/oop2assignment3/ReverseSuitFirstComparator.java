package com.champlain.oop2assignment3;

import java.util.Comparator;

public class ReverseSuitFirstComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        int rankDifference = card1.getRank().compareTo(card2.getRank());
        int suitDifference = card2.getSuit().ordinal() - card1.getSuit().ordinal();

        if (suitDifference == 0) {
            return rankDifference;
        } else {
            return suitDifference;
        }
    }
}
