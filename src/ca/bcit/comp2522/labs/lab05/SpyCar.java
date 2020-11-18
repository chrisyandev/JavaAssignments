package ca.bcit.comp2522.labs.lab05;

/**
 * SpyCar. Represents a car that can go underwater.
 *
 * @author Chris Yan
 * @version 2020
 */
public class SpyCar extends Car implements Submersible {

    /** Max depth the car can reach. */
    private int maxDepth;

    /**
     * Initializes the spy car's properties.
     * @param make
     * @param model
     * @param numPassengers
     * @param topSpeed
     * @param mileage
     * @param maxDepth
     */
    public SpyCar(final String make, final String model,
                  final int numPassengers, final int topSpeed,
                  final int mileage, final int maxDepth) {
        super(make, model, numPassengers, topSpeed, mileage);
        this.maxDepth = maxDepth;
    }

    /**
     * Gets max depth.
     * @return the max depth
     */
    public int getMaxDepth() {
        return maxDepth;
    }

    /**
     * Sets max depth.
     * @param maxDepth
     */
    public void setMaxDepth(final int maxDepth) {
        this.maxDepth = maxDepth;
    }
}
