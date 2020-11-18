package ca.bcit.comp2522.labs.lab05;

/**
 * Submarine. Represents a submarine Vehicle.
 *
 * @author Chris Yan
 * @version 2020
 */
public class Submarine extends Vehicle implements Submersible {

    /** The max depth the submarine can travel. */
    private int maxDepth;

    /**
     * Initializes the submarine's properties.
     * @param make
     * @param model
     * @param topSpeed
     * @param numPassengers
     * @param maxDepth
     */
    public Submarine(final String make, final String model,
                     final int topSpeed, final int numPassengers,
                     final int maxDepth) {
        super(make, model, numPassengers, topSpeed);
        this.maxDepth = maxDepth;
    }

    /**
     * Gets the submarine's max depth.
     * @return the max depth
     */
    public int getMaxDepth() {
        return maxDepth;
    }

    /**
     * Sets the submarine's max depth.
     * @param maxDepth
     */
    public void setMaxDepth(final int maxDepth) {
        this.maxDepth = maxDepth;
    }
}
