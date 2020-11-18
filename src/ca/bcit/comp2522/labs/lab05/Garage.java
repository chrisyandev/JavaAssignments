package ca.bcit.comp2522.labs.lab05;

/*
 * Garage.java
 */
import java.util.*;

/**
 *
 * @author Jim
 */
public class Garage {

    private ArrayList<Object> garage = null;

    /** Creates a new instance of Garage */
    public Garage() {
        garage = new ArrayList<Object>();
    }

    public void add(Object x) {
        garage.add(x);
    }

    public void report() {
        System.out.println("My garage has ...");
        for (Object x:garage) {
            System.out.println(x.toString());
        }

        System.out.print("If I filled them all, I could hold ");
        int count = 0;
        for (Object x:garage) {
            if (x instanceof Car) {
                Car car = (Car) x;
                count += car.getNumPassengers();
            }
            if (x instanceof Truck) {
                Truck truck = (Truck) x;
                count += truck.getNumPassengers();
            }
        }
        System.out.println("" + count + " passengers");
    }

}
