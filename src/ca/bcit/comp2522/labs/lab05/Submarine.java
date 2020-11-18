package ca.bcit.comp2522.labs.lab05;

/*
 * Submarine.java
 */
public class Submarine {

    private String make;
    private String model;
    private int topSpeed;
    private int numPassengers;
    private int maxDepth;

    /** Creates a new instance of Submarine */
    public Submarine() {
    }
    public Submarine(String make, String model, int topSpeed, int numPassengers, int maxDepth) {
        this.make = make;
        this.model = model;
        this.topSpeed = topSpeed;
        this.numPassengers = numPassengers;
        this.maxDepth = maxDepth;
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

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

}
