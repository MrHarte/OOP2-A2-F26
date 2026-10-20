package com.champlain.oop2assignment3;

import java.util.Comparator;

public class ReverseRankFirstComparator implements Comparator<Card> {
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
