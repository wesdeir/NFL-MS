/*
 * Assessment: Assignment 2
 * Student Name: Wesley Deir
 * Due Date: 2025-03-30 11:59pm
 * Professor Name: Howard Rosenblum
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Description:
 * The PlayerManager class manages a list of NFL players.
 * It loads players from a CSV file, displays the player list,
 * and adds players to their corresponding teams using TeamManager.
 */
public class PlayerManager {
    // List to hold Player objects.
    private List<Player> players;

    /**
     * Constructor to initialize the players list.
     */
    public PlayerManager() {
        players = new ArrayList<>();
    }

    /**
     * Loads players from the specified CSV file.
     * The CSV file is expected to have the following columns:
     * PlayerID, PlayerName, Age, TeamName, Position
     * @param filePath    The relative path to the players.csv file.
     * @param teamManager The TeamManager instance used to add players to teams.
     */
    public void loadPlayers(String filePath, TeamManager teamManager) {
        //Use try-with-resources to ensure proper closing of the file stream.
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // To skip header row if present.
            while ((line = br.readLine()) != null) {
                //skip the header row if it contains "ID" or similar identifier.
                if (firstLine && line.toLowerCase().contains("id")) {
                    firstLine = false;
                    continue;
                }
                //Split the line into tokens (columns) by comma.
                String[] tokens = line.split(",");
                //Ensure that the line has at least 5 tokens.
                if (tokens.length < 5) {
                    continue; //Skip any incomplete lines.
                }
                String playerId = tokens[0].trim();
                String name = tokens[1].trim();
                int age = Integer.parseInt(tokens[2].trim());
                String teamName = tokens[3].trim();
                String position = tokens[4].trim();

                //Create a new Player object with the parsed data.
                Player player = new Player(playerId, name, age, teamName, position);

                //Add the player to the manager's list.
                players.add(player);

                //Find the team in TeamManager and add the player to that team.
                //If the team is not found, print an error message.
                if (teamManager.findTeam(teamName) != null) {
                    teamManager.findTeam(teamName).addPlayer(player);
                } else {
                    System.err.println("Team not found for player: " + name + " (" + teamName + ")");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading players file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing age for a player: " + e.getMessage());
        }
    }

    /**
     * Displays the list of players with formatted output.
     */
    public void displayPlayers() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-5s %-10s %-15s%n", "ID", "Player", "Age", "Team", "Position");
        System.out.println("-------------------------------------------------------------------");
        //Iterate through each player and print their details.
        for (Player player : players) {
            System.out.printf("%-5s %-15s %-5d %-10s %-15s%n",
                    player.getPlayerId(),
                    player.getName(),
                    player.getAge(),
                    player.getTeamName(),
                    player.getPosition());
        }
    }

    /**
     * Adds a new player to the manager and assigns them to the appropriate team.
     *
     * @param player      The Player object to add.
     * @param teamManager The TeamManager instance used to locate the team.
     */
    public void addPlayer(Player player, TeamManager teamManager) {
        players.add(player);
        Team team = teamManager.findTeam(player.getTeamName());
        if (team != null) {
            team.addPlayer(player);
        } else {
            System.err.println("Team not found for player: " + player.getName() + " (" + player.getTeamName() + ")");
        }
    }

    /**
     * Returns the list of players.
     *
     * @return List of Player objects.
     */
    public List<Player> getPlayers() {
        return players;
    }
}