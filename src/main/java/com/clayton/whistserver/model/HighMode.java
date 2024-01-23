package com.clayton.whistserver.model;

import java.util.Comparator;
import java.util.Set;
import static java.lang.String.valueOf;

class HighMode extends Mode {
    
    @Override
    public int calculateRoundScore(int roundNumber, Set<Card> playedCards) {
        return calculateScore(playedCards);
    }


}
