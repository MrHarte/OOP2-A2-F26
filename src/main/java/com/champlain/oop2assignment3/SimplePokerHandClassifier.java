package com.champlain.oop2assignment3;

/**
 * Classifies a poker hand based on its cards.
 */
public class SimplePokerHandClassifier implements PokerHandClassifier {

    /**
     * Determines the type of five-card poker hand.
     *
     * @param pCards the cards in the hand
     * @return the type of poker hand
     * @throws IllegalArgumentException if the cards are null or do not contain exactly five cards
     */
    @Override
    public PokerHandType classify(CardCollection pCards) {
        int[] rankCounts;
        int[] suitCounts;
        int pairs;
        boolean isFlush;
        boolean isStraight;
        boolean hasThreeOfAKind;
        boolean hasFourOfAKind;
        boolean isRoyalStraight;
        int consecutive;
        PokerHandType type;

        if (pCards == null) {
            throw new IllegalArgumentException("Cards cannot be null.");
        }

        if (pCards.size() != 5) {
            throw new IllegalArgumentException(
                    "A poker hand must contain exactly 5 cards.");
        }

        rankCounts = new int[Rank.values().length];
        suitCounts = new int[Suit.values().length];

        pairs = 0;
        isFlush = false;
        isStraight = false;
        hasThreeOfAKind = false;
        hasFourOfAKind = false;
        isRoyalStraight = false;
        consecutive = 0;
        type = PokerHandType.HIGH_CARD;

        for (Card card : pCards) {
            rankCounts[card.getRank().ordinal()]++;
            suitCounts[card.getSuit().ordinal()]++;
        }

        for (int i = 0; i < suitCounts.length; i++) {
            if (suitCounts[i] == 5) {
                isFlush = true;
            }
        }

        for (int i = 0; i < rankCounts.length; i++) {
            if (rankCounts[i] == 2) {
                pairs++;
            } else if (rankCounts[i] == 3) {
                hasThreeOfAKind = true;
            } else if (rankCounts[i] == 4) {
                hasFourOfAKind = true;
            }
        }

        for (int i = 0; i < rankCounts.length; i++) {
            if (rankCounts[i] == 1) {
                consecutive++;

                if (consecutive == 5) {
                    isStraight = true;
                }
            } else {
                consecutive = 0;
            }
        }

        if (rankCounts[Rank.TEN.ordinal()] == 1 && rankCounts[Rank.JACK.ordinal()] == 1 && rankCounts[Rank.QUEEN.ordinal()] == 1 && rankCounts[Rank.KING.ordinal()] == 1 && rankCounts[Rank.ACE.ordinal()] == 1) {
            isRoyalStraight = true;
        }

        if (pairs == 1) {
            type = PokerHandType.PAIR;
        }

        if (pairs == 2) {
            type = PokerHandType.TWO_PAIR;
        }

        if (hasThreeOfAKind) {
            type = PokerHandType.THREE_OF_A_KIND;
        }

        if (isStraight || isRoyalStraight) {
            type = PokerHandType.STRAIGHT;
        }

        if (isFlush) {
            type = PokerHandType.FLUSH;
        }

        if (hasThreeOfAKind && pairs == 1) {
            type = PokerHandType.FULL_HOUSE;
        }

        if (hasFourOfAKind) {
            type = PokerHandType.FOUR_OF_A_KIND;
        }

        if (isStraight && isFlush) {
            type = PokerHandType.STRAIGHT_FLUSH;
        }

        if (isFlush && isRoyalStraight) {
            type = PokerHandType.ROYAL_FLUSH;
        }

        return type;
    }
}