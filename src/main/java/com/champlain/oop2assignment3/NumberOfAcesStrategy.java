package com.champlain.oop2assignment3;

public class NumberOfAcesStrategy implements ScoringStrategy{
    /**
     *
     * @param pCards variable for the cards
     * @return returns the aces
     */
    @Override
    public int calculateScore(CardCollection pCards){
        int count = 0;
        for (Card card : pCards) {
            if (card.getRank() == Rank.ACE){
                count++;
            }
        }
        return count;
    }
}
