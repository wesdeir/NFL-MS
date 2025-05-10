/*
 * Assessment: Assignment 2
 * Student Name: Wesley Deir
 * Due Date: 2025-03-30 11:59pm
 * Professor Name: Howard Rosenblum
 */

import java.io.Serializable;

/** Description:
 * The Player class represents an NFL player with attributes such as ID, name,
 * age, team (as a String), and position.
 * This class implements Serializable for object serialization.
 */
public class Player implements Serializable {
    // Unique identifier for serialization (used for version control)
    private static final long serialVersionUID = 1L;

    // Player attributes (all set to private as per UML updates)
    private String playerId;
    private String name;
    private int age;
    private String teamName;
    private String position;

    /**
     * Parameterized constructor to initialize a Player object with all attributes.
     *
     * @param playerId Unique player ID.
     * @param name Player's name.
     * @param age Player's age.
     * @param teamName The name of the team the player belongs to.
     * @param position Player's position.
     */
    public Player(String playerId, String name, int age, String teamName, String position) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.teamName = teamName;
        this.position = position;
    }

    /**
     * Alternative constructor if the team is not assigned during creation.
     * The teamName is set to "No Team" by default.
     * @param playerId Unique player ID.
     * @param name Player's name.
     * @param age Player's age.
     * @param position Player's position.
     */
    public Player(String playerId, String name, int age, String position) {
        this(playerId, name, age, "No Team", position);
    }

    //Getter and Setter methods to ensure encapsulation

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) { this.playerId = playerId; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    /**
     * Sets the player's age. Throws an exception if a negative age is provided.
     * @param age Player's age.
     */
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Overrides the default toString() method to return a formatted string
     * representing the Player.
     */
    @Override
    public String toString() {
        return String.format("Player[ID=%s, Name=%s, Age=%d, Team=%s, Position=%s]",
                playerId, name, age, teamName, position);
    }
}