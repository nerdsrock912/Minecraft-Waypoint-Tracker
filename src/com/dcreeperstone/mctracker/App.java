package com.dcreeperstone.mctracker;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class App {

    public static final int QUIT_CHOICE = 3;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tracker tracker;
        File waypointFile = null;
        char loadFromFile;
        int optionChoice = 0;

        System.out.print("Load coordinates from file? (Y/N) ");
        loadFromFile = input.nextLine().toUpperCase().charAt(0);

        if (loadFromFile == 'Y') {
            waypointFile = getWaypointFile();
            tracker = (waypointFile != null) ? new Tracker(waypointFile) : new Tracker();
        }
        else
            tracker = new Tracker();

        System.out.println();
        do {
            optionChoice = getMenuChoice();
            System.out.println();
            performChoice(optionChoice, tracker);
            System.out.println();
        } while (optionChoice != QUIT_CHOICE);
    }

    /**
     * 
     * @return
     */
    public static File getWaypointFile() {
        JFileChooser fileChooser = new JFileChooser();
        File waypointFile = null;
        int fileReturnValue;

        fileReturnValue = fileChooser.showOpenDialog(null);
        if (fileReturnValue == JFileChooser.APPROVE_OPTION)
            waypointFile = fileChooser.getSelectedFile();
        else
            System.out.println("File could not be chosen.");

        return waypointFile;
    }

    /**
     * 
     * @return
     */
    public static int getMenuChoice() {
        Scanner input = new Scanner(System.in);
        int menuChoice;

        System.out.println("Choose one of the following options:");
        System.out.println("    1. Add a new waypoint");
        System.out.println("    2. Show all waypoints");
        System.out.print("    3. Save and exit:  ");
        menuChoice = input.nextInt();

        return menuChoice;
    }

    /**
     * 
     * @param menuChoice
     * @param tracker
     */
    public static void performChoice(int menuChoice, Tracker tracker) {
        Waypoint waypoint;

        switch (menuChoice) {
            case 1: waypoint = getWaypoint();
                    tracker.addWaypoint(waypoint);
                    break;
            case 2: tracker.showWaypoints();
                    break;
            case 3: tracker.saveWaypoints();
                    break;
            default: break;
        }
    }

    /**
     * 
     * @return
     */
    public static Waypoint getWaypoint() {
        Waypoint waypoint;
        String waypointName;
        Coordinate coordinate;

        waypointName = getLocation();
        coordinate = getCoordinates();
        waypoint = new Waypoint(waypointName, coordinate);

        return waypoint;
    }

    /**
     * 
     * @return
     */
    public static String getLocation() {
        Scanner input = new Scanner(System.in);
        String location;

        System.out.print("Enter the name of the location: ");
        location = input.nextLine();

        return location;
    }

    /**
     * 
     * @return
     */
    public static Coordinate getCoordinates() {
        Scanner input = new Scanner(System.in);
        Coordinate coordinates;
        float xPos, yPos, zPos;

        System.out.print("Enter the x-coordinate: ");
        xPos = input.nextFloat();
        System.out.print("Enter the y-coordinate: ");
        yPos = input.nextFloat();
        System.out.print("Enter the z-coordinate: ");
        zPos = input.nextFloat();
        coordinates = new Coordinate(xPos, yPos, zPos);

        return coordinates;
    }
}