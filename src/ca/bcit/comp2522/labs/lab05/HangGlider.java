package ca.bcit.comp2522.labs.lab05;

/*
 * HangGlider.java
 */
public class HangGlider {

    private String model;
    private String make;
    private int numPassengers;
    private int topSpeed;
    private int maxHeight;

    /** Creates a new instance of HangGlider */
    public HangGlider() {
    }
    public HangGlider(String make, String model, int numPassengers, int topSpeed, int maxHeight) {
        this.make = make;
        this.model = model;
        this.numPassengers = numPassengers;
        this.topSpeed = topSpeed;
        this.maxHeight = maxHeight;
    }


    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
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

}
