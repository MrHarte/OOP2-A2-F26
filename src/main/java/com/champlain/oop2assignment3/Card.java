package com.champlain.oop2assignment3;

import java.util.Objects;

/**
 * Represents a playing card with a specific suit and rank.
 * @implNote This class is immutable, meaning that once a card is created, its suit and rank cannot be changed.
 */
public class Card {
    /**
     * The suit of this card (e.g., Hearts, Diamonds, Clubs, Spades).
     */
    private final Suit aSuit;

    /**
     * The rank of this card (e.g., Ace, 2, 3, ..., King).
     */
    private final Rank aRank;

    /**
     * Constructs a new Card with the specified rank and suit.
     *
     * @param pRank the rank of the card (e.g., Ace, 2, 3, ..., King)
     * @param pSuit the suit of the card (e.g., Hearts, Diamonds, Clubs, Spades)
     */
    public Card(Rank pRank, Suit pSuit) {
        this.aRank = pRank;
        this.aSuit = pSuit;
    }

    /**
     * Returns the rank of this card.
     *
     * @return the rank of the card
     */
    public Rank getRank() {
        return this.aRank;
    }

    /**
     * Returns the suit of this card.
     *
     * @return the suit of the card
     */
    public Suit getSuit() {
        return this.aSuit;
    }
    /**
     * Returns a string representation of this card.
     *
     * @return a string in the format "Rank of Suit" (e.g., "Ace of Hearts")
     */
    @Override
    public String toString() {
        return this.getRank() + " of " + this.getSuit();
    }

    /**
     13
     * Compares this card to another object for equality.
     14
     * Two cards are considered equal if they have the same
     15
     * rank and suit.
     16
     *
     17
     * @param obj the object to compare to this card
    18
     * @return true if the cards have the same rank and suit;
    19
     * false otherwise
    20
     */
    @Override
    public boolean equals(Object obj) {
        // Check if both references point to the same object
        if (this == obj) return true;
        // Verify that the object is a Card
        if (!(obj instanceof Card)) return false;
        // Cast the object to a Card so its attributes can be compared
        Card comparedCard = (Card) obj;
        //Compare both the rank and suit of the cards
        return this.aRank == comparedCard.aRank && this.aSuit == comparedCard.aSuit;
    }

    /**
     * Generates a hash code for this card based on its rank and suit.
     * Equal cards will generate the same hash code.
     * @return the hash code value for this card
     */

    @Override
    public int hashCode() {
        return Objects.hash(this.aRank, this.aSuit);
    }
}
