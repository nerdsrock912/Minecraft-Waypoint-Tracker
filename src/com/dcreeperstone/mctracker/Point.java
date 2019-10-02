package com.dcreeperstone.mctracker;

/**
 * This class functions as a three-dimensional grid system and stores (x, y, z) coordinates for a point.
 */
public class Point {

    private final float mXPosition;
    private final float mYPosition;
    private final float mZPosition;

    /**
     * Creates a new {@link Point} using (x, y, z) sub-positions.
     * @param xPosition The x-position of the location.
     * @param yPosition The y-position of the location.
     * @param zPosition The z-position of the location.
     */
    public Point(float xPosition, float yPosition, float zPosition) {
        mXPosition = xPosition;
        mYPosition = yPosition;
        mZPosition = zPosition;
    }

    /**
     * Gets the value of the x-position.
     * @return The x-Position.
     */
    public float getXPosition() { 
        return mXPosition;
    }

    /**
     * Gets the value of the y-position.
     * @return The y-Position.
     */
    public float getYPosition() {
        return mYPosition;
    }

    /**
     * Gets the value of the z-position.
     * @return The z-Position.
     */
    public float getZPosition() {
        return mZPosition;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append("(");
        output.append(String.format("%.2f, ", mXPosition));
        output.append(String.format("%.2f, ", mYPosition));
        output.append(String.format("%.2f", mZPosition));
        output.append(")");

        return output.toString();
    }

}