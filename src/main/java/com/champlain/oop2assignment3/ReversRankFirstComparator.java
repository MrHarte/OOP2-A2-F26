package com.champlain.oop2assignment3;
import java.util.Comparator;

public class ReversRankFirstComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        int rankDiff = card2.getRank().compareTo(card1.getRank());
        int suitDiff = card1.getSuit().ordinal() - card2.getSuit().ordinal();

        if (rankDiff == 0)
            return suitDiff;
        else
            return rankDiff;
    }
}
