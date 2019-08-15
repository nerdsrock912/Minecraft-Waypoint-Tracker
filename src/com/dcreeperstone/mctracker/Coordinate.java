package com.dcreeperstone.mctracker;

/**
 * 
 */
public class Coordinate {

    private final float mXCoordinate;
    private final float mYCoordinate;
    private final float mZCoordinate;

    /**
     * Creates a new coordinate using (x, y, z) sub-coordinates.
     * @param xCoordinate The x-coordinate of the location.
     * @param yCoordinate The y-coordinate of the location.
     * @param zCoordinate The z-coordinate of the location.
     */
    public Coordinate(float xCoordinate, float yCoordinate, float zCoordinate) {
        mXCoordinate = xCoordinate;
        mYCoordinate = yCoordinate;
        mZCoordinate = zCoordinate;
    }

    /**
     * Gets the value of the x-coordinate member.
     * @return The x-coordinate.
     */
    public float getXCoordinate() { 
        return mXCoordinate;
    }

    /**
     * Gets the value of the y-coordinate member.
     * @return The y-coordinate.
     */
    public float getYCoordinate() {
        return mYCoordinate;
    }

    /**
     * Gets the value of the z-coordinate member.
     * @return The z-coordinate.
     */
    public float getZCoordinate() {
        return mZCoordinate;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("(");
        output.append(String.format("%.2f, ", mXCoordinate));
        output.append(String.format("%.2f, ", mYCoordinate));
        output.append(String.format("%.2f", mZCoordinate));
        output.append(")");

        return output.toString();
    }

}