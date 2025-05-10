/*
 * Assessment: Assignment 2
 * Student Name: Wesley Deir
 * Due Date: 2025-03-30 11:59pm
 * Professor Name: Howard Rosenblum
 */

/*
 * NFLManagementSystem is the driver class that provides the menu-driven interface
 * for managing NFL operations. It loads data from CSV files and allows the user to
 * display teams, players, scheduled games, add new teams or players, and search for team.
 */

import java.util.Scanner;

public class NFLManagementSystem {
    public static void main(String[] args) {
        //Create instances of the manager classes.
        TeamManager teamManager = new TeamManager();
        PlayerManager playerManager = new PlayerManager();
        GameManager gameManager = new GameManager();

        //Load data from CSV files located in the "resources" folder.
        teamManager.loadTeams("resources/teams.csv");
        playerManager.loadPlayers("resources/players.csv", teamManager);
        gameManager.loadGames("resources/games.csv");

        //Print explanation for not using coaches.csv.
        System.out.println("Note: coaches.csv not used because team.csv contains all necessary coach data.");

        //Create a Scanner object for user input.
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            //Display the menu options.
            showMenu();
            System.out.print("Enter choice: ");
            String input = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("***Invalid choice. Try again***");
                continue;
            }

            switch (choice) {
                case 1:
                    //Display Teams
                    teamManager.displayTeams();
                    break;
                case 2:
                    //Display Players
                    playerManager.displayPlayers();
                    break;
                case 3:
                    //Display Scheduled Games
                    gameManager.displayGames();
                    break;
                case 4:
                    //Add Team interactively
                    System.out.print("Enter team name: ");
                    String teamName = sc.nextLine();
                    System.out.print("Enter city: ");
                    String city = sc.nextLine();
                    System.out.print("Enter coach name: ");
                    String coachName = sc.nextLine();
                    System.out.print("Enter coach years of experience: ");
                    int coachYears;
                    try {
                        coachYears = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("***Invalid input for coach years. Team not added.***");
                        break;
                    }
                    //Create a new Coach and Team, then add to TeamManager.
                    Coach coach = new Coach(coachName, coachYears);
                    Team newTeam = new Team(teamName, city, coach);
                    teamManager.addTeam(newTeam);
                    System.out.println("Team added successfully!");
                    break;
                case 5:
                    //Add Player to Team interactively
                    System.out.print("Enter player ID: ");
                    String playerId = sc.nextLine();
                    System.out.print("Enter player name: ");
                    String playerName = sc.nextLine();
                    System.out.print("Enter player age: ");
                    int age;
                    try {
                        age = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("***Invalid input for age. Player not added.***");
                        break;
                    }
                    System.out.print("Enter team name: ");
                    String playerTeamName = sc.nextLine();
                    System.out.print("Enter player position: ");
                    String position = sc.nextLine();
                    //Create a new Player and add using PlayerManager.
                    Player newPlayer = new Player(playerId, playerName, age, playerTeamName, position);
                    playerManager.addPlayer(newPlayer, teamManager);
                    System.out.println("Player added successfully!");
                    break;
                case 6:
                    //Find Team by name
                    System.out.print("Enter team name to search: ");
                    String searchTeam = sc.nextLine();
                    Team foundTeam = teamManager.findTeam(searchTeam);
                    if (foundTeam != null) {
                        System.out.println("Team found: " + foundTeam);
                    } else {
                        System.out.println("Team not found.");
                    }
                    break;
                case 7:
                    //Exit the program.
                    exit = true;
                    System.out.println("*****************************************************");
                    System.out.println(" ...Exiting the program by Wesley Deir...");
                    System.out.println("*****************************************************");
                    break;
                default:
                    System.out.println("***Invalid choice. Try again***");
                    break;
            }
        }

        // Explanation of Serializable interface and serialVersionUID.
        System.out.println("\nNote: All classes implement Serializable, which allows their objects to be converted to a byte stream.");
        System.out.println("The serialVersionUID is used as a version control in a distributed environment to ensure");
        System.out.println("that the sender and receiver of a serialized object have compatible versions of the class.");

        sc.close();
    }

    /**
     * Displays the menu options for the NFL Operations Management System.
     */
    public static void showMenu() {
        System.out.println("\nNFL Operations Management System");
        System.out.println("1. Display Teams");
        System.out.println("2. Display Players");
        System.out.println("3. Display Scheduled Games");
        System.out.println("4. Add Team");
        System.out.println("5. Add Player to Team");
        System.out.println("6. Find Team");
        System.out.println("7. Exit");
    }
}