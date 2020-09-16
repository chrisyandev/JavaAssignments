package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Tortoise. Represents a tortoise that can move forwards and backwards.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class Tortoise {

    /** Tortoise's current position. */
    private int position;

    /** Tortoise starts at position 0. */
    public Tortoise() {
        position = 0;
    }

    private int randNum(final int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }

    /**
     * Random number is generated between 0 inclusive and 100 exclusive.
     * If number is 0 to 49, tortoise moves forward 3 units.
     * If number is 50 to 69, tortoise moves backward 6 units.
     * If number is 70 to 99, tortoise moves forward 1 unit.
     * @return the tortoise's new position
     */
    public int move() {
        int roll = randNum(100);

        if (roll < 50) {
            position += 3;
            return position;
        }
        if (roll < 70) {
            position -= 6;
            return position;
        }

        position += 1;
        return position;
    }

    /**
     * Gets the tortoise's current position.
     * @return the tortoise's current position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the tortoise's position.
     * @param position a new position
     */
    public void setPosition(final int position) {
        this.position = position;
    }

    /**
     * Prints out the tortoise's current position.
     * @return a formatted string with tortoise's current position
     */
    public String toString() {
        return "The tortoise's current position is: " + position;
    }

    /**
     * Compares whether two objects are Tortoise objects,
     * then whether they are aliases of each other.
     * @param obj is the other instance to compare
     * @return true if two objects are aliases
     */
    public boolean equals(final Object obj) {
        if (!(obj instanceof Tortoise)) {
            return false;
        }
        Tortoise h = (Tortoise) obj;
        return this.hashCode() == h.hashCode();
    }
}
