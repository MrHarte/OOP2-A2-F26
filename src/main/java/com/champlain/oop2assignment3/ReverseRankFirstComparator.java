package com.champlain.oop2assignment3;

public class ReverseRankFirstComparator implements java.util.Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        // gets a actual number of places card 2 is from card 1
        int rankComparison = card2.getRank().compareTo(card1.getRank());
        if (rankComparison != 0) {
            return rankComparison;
        }
        // if the ranks are the same, compare the suits
        return card1.getSuit().compareTo(card2.getSuit());
    }

}
