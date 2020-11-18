package ca.bcit.comp2522.labs.lab05;

/*
 * Truck.java
 */
public class Truck {

    private String make;
    private String model;
    private int towingCapacity;
    private int numPassengers;
    private int topSpeed;
    private int mileage;

    /** Creates a new instance of Truck */
    public Truck() {
    }
    public Truck(String make, String model, int towingCapacity, int numPassengers, int topSpeed, int mileage) {
        this.make = make;
        this.model = model;
        this.towingCapacity = towingCapacity;
        this.numPassengers = numPassengers;
        this.topSpeed = topSpeed;
        this.mileage = mileage;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTowingCapacity() {
        return towingCapacity;
    }

    public void setTowingCapacity(int towingCapacity) {
        this.towingCapacity = towingCapacity;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

}
