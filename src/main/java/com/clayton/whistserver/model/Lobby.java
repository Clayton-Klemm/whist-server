package com.clayton.whistserver.model;

import java.util.ArrayList;
import java.util.List;

public class Lobby {
    private String name;
    private List<String> players = new ArrayList<>();
    private boolean gameStarted = false;

    // Constructor
    public Lobby(String name) {
        this.name = name;
    }

    // Add a player to the lobby
    public synchronized void addPlayer(String playerName) {
        if (!gameStarted && players.size() < 4) {
            players.add(playerName);
            if (players.size() == 4) {
                gameStarted = true;
                // TODO: Initialize game logic
            }
        }
    }

    // Remove a player from the lobby
    public synchronized void removePlayer(String playerName) {
        players.remove(playerName);
    }

    // Getters and Setters
    // ...
    // Get name
    public String getName() {
        return name;
    }
    // Get players
    public List<String> getPlayers() {
        return players;
    }
}
