package ca.bcit.comp2522.labs.lab05;

/**
 * Truck. Represents a truck Vehicle.
 *
 * @author Chris Yan
 * @version 2020
 */
public class Truck extends Vehicle {

    /** How much the truck can tow. */
    private int towingCapacity;

    /** The truck mileage. */
    private int mileage;

    /**
     * Initializes the truck's properties.
     * @param make
     * @param model
     * @param towingCapacity
     * @param numPassengers
     * @param topSpeed
     * @param mileage
     */
    public Truck(final String make, final String model,
                 final int towingCapacity, final int numPassengers,
                 final int topSpeed, final int mileage) {
        super(make, model, numPassengers, topSpeed);
        this.towingCapacity = towingCapacity;
        this.mileage = mileage;
    }

    /**
     * Gets the truck's towing capacity.
     * @return the towing capacity
     */
    public int getTowingCapacity() {
        return towingCapacity;
    }

    /**
     * Sets the truck's towing capacity.
     * @param towingCapacity
     */
    public void setTowingCapacity(final int towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    /**
     * Gets the truck's mileage.
     * @return the mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Sets the truck's mileage.
     * @param mileage
     */
    public void setMileage(final int mileage) {
        this.mileage = mileage;
    }
}
