package com.dcreeperstone.mctracker;

/**
 * 
 */
public class Waypoint implements Comparable<Waypoint> {

    private final String mLocation;
    private final Coordinate mCoordinates;

    /**
     * 
     * @param location
     * @param coordinates
     */
    public Waypoint(String location, Coordinate coordinates) {
        mLocation = location;
        mCoordinates = coordinates;
    }

    /**
     * 
     * @param location
     * @param xCoordinate
     * @param yCoordinate
     * @param zCoordinate
     */
    public Waypoint(String location, float xCoordinate, float yCoordinate, float zCoordinate) {
        mLocation = location;
        mCoordinates = new Coordinate(xCoordinate, yCoordinate, zCoordinate);
    }

    @Override
    public int compareTo(Waypoint waypoint) {
        return mLocation.compareTo(waypoint.mLocation);
    }

    /**
     * 
     * @return
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * 
     * @return
     */
    public Coordinate getCoordinates() {
        return mCoordinates;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(mLocation + ": ");
        output.append(mCoordinates);

        return output.toString();
    }
}