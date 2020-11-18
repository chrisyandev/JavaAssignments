package ca.bcit.comp2522.labs.lab05;

/**
 * Car. Represents a car Vehicle.
 *
 * @author Chris Yan
 * @version 2020
 */
public class Car extends Vehicle {

    /** The car's mileage. */
    private int mileage;

    /**
     * Initializes the car's properties.
     * @param make
     * @param model
     * @param numPassengers
     * @param topSpeed
     * @param mileage
     */
    public Car(final String make, final String model,
               final int numPassengers, final int topSpeed,
               final int mileage) {
        super(make, model, numPassengers, topSpeed);
        this.mileage = mileage;
    }

    /**
     * Gets the car's mileage.
     * @return the mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Sets the car's mileage.
     * @param mileage
     */
    public void setMileage(final int mileage) {
        this.mileage = mileage;
    }

    /**
     * Formats the properties of Car.
     * @return a String
     */
    public String toString() {
        return super.toString() + "\nMileage: " + mileage;
    }
}
