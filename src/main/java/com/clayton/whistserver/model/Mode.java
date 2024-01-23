package com.clayton.whistserver.model;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Mode {
    public static Mode highMode() { return new HighMode();}
    public static Mode lowMode() { return new LowMode();}
    
    public static List<Mode> standardModes() {
        List<Mode> modes = new LinkedList<>();
        modes.add(highMode());
        modes.add(lowMode());
        return modes;
    }

    public abstract int calculateRoundScore(int roundNumber, Set<Card> playedCards);
    public abstract int calculateScore(Set<Card> playedCards);

    public Card determineWinningCard(List<Card> cards) {
        return GeneralRules.determineWinnerCard(cards, createRankComparator());
    }

    public Move determineWinningMove(List<Move> moves) {
        List<Card> cards = moves.stream().map(Move::getPlayedCard).collect(Collectors.toList());
        Card winningCard = determineWinningCard(cards);
        return moves.stream().filter(move -> winningCard == move.getPlayedCard()).findFirst().orElse(null);
    }

    public abstract boolean canPlayCard(Card card, Set<Card> alreadyPlayedCards, Color currentRoundColor, Set<Card> playerCards); // color should probably be suit
    public abstract int getFactor();
    protected abstract Comparator<Card> createRankComparator();

}
