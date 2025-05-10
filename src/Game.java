/*
 * Assessment: Assignment 2
 * Student Name: Wesley Deir
 * Due Date: 2025-03-30 11:59pm
 * Professor Name: Howard Rosenblum
 */

import java.io.Serializable;

/** Description:
 * The Game class represents a scheduled NFL game between two teams.
 * It includes details such as the teams, date, location, and score.
 * This class implements Serializable to allow game objects to be serialized.
 */
public class Game implements Serializable {
    //Unique identifier for serialization (ensuring class compatibility)
    private static final long serialVersionUID = 1L;

    //Private attributes for game details
    private String team1;   // Home team
    private String team2;   // Visitor team
    private String date;    // Date of the game (e.g., "2025-09-10")
    private String location;// Location where the game is played (e.g., "Boston")
    private String score;   // Game score in format "27-20"

    /**
     * Parameterized constructor to initialize a Game object with all required attributes.
     * @param team1    Home team name.
     * @param team2    Visitor team name.
     * @param date     Date of the game.
     * @param location Location of the game.
     * @param score    Final score of the game.
     */
    public Game(String team1, String team2, String date, String location, String score) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.location = location;
        this.score = score;
    }

    //Getter and setter methods for encapsulation

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    /**
     * Overrides the default toString() method to return a formatted string
     * representing the Game's details.
     * @return A formatted string representing the Game.
     */
    @Override
    public String toString() {
        return String.format("%-10s %-10s %-12s %-20s %-8s", team1, team2, date, location, score);
    }
}