package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;

/**
 * Rental. Represents a transaction of renting one item.
 *
 * @author Chris Yan
 * @version 2020
 */
public class Rental implements Serializable {

    /* Used for serialization */
    private static final long serialVersionUID = 1L;

    /** Comments regarding the rental. */
    private String comments;

    /** Item condition after rental. */
    private Condition conditionAfter;

    /** Item condition before rental. */
    private Condition conditionBefore;

    /** Date of rental. */
    private Date date;

    /** Unique RentalItem identifier. */
    private long rentalID;

    /**
     * Initializes the state. Assumes item will be returned
     * in original condition. Adds this Rental to the rented
     * item's history of Rentals.
     * @param comments comments about the rental
     * @param date date of rental
     * @param rentalItem the item to be rented
     */
    public Rental(final String comments, final Date date,
                  final RentalItem rentalItem) {
        this.comments = comments;
        this.date = date;
        rentalID = rentalItem.getRentalID();
        conditionBefore = rentalItem.getCurrentCondition();
        conditionAfter = conditionBefore;
        rentalItem.setItems(new Rental[] {this});
    }

    /**
     * Gets the comments.
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * Gets item condition after rental.
     * @return condition after rental
     */
    public Condition getConditionAfter() {
        return conditionAfter;
    }

    /**
     * Gets item condition before rental.
     * @return condition before rental
     */
    public Condition getConditionBefore() {
        return conditionBefore;
    }

    /**
     * Gets the date of rental.
     * @return date of rental
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the rental ID.
     * @return rental ID
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the comments.
     * @param comments
     */
    public void setComments(final String comments) {
        this.comments = comments;
    }

    /**
     * Sets the item condition after rental.
     * @param conditionAfter
     */
    public void setConditionAfter(final Condition conditionAfter) {
        this.conditionAfter = conditionAfter;
    }

    /**
     * Sets the item condition before rental.
     * @param conditionBefore
     */
    public void setConditionBefore(final Condition conditionBefore) {
        this.conditionBefore = conditionBefore;
    }

    /**
     * Sets the rental ID.
     * @param rentalID
     */
    public void setRentalID(final long rentalID) {
        this.rentalID = rentalID;
    }

    /**
     * Checks if two RentalItems are equal. If the Objects are
     * RentalItems, checks if they are equal based on their properties.
     * @param o the other Object
     * @return true if they are equal
     */
    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o.getClass() == this.getClass())) {
            return false;
        }
        Rental other = (Rental) o;
        return other.comments.equals(comments)
                && other.date.equals(date)
                && other.rentalID == rentalID;
    }

    /**
     * Creates a hashcode based on some properties.
     * @return a hash code
     */
    @Override
    public int hashCode() {
        final int multiplier = 7;
        int result = 5;
        result = multiplier * result + comments.hashCode();
        result = multiplier * result + date.hashCode();
        result = multiplier * result + Long.hashCode(rentalID);
        return result;
    }

    /**
     * Formats a String containing the object's state.
     * @return a formatted String
     */
    @Override
    public String toString() {
        return "Rental ID: " + rentalID
                + "\nRental Date: " + date
                + "\nCondition Before: " + conditionBefore
                + "\nCondition After: " + conditionAfter
                + "\nComments: " + comments;
    }
}
