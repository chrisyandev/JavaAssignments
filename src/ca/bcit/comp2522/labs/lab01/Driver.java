package ca.bcit.comp2522.labs.lab01;

/**
 * Driver. Runs multiple instances of Race.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class Driver {

    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        final int units = 100;
        Race race = new Race(units);
        System.out.println(race.simulateRace() + " won the race after "
                + race.getTicks() + " ticks.");
        System.out.println(race.getTortoise());
        System.out.println(race.getHare());

        System.out.println("\n============================\n");

        final int numOfRaces = 100;
        final int raceLength = 1000;
        System.out.println(simulateRaces(numOfRaces, raceLength));
    }

    /**
     * Creates Race instances and uses its methods.
     * @param numOfRaces number of races to run
     * @param raceLength distance of each race
     * @return race results for Tortoise and Hare
     */
    public static String simulateRaces(final int numOfRaces,
                                       final int raceLength) {
        int tortoiseWins = 0;
        int hareWins = 0;
        for (int i = 0; i < numOfRaces; i++) {
            Race race = new Race(raceLength);
            String winner = race.simulateRace();
            if (winner.equals("Tortoise")) {
                tortoiseWins++;
            } else {
                hareWins++;
            }
        }
        return "After " + numOfRaces + " races, each race being "
                + raceLength + " units long, Tortoise won " + tortoiseWins
                + " times. Hare won " + hareWins + " times.";
    }

    /* Answers
        4a) Tortoise won the race after 197 ticks.
            The tortoise's current position is: 100
            The hare's current position is: -71

        4b) Tortoise wins: 99
            Hare wins: 1

        4c) Tortoise wins: 100
            Hare wins: 0

        5) Tortoise wins the most.
     */
}
