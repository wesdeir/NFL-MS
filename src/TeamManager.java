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
 * The TeamManager class manages a list of NFL teams.
 * It handles loading team data from a CSV file, displaying teams,
 * adding new team information, and finding teams by name.
 */
public class TeamManager {
    //List to hold Team objects loaded from the CSV file.
    private List<Team> teams;

    /**
     * Constructor to initialize the teams list.
     */
    public TeamManager() {
        teams = new ArrayList<>();
    }

    /**
     * Loads teams from the given CSV file.
     * The CSV file is expected to have the following columns:
     * TeamName, City, CoachName, CoachYears
     *
     * @param filePath The relative path to the teams.csv file.
     */
    public void loadTeams(String filePath) {
        // Use try-with-resources to ensure the file is closed automatically.
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            // Read the CSV file line by line.
            while ((line = br.readLine()) != null) {
                // Skip the header row if present (assumes header contains "Team")
                if (firstLine && line.toLowerCase().contains("team")) {
                    firstLine = false;
                    continue;
                }
                //Split the line by commas.
                String[] tokens = line.split(",");
                //Ensure that the line has at least 4 tokens.
                if (tokens.length < 4) {
                    continue; //Skip lines with insufficient data.
                }
                String teamName = tokens[0].trim();
                String city = tokens[1].trim();
                String coachName = tokens[2].trim();
                int coachYears = Integer.parseInt(tokens[3].trim());
                //Create a new Coach object with the provided details.
                Coach coach = new Coach(coachName, coachYears);
                //Create a new Team object; initially, the team has no players.
                Team team = new Team(teamName, city, coach);
                //Add the newly created team to the list.
                teams.add(team);
            }
        } catch (IOException e) {
            System.err.println("Error reading teams file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing coach years: " + e.getMessage());
        }
    }

    /**
     * Displays the list of teams with formatted output.
     * It prints a header followed by each team's details.
     */
    public void displayTeams() {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-30s %-2s%n", "Team", "City", "Coach", "Players");
        System.out.println("-------------------------------------------------------------------");
        for (Team team : teams) {
            System.out.println(team);
        }
    }

    /**
     * Adds a new team to the list.
     * @param team The Team object to add.
     */
    public void addTeam(Team team) {
        teams.add(team);
    }

    /**
     * Finds and returns a team by its name.
     * @param teamName The name of the team to find.
     * @return The Team object if found; otherwise, null.
     */
    public Team findTeam(String teamName) {
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null; // Return null if no matching team is found.
    }

    /**
     * Returns the list of teams. This method can be used by other manager classes.
     * @return List of Team objects.
     */
    public List<Team> getTeams() {
        return teams;
    }
}