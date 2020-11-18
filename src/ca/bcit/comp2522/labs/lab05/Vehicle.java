package ca.bcit.comp2522.labs.lab05;

/**
 * Vehicle. Represents a thing used for transporting people or goods.
 *
 * @author Chris Yan
 * @version 2020
 */
public class Vehicle {

    /** The company that made the vehicle. */
    private String make;

    /** The vehicle model. */
    private String model;

    /** The passengers the vehicle can hold. */
    private int numPassengers;

    /** The vehicle's top speed. */
    private int topSpeed;

    /**
     * Initializes the vehicle's properties.
     * @param make
     * @param model
     * @param numPassengers
     * @param topSpeed
     */
    public Vehicle(final String make, final String model,
                   final int numPassengers, final int topSpeed) {
        this.make = make;
        this.model = model;
        this.numPassengers = numPassengers;
        this.topSpeed = topSpeed;
    }

    /**
     * Gets the vehicle's make.
     * @return the vehicle's make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the vehicle's make.
     * @param make
     */
    public void setMake(final String make) {
        this.make = make;
    }

    /**
     * Gets the vehicle's model.
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the vehicle's model.
     * @param model
     */
    public void setModel(final String model) {
        this.model = model;
    }

    /**
     * Gets the number of passengers the vehicle can hold.
     * @return the number of passengers
     */
    public int getNumPassengers() {
        return numPassengers;
    }

    /**
     * Sets the number of passengers the vehicle can hold.
     * @param numPassengers
     */
    public void setNumPassengers(final int numPassengers) {
        this.numPassengers = numPassengers;
    }

    /**
     * Gets the vehicle's top speed.
     * @return the top speed
     */
    public int getTopSpeed() {
        return topSpeed;
    }

    /**
     * Sets the vehicle's top speed.
     * @param topSpeed
     */
    public void setTopSpeed(final int topSpeed) {
        this.topSpeed = topSpeed;
    }

    /**
     * Formats the properties of Vehicle.
     * @return a String
     */
    public String toString() {
        return "\nMake: " + make
                + "\nModel: " + model;
    }
}
