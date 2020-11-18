package ca.bcit.comp2522.labs.lab05;

/**
 * Motorcycle. Represents a motorcycle Vehicle.
 *
 * @author Chris Yan
 * @version 2020
 */
public class Motorcycle extends Vehicle {

    /** Mileage of the motorcycle. */
    private int mileage;

    /** Loudness of the motorcycle in decibels. */
    private int decibels;

    /**
     * Initializes the motorcycle's properties.
     * @param make
     * @param model
     * @param numPassengers
     * @param topSpeed
     * @param mileage
     * @param decibels
     */
    public Motorcycle(final String make, final String model,
                      final int numPassengers, final int topSpeed,
                      final int mileage, final int decibels) {
        super(make, model, numPassengers, topSpeed);
        this.mileage = mileage;
        this.decibels = decibels;
    }

    /**
     * Gets the motorcycle mileage.
     * @return the mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Sets the motorcycle mileage.
     * @param mileage
     */
    public void setMileage(final int mileage) {
        this.mileage = mileage;
    }

    /**
     * Gets the motorcycle's loudness in decibels.
     * @return the loudness in decibels
     */
    public int getDecibels() {
        return decibels;
    }

    /**
     * Sets the motorcycle's loudness in decibels.
     * @param decibels
     */
    public void setDecibels(final int decibels) {
        this.decibels = decibels;
    }
}
