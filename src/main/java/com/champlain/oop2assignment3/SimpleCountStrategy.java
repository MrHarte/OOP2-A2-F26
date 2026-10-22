package com.champlain.oop2assignment3;

import java.util.Iterator;

public class SimpleCountStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(CardCollection pCards) {

        int score = 0;
        for (Card card : pCards) {
            ++score;
        }

        return score;
    }


}
