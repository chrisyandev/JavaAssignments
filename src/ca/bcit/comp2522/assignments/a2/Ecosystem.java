package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;

/**
 * Ecosystem. Drives the simulation of an ecosystem.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class Ecosystem {

    /** Collection of Pools. */
    private ArrayList<Pool> pools;

    /**
     * Default constructor that initializes the collection of Pools.
     */
    public Ecosystem() {
        pools = new ArrayList<>();
    }

    /**
     * Adds a Pool to the Ecosystem.
     * @param newPool a Pool instance
     */
    public void addPool(final Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    /** Removes all Pools from the Ecosystem. */
    public void reset() {
        pools.clear();
    }

    /**
     * Gets total population of all pools.
     * @return the total population
     */
    public int getGuppyPopulation() {
        int totalPopulation = 0;
        for (Pool pool : pools) {
            totalPopulation += pool.getPopulation();
        }
        return totalPopulation;
    }

    /**
     * Terminates Guppies in overcrowded pools.
     * @return number of guppies terminated
     */
    public int adjustForCrowding() {
        int totalGuppiesTerminated = 0;
        for (Pool pool : pools) {
            totalGuppiesTerminated += pool.adjustForCrowding();
        }
        return totalGuppiesTerminated;
    }
}
