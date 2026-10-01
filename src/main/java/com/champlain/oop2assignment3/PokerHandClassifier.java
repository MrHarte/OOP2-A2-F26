package com.champlain.oop2assignment3;

/**
 * Defines the behavior required to classify a collection of cards
 * according to standard poker hand rankings.
 *
 * <p>Implementations of this interface determine whether a hand
 * represents a pair, two pair, full house, flush, and so on.</p>
 *
 * <p>This interface follows the Strategy design pattern by allowing
 * different hand-classification algorithms to be used interchangeably.</p>
 *
 * <p>Example:</p>
 *
 * <pre>
 * PokerHandClassifier classifier = new SimplePokerHandClassifier();
 * PokerHandType type = classifier.classify(hand);
 *
 * System.out.println(type);
 * </pre>
 */
public interface PokerHandClassifier
{
    /**
     * Determines the poker hand type represented by the supplied
     * collection of cards.
     *
     * @param pCards the cards to classify
     * @return the poker hand type corresponding to the cards
     * @throws IllegalArgumentException if pCards is null
     * @throws IllegalArgumentException if the collection does not contain 5 cards
     */
    PokerHandType classify(CardCollection pCards);
}
