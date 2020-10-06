package ca.bcit.comp2522.labs.lab03;

/**
 * Point. Represents a point on a graph.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class Point {

    /** The x-coordinate. */
    private double x;

    /** The y-coordinate. */
    private double y;

    /**
     * Initializes the coordinates.
     * @param newX the x-coordinate
     * @param newY the y-coordinate
     */
    public Point(final double newX, final double newY) {
        x = newX;
        y = newY;
    }

    /**
     * Gets the x-coordinate.
     * @return the x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate.
     * @return the y-coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Provides a formatted output.
     * @return a formatted String
     */
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
}
