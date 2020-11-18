package ca.bcit.comp2522.labs.lab05;

/*
 * Motorcycle.java
 */
public class Motorcycle {

    private String make;
    private String model;
    private int numPassengers;
    private int topSpeed;
    private int mileage;
    private int decibels;

    /** Creates a new instance of Motorcycle */
    public Motorcycle() {
    }
    public Motorcycle(String make, String model, int numPassengers, int topSpeed, int mileage,int decibels) {
        this.make = make;
        this.model = model;
        this.numPassengers = numPassengers;
        this.topSpeed = topSpeed;
        this.mileage = mileage;
        this.decibels= decibels;
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

    public int getDecibels() {
        return decibels;
    }

    public void setDecibels(int decibels) {
        this.decibels = decibels;
    }

}
