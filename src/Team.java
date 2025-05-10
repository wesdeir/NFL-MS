/*
 * Assessment: Assignment 2
 * Student Name: Wesley Deir
 * Due Date: 2025-03-30 11:59pm
 * Professor Name: Howard Rosenblum
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** Description:
 * The Team class represents an NFL team with attributes such as team name, city,
 * a coach, and a list of players. It implements Serializable for object serialization.
 */
public class Team implements Serializable {
    //Unique identifier for serialization (ensuring class compatibility during deserialization)
    private static final long serialVersionUID = 1L;

    //Private attributes as defined in the UML
    private String teamName;      // The name of the team
    private String city;          // The team's city
    private Coach coach;          // The team's coach (composition relationship)
    private List<Player> players; // A list of players on the team

    /**
     * Parameterized constructor to initialize the Team object with its name, city, and coach.
     * The list of players is initialized as an empty ArrayList.
     * @param teamName The name of the team.
     * @param city The city the team is based in.
     * @param coach The coach of the team.
     */
    public Team(String teamName, String city, Coach coach) {
        this.teamName = teamName;
        this.city = city;
        this.coach = coach;
        this.players = new ArrayList<>(); // Initialize the players list
    }

    //Getter and Setter methods for each attribute to ensure encapsulation

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    /**
     * Adds a player to the team.
     * @param player The Player object to add.
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Returns the list of players in the team.
     * @return List of Player objects.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Overrides the default toString() method to return a formatted string
     * representing the Team.
     * @return A formatted string representation of the Team.
     */
    @Override
    public String toString() {
        return String.format("%-10s %-15s %-30s %-2d", teamName, city, coach, players.size());
    }
}