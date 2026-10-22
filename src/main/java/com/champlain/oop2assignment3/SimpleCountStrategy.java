package com.champlain.oop2assignment3;

import java.util.Iterator;

/**
 * class for the simple counting strategy
 */
public class SimpleCountStrategy implements ScoringStrategy {

    /**
     *
     * @param pCards the cards to score
     * @return what the score was as an int
     */
    @Override
    public int calculateScore(CardCollection pCards) {

        int score = 0;
        for (Card card : pCards) {
            ++score;
        }

        return score;
    }


}
