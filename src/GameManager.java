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
 * The GameManager class manages a list of scheduled NFL games.
 * It handles loading game data from a CSV file and displaying the games.
 */
public class GameManager {
    //List to hold Game objects loaded from the CSV file.
    private List<Game> games;

    /**
     * Constructor to initialize the games list.
     */
    public GameManager() {
        games = new ArrayList<>();
    }

    /**
     * Loads games from the specified CSV file.
     * The CSV file is expected to have the following columns:
     * HomeTeam, VisitorTeam, Date, Location, Score
     *
     * @param filePath The relative path to the games.csv file.
     */
    public void loadGames(String filePath) {
        //Use try-with-resources to ensure the file is closed automatically.
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // To skip header row if present.
            while ((line = br.readLine()) != null) {
                // Skip header row if it contains "Home" or similar identifier.
                if (firstLine && line.toLowerCase().contains("home")) {
                    firstLine = false;
                    continue;
                }
                //Split the line into tokens using comma as the delimiter.
                String[] tokens = line.split(",");
                //Ensure that the line has at least 5 tokens.
                if (tokens.length < 5) {
                    continue; //Skip lines with insufficient data.
                }
                String team1 = tokens[0].trim();
                String team2 = tokens[1].trim();
                String date = tokens[2].trim();
                String location = tokens[3].trim();
                String score = tokens[4].trim();

                //Create a new Game object with the parsed data.
                Game game = new Game(team1, team2, date, location, score);
                //Add the game to the list.
                games.add(game);
            }
        } catch (IOException e) {
            System.err.println("Error reading games file: " + e.getMessage());
        }
    }

    /**
     * Displays the list of scheduled games with formatted output.
     */
    public void displayGames() {
        System.out.println("-------------------------------------------------------------------");
        //Print a header matching the sample output.
        System.out.printf("%-10s %-10s %-12s %-20s %-8s%n", "Home", "Visitor", "Date", "Location", "Score");
        System.out.println("-------------------------------------------------------------------");
        //Iterate through each game and print its details using the Game's toString() method.
        for (Game game : games) {
            System.out.println(game);
        }
    }

    /**
     * Returns the list of games.
     *
     * @return List of Game objects.
     */
    public List<Game> getGames() {
        return games;
    }
}