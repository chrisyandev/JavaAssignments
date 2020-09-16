package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Hare. Represents a hare that can move forwards and backwards.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class Hare {

    /** Hare's current position. */
    private int position;

    /** Hare starts at position 0. */
    public Hare() {
        position = 0;
    }

    private int randNum(final int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }

    /**
     * Random number is generated between 0 inclusive and 100 exclusive.
     * If number is 0 to 19, hare doesn't move.
     * If number is 20 to 29, hare moves forward 9 units.
     * If number is 30 to 39, hare moves backward 12 units.
     * If number is 40 to 69, hare moves forward 1 unit.
     * If number is 70 to 99, hare moves backward 2 units.
     * @return the hare's new position
     */
    public int move() {
        int roll = randNum(100);

        if (roll < 20) {
            return position;
        }
        if (roll < 30) {
            position += 9;
            return position;
        }
        if (roll < 40) {
            position -= 12;
            return position;
        }
        if (roll < 70) {
            position += 1;
            return position;
        }

        position -= 2;
        return position;
    }

    /**
     * Gets the hare's current position.
     * @return the hare's current position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the hare's position.
     * @param position a new position
     */
    public void setPosition(final int position) {
        this.position = position;
    }

    /**
     * Prints out the hare's current position.
     * @return a formatted string with hare's current position
     */
    public String toString() {
        return "The hare's current position is: " + position;
    }

    /**
     * Compares whether two objects are Hare objects,
     * then whether they are aliases of each other.
     * @param obj is the other instance to compare
     * @return true if two objects are aliases
     */
    public boolean equals(final Object obj) {
        if (!(obj instanceof Hare)) {
            return false;
        }
        Hare h = (Hare) obj;
        return this.hashCode() == h.hashCode();
    }
}
