package com.champlain.oop2assignment3;

public interface ScoringStrategy {
    /**
     * Calculates the score for a given collection of cards.
     *
     * @param pCards the hand of cards to evaluate
     * @return the calculated integer score
     */
    int calculateScore(CardCollection pCards);
}
