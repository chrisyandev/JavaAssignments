package ca.bcit.comp2522.assignments.a2;

import java.util.Scanner;

/**
 * Driver. Instantiates an Ecosystem and uses its methods.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class Driver {
    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Ecosystem ecosystem = new Ecosystem();
        ecosystem.setupSimulation();

        System.out.println("Run simulation for how many weeks?");
        int numOfWeeks = scan.nextInt();
        ecosystem.simulate(numOfWeeks);
    }
}
