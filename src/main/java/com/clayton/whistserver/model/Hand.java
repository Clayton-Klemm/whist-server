package com.clayton.whistserver.model;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Hand is a list of 13 card objects, used by any human or bot, it contains
 * methods to check the status and manipulate the cards in the hand.
 */

public class Hand {
    /*
     * INSTANCE VARIABLES
     */

     private final ArrayList<Card> hand; // arrayList of 13 cards.

    /*
    * CONSTRUCTOR
    */

    /**
     * Constructor for Hand, creates an empty hand.
     */
    public Hand() {
        hand = new ArrayList();
    }

    /*
    * PUBLIC METHODS
    */

    /**
     * Adds a card object to the hand.
     */
    public void add(Card card) {
        hand.add(card);
    }
    /**
     * sorts the hand
     */
    public void sortHand() {
        Collections.sort(hand);
    }

    /**
     * Removes a card object from the hand, based on position using arrayList's methodds
     * @return the Card that is removed
     */

    public Card remove(int position) {
        Card returnCard = hand.get(position);
        hand.remove(returnCard);
        return returnCard;
    }

    /**
     * Prints out every card in the hand and the size of the hand
     */
    public String toString() {
        return hand.toString() + " Length: " + hand.size();
    }

    /**
     * checks to see if a certain card is in the hand
     * @param c
     * The card to check.
     * @return True if it is in the hand, else false.
     */
    // public boolean contains(Card c) {
    //     for (Card aHand : hand) {
    //         if (aHand.getNumber() == c.getNumber() && aHand.getSuit() == c.getSuit()) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    /**
     * Returns the number of cards in the hand
     * @return an integer 0-13 the number of cards in the hand
     */
    public int size() {
        return hand.size();
    }
}
