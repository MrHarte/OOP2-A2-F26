package com.champlain.oop2assignment3;

public class SimpleCountStrategy {
    /**
     * Calculates the score based on the number of cards in the hand.
     *
     * @param pCards the hand of cards to evaluate
     * @return the number of cards in the collection
     */
   
    public int calculateScore(CardCollection pCards) {
        if (pCards == null) {
            return 0;
        }

        int count = 0;
        for (Card card : pCards) {
            count++;
        }
        return count;
    }

}
