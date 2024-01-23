package com.clayton.whistserver.model;
import java.util.ArrayList;
import java.util.List;


public class Player {
    private int id;
    private String name;
    private List<Card> hand = new ArrayList<>();
    private Position position;
    private Team team;
    

    public enum Position {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
    public enum Team {
        NORTH_SOUTH,
        EAST_WEST
    }

    // Constructor
    public Player(String name) {
        this.name = name;
    }



    // Getters and Setters
    // Getter for name
    public String getName() {
        return this.name;
    }
    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
    // Getter for id
    public int getId() {
        return this.id;
    }
    // setter for id
    public void setId(int id) {
        this.id = id;
    }
}