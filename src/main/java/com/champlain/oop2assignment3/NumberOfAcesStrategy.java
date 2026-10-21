package com.champlain.oop2assignment3;

public class NumberOfAcesStrategy {
        /**
         * Calculates the score by counting how many Ace cards are in the hand.
         *
         * @param pCards the hand of cards to evaluate
         * @return the count of Ace cards
         */
        public int calculateScore(CardCollection pCards) {
            if (pCards == null) {
                return 0;
            }

            int aceCount = 0;
            for (Card card : pCards) {
                if (card.getRank() == Rank.ACE) {
                    aceCount++;
                }
            }
            return aceCount;
        }
}
