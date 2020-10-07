package ca.bcit.comp2522.labs.lab03;

/**
 * Driver. Instantiates different types of Quadrilaterals
 * and uses their methods.
 *
 * @author Chris Yan
 * @version 1.0
 */
public final class Driver {

    /* Removes default constructor */
    private Driver() { }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        Quadrilateral quad1 = new Trapezoid(new Point(2, 5),
                new Point(7, 5), new Point(10, 0), new Point(0, 0));
        Quadrilateral quad2 = new Parallelogram(new Point(4, 4),
                new Point(8, 4), new Point(4, 0), new Point(0, 0));
        Quadrilateral quad3 = new Square(new Point(0, 7),
                new Point(7, 7), new Point(7, 0), new Point(0, 0));
        Quadrilateral quad4 = new Rectangle(new Point(0, 4),
                new Point(8, 4), new Point(8, 0), new Point(0, 0));

        if (quad1.getClass() == Trapezoid.class) {
            System.out.println("Trapezoid area: " + quad1.calculateArea());
        }
        if (quad2.getClass() == Parallelogram.class) {
            System.out.println("Parallelogram area: " + quad2.calculateArea());
        }
        if (quad3.getClass() == Square.class) {
            System.out.println("Square area: " + quad3.calculateArea());
        }
        if (quad4.getClass() == Rectangle.class) {
            System.out.println("Rectangle area: " + quad4.calculateArea());
        }
    }
}
