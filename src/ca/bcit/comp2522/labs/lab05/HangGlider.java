package ca.bcit.comp2522.labs.lab05;

/**
 * HangGlider. Represents a hang glider Vehicle.
 *
 * @author Chris Yan
 * @version 2020
 */
public class HangGlider extends Vehicle {

    /** Max height the hang glider can reach. */
    private int maxHeight;

    /**
     * Initializes the hang glider's properties.
     * @param make
     * @param model
     * @param numPassengers
     * @param topSpeed
     * @param maxHeight
     */
    public HangGlider(final String make, final String model,
                      final int numPassengers, final int topSpeed,
                      final int maxHeight) {
        super(make, model, numPassengers, topSpeed);
        this.maxHeight = maxHeight;
    }

    /**
     * Gets the max height the hang glider can reach.
     * @return the max height
     */
    public int getMaxHeight() {
        return maxHeight;
    }

    /**
     * Sets the max height the hang glider can reach.
     * @param maxHeight
     */
    public void setMaxHeight(final int maxHeight) {
        this.maxHeight = maxHeight;
    }
}
