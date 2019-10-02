package com.dcreeperstone.mctracker;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * This class has the functionality of maintaining a {@link Tracker} instance and its capabilities.
 * The user can choose to load {@link Waypoint} instances from a file or start from scratch, create
 * new {@link Waypoint} instances, and then save them all to a specified file.
 */
public class App {

    public static final int QUIT_CHOICE = 3;

    /**
     * Runs a {@link Tracker} instance and lets the user load, create, and save a list 
     * of {@link Waypoint} instances.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tracker tracker;
        File waypointFile = null;
        char loadFromFile;
        int optionChoice = 0;

        System.out.print("Load waypoints from file? (Y/N) ");
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
     * Gets a {@link File} from the user from which to load data.
     * @return The {@link File} containing {@link Waypoint} instances.
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
     * Gets the user's choice to add, show, or save {@link Waypoint} instances.
     * @return The user's choice.
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
     * Performs the desired choice of adding, showing, or saving the list of {@link Waypoint} objects.
     * @param menuChoice The choice that the user made.
     * @param tracker The {@link Tracker} maintaining the list of {@link Waypoint} instances.
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
     * Gets a location and its point in a world from the user.
     * @return The {@link Waypoint} instance containing a location and its point.
     */
    public static Waypoint getWaypoint() {
        Waypoint waypoint;
        String waypointName;
        Point point;

        waypointName = getLocation();
        point = getPoint();
        waypoint = new Waypoint(waypointName, point);

        return waypoint;
    }

    /**
     * Gets the location of a place from the user.
     * @return The location of a place.
     */
    public static String getLocation() {
        Scanner input = new Scanner(System.in);
        String location;

        System.out.print("Enter the name of the location: ");
        location = input.nextLine();

        return location;
    }

    /**
     * Gets a {@link Point} object from the user.
     * @return The (x, y, z) coordinates of the place.
     */
    public static Point getPoint() {
        Scanner input = new Scanner(System.in);
        Point point;
        float xPos, yPos, zPos;

        System.out.print("Enter the x-coordinate: ");
        xPos = input.nextFloat();
        System.out.print("Enter the y-coordinate: ");
        yPos = input.nextFloat();
        System.out.print("Enter the z-coordinate: ");
        zPos = input.nextFloat();
        point = new Point(xPos, yPos, zPos);

        return point;
    }
}