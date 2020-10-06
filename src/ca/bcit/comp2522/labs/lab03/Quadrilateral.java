package ca.bcit.comp2522.labs.lab03;

/**
 * Quadrilateral. Represents a shape with four edges and four vertices.
 *
 * @author Chris Yan
 * @version 1.0
 */
public abstract class Quadrilateral {

    /** The top-left Point. */
    protected Point p1;

    /** The top-right Point. */
    protected Point p2;

    /** The bottom-right Point. */
    protected Point p3;

    /** The bottom-left Point. */
    protected Point p4;

    /**
     * Initializes the locations of the four Points.
     * @param newP1 the top-left Point.
     * @param newP2 the top-right Point.
     * @param newP3 the bottom-right Point.
     * @param newP4 the bottom-left Point.
     */
    public Quadrilateral(final Point newP1, final Point newP2,
                         final Point newP3, final Point newP4) {
        p1 = newP1;
        p2 = newP2;
        p3 = newP3;
        p4 = newP4;
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
    public Quadrilateral(final double x1, final double y1,
                         final double x2, final double y2,
                         final double x3, final double y3,
                         final double x4, final double y4) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
        p3 = new Point(x3, y3);
        p4 = new Point(x4, y4);
    }

    /**
     * Calculates the area.
     * @return the area
     */
    protected abstract double calculateArea();
}
