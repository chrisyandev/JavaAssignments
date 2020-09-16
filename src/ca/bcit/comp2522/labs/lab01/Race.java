package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Race. Manages the tortoise and hare. Contains methods to simulate the race
 * and outputs who wins.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class Race {

    /** Holds an instance of Tortoise. */
    private Tortoise tortoise;

    /** Holds an instance of Hare. */
    private Hare hare;

    /** The distance of the race. */
    private int length;

    /** The duration of the race. */
    private int ticks;

    /**
     * Creates an instance of Tortoise and Hare. Sets the race distance.
     * Duration of the race starts at 0.
     * @param raceLength the distance of the race
     */
    public Race(final int raceLength) {
        tortoise = new Tortoise();
        hare = new Hare();
        length = raceLength;
        ticks = 0;
    }

    private String race() {
        do {
            final int tortoiseSide = 0;
            final int hareSide = 1;

            Random rand = new Random();
            int coinFlip = rand.nextInt(2);
            if (coinFlip == tortoiseSide) {
                tortoise.move();
            } else {
                hare.move();
            }
            ticks++;
        } while (tortoise.getPosition() < length
                && hare.getPosition() < length);

        if (tortoise.getPosition() > hare.getPosition()) {
            return "Tortoise";
        } else {
            return "Hare";
        }
    }

    /** Sets positions of tortoise and hare to 0 and race duration to 0. */
    public void reset() {
        tortoise.setPosition(0);
        hare.setPosition(0);
        ticks = 0;
    }

    /** Simulates the race. */
    public String simulateRace() {
        reset();
        return race();
    }

    /** Gets the Tortoise instance. */
    public Tortoise getTortoise() {
        return tortoise;
    }

    /** Gets the Hare instance. */
    public Hare getHare() {
        return hare;
    }

    /** Gets the race distance. */
    public int getLength() {
        return length;
    }

    /** Gets the race duration. */
    public int getTicks() {
        return ticks;
    }
}
