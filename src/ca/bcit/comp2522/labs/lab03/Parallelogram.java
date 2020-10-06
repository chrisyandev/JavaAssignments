package ca.bcit.comp2522.labs.lab03;

/**
 * Parallelogram. Represents a Quadrilateral where edges opposite
 * of each other are of equal length.
 *
 * @author Chris
 * @version 1.0
 */
public class Parallelogram extends Quadrilateral {

    /** The base length. */
    protected double base;

    /** The height. */
    protected double height;

    /**
     * Initializes the locations of the four Points.
     * @param newP1 the top-left Point.
     * @param newP2 the top-right Point.
     * @param newP3 the bottom-right Point.
     * @param newP4 the bottom-left Point.
     */
    public Parallelogram(final Point newP1, final Point newP2,
                         final Point newP3, final Point newP4) {
        super(newP1, newP2, newP3, newP4);
        base = newP2.getX() - newP1.getX();
        height = newP1.getY() - newP4.getY();
    }

    /**
     * Initializes the locations of the four Points.
     * @param x1 x-coordinate of the top-left Point
     * @param y1 y-coordinate of the top-left Point
     * @param x2 x-coordinate of the top-right Point
     * @param y2 y-coordinate of the top-right Point
     * @param x3 x-coordinate of the bottom-right Point
     * @param y3 y-coordinate of the bottom-right Point
     * @param x4 x-coordinate of the bottom-left Point
     * @param y4 y-coordinate of the bottom-left Point
     */
    public Parallelogram(final double x1, final double y1,
                         final double x2, final double y2,
                         final double x3, final double y3,
                         final double x4, final double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
        base = x2 - x1;
        height = y1 - y4;
    }

    /**
     * Calculates the area.
     * @return the area
     */
    protected double calculateArea() {
        return base * height;
    }
}
