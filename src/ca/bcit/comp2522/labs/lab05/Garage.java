package ca.bcit.comp2522.labs.lab05;

import java.util.*;

/**
 * Garage. Represents a garage that holds Vehicles.
 *
 * @author Chris Yan
 * @version 2020
 */
public class Garage {

    /** A list of Vehicles in the Garage. */
    private ArrayList<Vehicle> garage = null;

    /** Creates a new instance of Garage. */
    public Garage() {
        garage = new ArrayList<Vehicle>();
    }

    /**
     * Adds a Vehicle to the Garage.
     * @param x a Vehicle
     */
    public void add(final Vehicle x) {
        garage.add(x);
    }

    /** Prints the inventory of Vehicles in the Garage. */
    public void report() {
        System.out.println("My garage has ...");
        for (Vehicle x:garage) {
            System.out.println(x.toString());
        }

        System.out.print("\nIf I filled them all, I could hold ");
        int count = 0;
        for (Vehicle x : garage) {
            count += x.getNumPassengers();
        }
        System.out.println("" + count + " passengers");
    }
}
