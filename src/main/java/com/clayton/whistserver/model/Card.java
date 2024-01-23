package com.clayton.whistserver.model;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * The card class creates a card object that contains a
 * suit, a number, and an image that corresponds to that
 * suit and number. it is used in hand, deck and memory.
 */

public class Card implements Comparable<Card> {

    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    /*
     * INSTANCE VARIABLES
     */
    private final Suit suit;
    private final Rank rank;
    private ImageIcon image; // the Image of the card based on the suit and number.

    /*
     * CONSTRUCTOR
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        // setImage(screenRes);

    }

     /*
      * PUBLIC METHODS
      */

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }


    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card otherCard) {

        int suitComparison = this.suit.compareTo(otherCard.suit);
        if (suitComparison != 0) {
            return suitComparison;
        } else {
            return this.rank.compareTo(otherCard.rank);
        }

    }
}