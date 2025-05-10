/*
 * Assessment: Assignment 2
 * Student Name: Wesley Deir
 * Due Date: 2025-03-30 11:59pm
 * Professor Name: Howard Rosenblum
 */

import java.io.Serializable;

/** Description:
 * The Coach class represents a team's coach with attributes such as
 * name and years of experience. It implements the Serializable interface
 * for object serialization.
 */
public class Coach implements Serializable {
    //Unique identifier for serialization (used for version control)
    private static final long serialVersionUID = 1L;

    //Private attributes as per the updated UML (no coachID or teamName)
    private String name;
    private int yearsOfExperience;

    /**
     * Parameterized constructor to initialize a Coach object.
     * @param name Coach's name.
     * @param yearsOfExperience Number of years the coach has been coaching.
     */
    public Coach(String name, int yearsOfExperience) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    //Getter and setter method"s

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * Sets the years of experience for the coach.
     * Throws an exception if a negative value is provided.
     * @param yearsOfExperience Number of years of coaching experience.
     */
    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience cannot be negative.");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Overrides the default toString() method to return a formatted string
     * representing the Coach's details.
     */
    @Override
    public String toString() {
        return String.format("%s (%d years)", name, yearsOfExperience);
    }
}