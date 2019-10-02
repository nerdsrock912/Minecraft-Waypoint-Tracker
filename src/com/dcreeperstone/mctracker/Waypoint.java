package com.dcreeperstone.mctracker;

/**
 * This class allows the user to classify a specific location in a world according to name and coordinates.
 */
public class Waypoint implements Comparable<Waypoint> {

    private final String mLocation;
    private final Point mPoint;

    /**
     * Creates a new {@link Waypoint} instance with the specified location and {@link Point}.
     * @param location The location of the place.
     * @param point The (x, y, z) coordinates of the place.
     */
    public Waypoint(String location, Point point) {
        mLocation = location;
        mPoint = point;
    }

    /**
     * Creates a new {@link Waypoint} with the specified location and (x, y, z) coordinates.
     * @param location The location of the place.
     * @param xPosition The x-coordinate of the place.
     * @param yPosition The y-coordinate of the place.
     * @param zPosition The z-coordinate of the place.
     */
    public Waypoint(String location, float xPosition, float yPosition, float zPosition) {
        mLocation = location;
        mPoint = new Point(xPosition, yPosition, zPosition);
    }

    @Override
    public int compareTo(Waypoint waypoint) {
        return mLocation.compareTo(waypoint.mLocation);
    }

    /**
     * Gets the location of the {@link Waypoint}.
     * @return The location of the place.
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Gets the coordinates of the {@link Waypoint}.
     * @return The (x, y, z) coordinates of the place.
     */
    public Point getPoint() {
        return mPoint;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(mLocation + ": ");
        output.append(mPoint);

        return output.toString();
    }
}