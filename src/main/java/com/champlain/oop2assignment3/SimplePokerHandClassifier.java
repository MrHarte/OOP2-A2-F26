
package com.champlain.oop2assignment3;

/**
 * Classifies a poker hand.
 */
public class SimplePokerHandClassifier implements PokerHandClassifier {

    /**
     * Classifies a five-card hand.
     *
     * @param pCards the hand
     * @return the hand type
     * @throws IllegalArgumentException if the hand is invalid
     */
    @Override
    public PokerHandType classify(CardCollection pCards) {
        validateHand(pCards);

        int[] aRankCounts = countRanks(pCards);
        int[] aSuitCounts = countSuits(pCards);

        boolean isFlush = isFlush(aSuitCounts);
        boolean isStraight = isStraight(aRankCounts);
        boolean isRoyalStraight = isRoyalStraight(aRankCounts);

        return determineHandType(aRankCounts, isFlush, isStraight, isRoyalStraight);
    }

    /**
     * Validates the hand.
     *
     * @param pCards the hand
     * @throws IllegalArgumentException if the hand is invalid
     */
    private void validateHand(CardCollection pCards) {
        if (pCards == null) {
            throw new IllegalArgumentException("Cards cannot be null.");
        }

        if (pCards.size() != 5) {
            throw new IllegalArgumentException("A poker hand must contain exactly 5 cards.");
        }
    }

    /**
     * Counts each rank.
     *
     * @param pCards the hand
     * @return the rank counts
     */
    private int[] countRanks(CardCollection pCards) {
        int[] aRankCounts = new int[Rank.values().length];

        for (Card card : pCards) {
            aRankCounts[card.getRank().ordinal()]++;
        }

        return aRankCounts;
    }

    /**
     * Counts each suit.
     *
     * @param pCards the hand
     * @return the suit counts
     */
    private int[] countSuits(CardCollection pCards) {
        int[] aSuitCounts = new int[Suit.values().length];

        for (Card card : pCards) {
            aSuitCounts[card.getSuit().ordinal()]++;
        }

        return aSuitCounts;
    }

    /**
     * Checks for a flush.
     *
     * @param pSuitCounts the suit counts
     * @return true if the hand is a flush
     */
    private boolean isFlush(int[] pSuitCounts) {
        for (int i = 0; i < pSuitCounts.length; i++) {
            if (pSuitCounts[i] == 5) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks for a straight.
     *
     * @param pRankCounts the rank counts
     * @return true if the hand is a straight
     */
    private boolean isStraight(int[] pRankCounts) {
        int consecutive = 0;

        for (int i = 0; i < pRankCounts.length; i++) {
            if (pRankCounts[i] == 1) {
                consecutive++;

                if (consecutive == 5) {
                    return true;
                }
            } else {
                consecutive = 0;
            }
        }

        return false;
    }

    /**
     * Checks for a royal straight.
     *
     * @param pRankCounts the rank counts
     * @return true if the hand has a royal straight
     */
    private boolean isRoyalStraight(int[] pRankCounts) {
        return pRankCounts[Rank.TEN.ordinal()] == 1 && pRankCounts[Rank.JACK.ordinal()] == 1 && pRankCounts[Rank.QUEEN.ordinal()] == 1 && pRankCounts[Rank.KING.ordinal()] == 1 && pRankCounts[Rank.ACE.ordinal()] == 1;
    }

    /**
     * Determines the hand type.
     *
     * @param pRankCounts the rank counts
     * @param pIsFlush whether the hand is a flush
     * @param pIsStraight whether the hand is a straight
     * @param pIsRoyalStraight whether the hand is a royal straight
     * @return the hand type
     */
    private PokerHandType determineHandType(int[] pRankCounts, boolean pIsFlush, boolean pIsStraight, boolean pIsRoyalStraight) {

        int pairs = 0;
        boolean hasThreeOfAKind = false;
        boolean hasFourOfAKind = false;

        for (int i = 0; i < pRankCounts.length; i++) {
            if (pRankCounts[i] == 2) {
                pairs++;
            } else if (pRankCounts[i] == 3) {
                hasThreeOfAKind = true;
            } else if (pRankCounts[i] == 4) {
                hasFourOfAKind = true;
            }
        }

        if (pIsFlush && pIsRoyalStraight) {
            return PokerHandType.ROYAL_FLUSH;
        }

        if (pIsStraight && pIsFlush) {
            return PokerHandType.STRAIGHT_FLUSH;
        }

        if (hasFourOfAKind) {
            return PokerHandType.FOUR_OF_A_KIND;
        }

        if (hasThreeOfAKind && pairs == 1) {
            return PokerHandType.FULL_HOUSE;
        }

        if (pIsFlush) {
            return PokerHandType.FLUSH;
        }

        if (pIsStraight || pIsRoyalStraight) {
            return PokerHandType.STRAIGHT;
        }

        if (hasThreeOfAKind) {
            return PokerHandType.THREE_OF_A_KIND;
        }

        if (pairs == 2) {
            return PokerHandType.TWO_PAIR;
        }

        if (pairs == 1) {
            return PokerHandType.PAIR;
        }

        return PokerHandType.HIGH_CARD;
    }
}