package com.dcreeperstone.mctracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * The {@link Tracker} class manages a {@link List} of {@link Waypoint} instances.
 * It can load {@link Waypoint} instances from a {@link File} or create new ones
 * from scratch. Furthermore, it can add new {@link Waypoint} instances,
 * show all existing {@link Waypoint} instances in the {@link List}, and lastly
 * save all {@link Waypoint} objects to a {@link File} using the 
 * {@link JFileChooser} class if a {@link File} has not already been given
 * by the user.
 */
public final class Tracker {

    private List<Waypoint> mWaypoints;
    private File mWaypointFile;

    private static final String DELIMITER = ": ";

    /**
     * Creates a new {@link Tracker} instance and allocates memory for a new {@link ArrayList}
     * to store {@link Waypoint} instances.
     */
    public Tracker() {
        mWaypoints = new ArrayList<>();
    }

    /**
     * Creates a new {@link Tracker} and loads formatted {@link Waypoint} instances from a file.
     * @param waypointFile The file that contains the {@link Waypoint} instances.
     */
    public Tracker(File waypointFile) {
        mWaypoints = new ArrayList<>();
        mWaypointFile = waypointFile;

        loadWaypointsFromFile(mWaypointFile);
    }

    /**
     * Loads {@link Waypoint} instances from the specified file.
     * @param file The file from which to retrieve {@link Waypoint} instances.
     */
    public void loadWaypointsFromFile(File file) {
        Scanner fileReader = null;

        try {
            fileReader = new Scanner(file);

            String line = null;
            while (fileReader.hasNext()) {
                Waypoint currentWaypoint;
                Point currentPoint;
                String[] tokens;
                String[] positionTokens;
                String location;
                float xPos, yPos, zPos;

                line = fileReader.nextLine();
                
                if (line.contains(DELIMITER)) {
                    tokens = line.split(DELIMITER);
                    location = tokens[0];

                    tokens[1] = tokens[1].replaceAll("[(),]", "");


                    positionTokens = tokens[1].split(" ");
                    xPos = Float.parseFloat(positionTokens[0]);
                    yPos = Float.parseFloat(positionTokens[1]);
                    zPos = Float.parseFloat(positionTokens[2]);

                    currentPoint = new Point(xPos, yPos, zPos);
                    currentWaypoint = new Waypoint(location, currentPoint);

                    mWaypoints.add(currentWaypoint);
                }
                else {
                    System.out.println("File contains unexpected contents. Quitting.");
                    mWaypointFile = null;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found.");
            mWaypointFile = null;
        } finally {
            if (fileReader.hasNextLine())
                fileReader.close();
        }
    }

    /**
     * Adds a new {@link Waypoint} object to the {@link List}.
     * @param waypoint The {@link Waypoint} instance to add to te {@link List}.
     */
    public void addWaypoint(Waypoint waypoint) {
        mWaypoints.add(waypoint);
        Collections.sort(mWaypoints);
    }

    /**
     * Displays all of the available {@link Waypoint} instances currently stored in the {@link ArrayList}.
     */
    public void showWaypoints() {
        if (mWaypoints.isEmpty())
            System.out.println("No waypoints currently exist.");
        else
            mWaypoints.forEach(wp -> {
                System.out.println(wp);
            });
    }

    /**
     * Writes all the {@link Waypoint} instances to a file. If a file was not used 
     * when creating a {@link Tracker} instance, the user is given the ability to 
     * save {@link Waypoint} instances to a new file.
     */
    public void saveWaypoints() {
        JFileChooser fileChooser;
        int fileReturnValue;

        if (mWaypointFile != null) {
            saveData();
        }
        else {
            fileChooser = new JFileChooser();
            fileReturnValue = fileChooser.showSaveDialog(null);
            if (fileReturnValue == JFileChooser.APPROVE_OPTION) {
                mWaypointFile = fileChooser.getSelectedFile();
                saveData();
            }
        }
    }

    private void saveData() {
        PrintWriter waypointWriter = null;
        
        try {
            waypointWriter = new PrintWriter(mWaypointFile);
            for (Waypoint waypoint : mWaypoints)
                waypointWriter.println(waypoint);

        } catch (IOException e) {
            System.out.println("Error opening file for writing.");
        } finally {
            if (waypointWriter != null)
                waypointWriter.close();
        }
    }
}