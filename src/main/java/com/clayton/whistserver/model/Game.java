package com.clayton.whistserver.model;

import java.util.List;

import com.clayton.whistserver.model.Player.Team;

public class Game {
    public static final int LAST_ROUND_NUMBER = 13;
    private final Mode mode;
    private final PlayingOrder order;
    private Round currentRound;
    private final Result result;

    private Game(Mode mode, PlayingOrder order, List<Team> teams) {
        this.mode = mode;
        this.order = order;
        this.currentRound = Round.createRound(mode, 0, order);
        this.result = new Result(teams.get(0), teams.get(1));
    }

    public static Game startGame(Mode mode, PlayingOrder order, List<Team> teams, boolean shifted) {

        return new Game(mode, order, teams, shifted);
    }

    public Round getCurrentRound() {
        return currentRound;
    }

    public Result getResult() {
        return result;
    }

    public Round startNextRound() {
        updateRoundResult();
        if(currentRound.isLastRound() && result.isMatch()) {
            result.updateWinningTeamScore(calculateMatchBonus());
        }
        this.currentRound = createNextRound();
        return currentRound;
    }

    public void makeMove(Move move) {
        getCurrentRound().makeMove(move);
    }

    private int calculateMatchBonus() {
        return currentRound.getMode().getFactor() * 100;
    }

    private void updateRoundResult() {
        final int lastScore = this.currentRound.calculateScore();
        final Player winner = this.currentRound.getWinner();

        result.updateTeamScore(winner, lastScore);
    }

    private Round createNextRound() {
        final PlayingOrder nextPlayingOrder = createOrderStartingFromPlayer(order.getPlayerInOrder(), currentRound.getWinner());
        final int nextRoundNumber = currentRound.getRoundNumber() + 1;
        return Round.createRound(mode, nextRoundNumber, nextPlayingOrder);
    }

    public boolean isShifted() {
        return shifted;
    }
}
