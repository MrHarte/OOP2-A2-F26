package com.champlain.oop2assignment3;

import java.util.Comparator;

public class ReverseSuitFirstComparator implements Comparator<Card> {
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
