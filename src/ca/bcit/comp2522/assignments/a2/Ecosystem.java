package ca.bcit.comp2522.assignments.a2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;

/**
 * Ecosystem. Drives the simulation of an ecosystem.
 *
 * @author Chris Yan
 * @version 1.0
 */
public final class Ecosystem {

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

    /** Sets up the simulation. */
    public void setupSimulation() {
        reset();
        final int skookumchukPopulation = 300;
        final int squamishPopulation = 100;
        final int semiahmooPopulation = 200;

        Pool skookumchuk = new Pool("Skookumchuk", 3000, 42, 7.9, 0.9);
        Pool squamish = new Pool("Squamish", 15000, 39, 7.7, 0.85);
        Pool semiahmoo = new Pool("Semiahmoo", 4500, 37, 7.5, 0.85);
        addPool(skookumchuk);
        addPool(squamish);
        addPool(semiahmoo);

        for (int i = 0; i < skookumchukPopulation; i++) {
            skookumchuk.addGuppy(createGuppy(
                    "Poecilia", "reticulata", 10, 25, 0.5, 0.8, 0.75));
        }
        for (int i = 0; i < squamishPopulation; i++) {
            squamish.addGuppy(createGuppy(
                    "Poecilia", "reticulata", 10, 15, 0.8, 1.0, 0.75));
        }
        for (int i = 0; i < semiahmooPopulation; i++) {
            semiahmoo.addGuppy(createGuppy(
                    "Poecilia", "reticulata", 15, 49, 0.0, 1.0, 0.35));
        }
    }

    /*
    Helper method for creating a Guppy with random attributes
    chanceOfFemale is on the scale of 0.0 to 1.0 exclusive.
    */
    private Guppy createGuppy(final String genus,
                         final String species,
                         final int minAgeInWeeks,
                         final int maxAgeInWeeks,
                         final double minHealthCoefficient,
                         final double maxHealthCoefficient,
                         final double chanceOfFemale) {
        Random rand = new Random();
        int ageInWeeks = rand.nextInt(
                maxAgeInWeeks - minAgeInWeeks + 1) + minAgeInWeeks;

        double healthCoefficient = rand.nextDouble() * (maxHealthCoefficient
                - minHealthCoefficient) + minHealthCoefficient;
        // Rounds health coefficient to two decimal places
        BigDecimal bd = new BigDecimal(healthCoefficient).setScale(
                2, RoundingMode.HALF_UP);
        healthCoefficient = bd.doubleValue();

        boolean isFemale = (rand.nextDouble() < chanceOfFemale);

        return new Guppy(
                genus, species, ageInWeeks, isFemale, 1, healthCoefficient);
    }

    /**
     * Runs weekly simulations multiple times.
     * @param numberOfWeeks number of weeks to simulate
     */
    public void simulate(final int numberOfWeeks) {
        for (int i = 0; i < numberOfWeeks; i++) {
            simulateOneWeek(i + 1);
        }
    }

    /**
     * Simulates one week in an Ecosystem.
     * Outputs simulation results for that week.
     * @param weekNum the week number the simulation is on
     */
    public void simulateOneWeek(final int weekNum) {
        int numberRemoved = 0;
        int diedOfOldAge = 0;
        int starvedToDeath = 0;
        int newFry = 0;
        int crowdedOut = 0;

        for (Pool pool : pools) {
            diedOfOldAge += pool.incrementAges();
            numberRemoved += pool.removeDeadGuppies();

            starvedToDeath += pool.applyNutrientCoefficient();
            numberRemoved += pool.removeDeadGuppies();

            newFry += pool.spawn();

            crowdedOut += pool.adjustForCrowding();
            numberRemoved += pool.removeDeadGuppies();
        }
        if (diedOfOldAge + starvedToDeath + crowdedOut != numberRemoved) {
            System.out.println("Logic error: Number that died doesn't "
                    + "match number removed.");
        }

        System.out.println("===== Week " + weekNum + " =====");
        System.out.println("Deaths due to old age: " + diedOfOldAge);
        System.out.println("Deaths due to starvation: " + starvedToDeath);
        System.out.println("Deaths due to overcrowding: " + crowdedOut);
        System.out.println("Number of new fry: " + newFry);
        System.out.println("List of Pools:");
        for (Pool pool : pools) {
            System.out.println(pool.getName() + ", Population: "
                    + pool.getPopulation());
        }
        System.out.println("Total Population of Ecosystem: "
                + getGuppyPopulation() + "\n");
    }
}
