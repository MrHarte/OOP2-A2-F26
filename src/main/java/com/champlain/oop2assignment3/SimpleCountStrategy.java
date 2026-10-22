package com.champlain.oop2assignment3;

public class SimpleCountStrategy implements ScoringStrategy {
    /**
     *
     * @param pCards var for the cards themselves
     * @return returns the cards rank
     */
    @Override
    public int calculateScore(CardCollection pCards){
        return pCards.size();
    }
}
