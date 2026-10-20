package com.champlain.oop2assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a deck of playing cards.
 * <p>
 * This class allows for creating a standard deck, shuffling it, drawing cards,
 * and checking if the deck is empty.
 * </p>
 *
 * @author Keren
 */
public class Deck extends CardCollection implements CardSource {
    /**
     * The single shared instance of Deck.
     */
    private static Deck aInstance;
    /**
     * The list of cards in the deck.
     */
    private final List<Card> aCards = new ArrayList<>();

    /**
     * Constructor is set to private to prevent other classes from
     * creating additional Deck instances.
     * The deck is initialized with one of each rank and suit combination.
     */
    private Deck() {
        for (Rank currentRank : Rank.values()) {
            for (Suit currentSuit : Suit.values()) {
                this.aCards.add(new Card(currentRank, currentSuit));
            }
        }
    }

    /**
     * Returns a single shared Deck Instance
     *
     * If the instance is not yet created it creates one and if it it
     * it returns the same instance.
     *
     * @return the single shared Deck instance
     */
    public static Deck getInstance() {
        if (aInstance == null) {
            aInstance = new Deck();
        }

        return aInstance;
    }

    /**
     * Shuffles the cards in this deck randomly.
     */
    public void shuffle() {
        Collections.shuffle(this.aCards);
    }



    /**
     * Draws and removes the last card from this deck.
     *
     * @return the card drawn from the deck
     */
    public Card draw() {
        int last = this.aCards.size()-1;
        Card myCard = this.aCards.get(last);
        this.aCards.remove(last);
        return myCard;
    }

    /**
     * Checks whether this deck contains no remaining cards.
     *
     * @return true if the deck is empty; false otherwise
     */
    public boolean isEmpty() {
        return this.aCards.isEmpty();
    }

    /**
     * Returns an iterator over the cards in this deck.
     *
     * @return an iterator for the cards
     */
    public Iterator<Card> iterator() {
        return Collections.unmodifiableList(this.aCards).iterator();
    }
}
