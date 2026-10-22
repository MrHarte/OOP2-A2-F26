package com.champlain.oop2assignment3;

/**
 * Iterable card collection overriding toString method. String output contains
 * all cards in the collection separated by new line chars.
 */
public abstract class CardCollection implements Iterable<Card> {
    /**
     * Returns a string representation of the card collection.
     * 
     * @return string representation of the card collection
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Card currentCard : this) {
            result.append(currentCard.toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * Returns the number of cards in the collection.
     * 
     * @return number of cards in the collection
     */
    public int size() {
        int count = 0;
        for (Card _ : this) {
            count++;
        }
        return count;
    }
}
