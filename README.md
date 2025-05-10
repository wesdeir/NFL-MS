````markdown
# NFL Management System

## Overview

The NFL Management System is a Java console application simulating the management of NFL operations. Developed as a final project for an Object-Oriented Programming (OOP) course at Algonquin College, it demonstrates key OOP concepts like inheritance, encapsulation, and composition, using CSV input for data persistence.

## Features

- Load teams, players, and games from CSV files  
- Add teams and players via console input  
- Display formatted team, player, and game lists  
- Search for teams by name  
- Models are fully serializable with defined `serialVersionUID`  
- Graceful input handling and runtime exception management  

## Technologies Used

- Java (OOP)  
- File I/O (BufferedReader, FileReader)  
- Console-based interaction  

## File Structure

- `NFLManagementSystem.java` – Main menu logic  
- `Team.java`, `Player.java`, `Coach.java` – Data models  
- `TeamManager.java`, `PlayerManager.java`, `GameManager.java` – Logic controllers  
- `Game.java` – Game handling and formatting  
- CSV Files: `teams.csv`, `players.csv`, `games.csv` in `resources/` directory  

## How to Run

1. Clone this repo:
   ```bash
   git clone https://github.com/wesdeir/NFL-MS.git
   cd NFL-MS
````

2. Ensure Java 17+ is installed.

3. Place CSV files inside a `resources/` folder in project root:

   * `teams.csv`
   * `players.csv`
   * `games.csv`

4. Compile and run:

   ```bash
   javac *.java
   java NFLManagementSystem
   ```

## Notes

* `coaches.csv` not required; coach info is embedded in `teams.csv`
* Project follows basic Java conventions with a modular OOP approach
* Developed for educational purposes under CST8116 – Object-Oriented Programming

## Author

Wesley Deir
Algonquin College
Winter 2025

```
```
