package com.champlain.oop2assignment3;

import java.util.Comparator;

public class ReverseSuitFirstComparator implements Comparator<Card> {

    @Override
    public int compare(Card pCard1, Card pCard2) {
        int rankDiff = pCard1.getRank().compareTo(pCard2.getRank());
        int suitDiff = pCard1.getSuit().ordinal() - pCard2.getSuit().ordinal();

        if (suitDiff == 0) {
            return rankDiff;
        } else {
            return suitDiff;
        }
    }
}
