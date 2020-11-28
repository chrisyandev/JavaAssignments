package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;

/**
 * RentalItem. Represents an item that can be rented.
 *
 * @author Chris Yan
 * @version 2020
 */
public class RentalItem extends InventoryItem implements Serializable {

    /* Used for serialization */
    private static final long serialVersionUID = 1L;

    /** Used for generating a unique rental ID. */
    private static long idCounter = 100L;

    /** The item's current condition. */
    private Condition currentCondition;

    /** Contains all Rentals this item has been part of. */
    private Rental[] items;

    /** Unique RentalItem identifier. */
    private long rentalID;

    /** Price to rent this item. */
    private double rentalPrice;

    /**
     * Initializes the state. Assumes item can be sold only if
     * its condition is excellent.
     * @param IPD Invoice Purchase Date
     * @param SKU Stock Keeping Unit
     * @param desc item description
     * @param name item name
     * @param purchasePrice price purchased
     * @param type item type
     * @param currentCondition item's current condition
     * @param rentalPrice price to rent
     */
    public RentalItem(final Date IPD, final long SKU, final String desc,
                      final String name, final double purchasePrice,
                      final String type, final Condition currentCondition,
                      final double rentalPrice) {
        super(IPD, SKU, desc, name, purchasePrice, type);
        this.currentCondition = currentCondition;
        this.rentalPrice = rentalPrice;
        items = new Rental[] {};
        rentalID = idCounter;
        idCounter++;

        if (currentCondition == Condition.EXCELLENT) {
            super.setSellable(true);
        } else {
            super.setSellable(false);
        }
    }

    /**
     * Gets the current item condition.
     * @return item condition
     */
    public Condition getCurrentCondition() {
        return currentCondition;
    }

    /**
     * Gets the Rentals this item has been part of.
     * @return the Rental history
     */
    public Rental[] getItems() {
        return items;
    }

    /**
     * Gets the unique rental item identifier.
     * @return unique rental item identifier
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Gets the rental price.
     * @return the rental price
     */
    public double getRentalPrice() {
        return rentalPrice;
    }

    /**
     * Sets the item's current condition.
     * @param currentCondition
     */
    public void setCurrentCondition(final Condition currentCondition) {
        this.currentCondition = currentCondition;
    }

    /**
     * Adds to the item's Rental history.
     * @param items Rentals to be added
     */
    public void setItems(final Rental[] items) {
        Rental[] newItems = new Rental[this.items.length + items.length];

        for (int i = 0; i < this.items.length; i++) {
            newItems[i] = this.items[i];
        }
        for (int i = 0; i < items.length; i++) {
            newItems[i + this.items.length] = items[i];
        }
        this.items = newItems;
    }

    /**
     * Sets the rental ID.
     * @param rentalID
     */
    public void setRentalID(final long rentalID) {
        this.rentalID = rentalID;
    }

    /**
     * Sets the rental price.
     * @param rentalPrice
     */
    public void setRentalPrice(final double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    /**
     * Formats a String containing the object's state.
     * @return a formatted String
     */
    @Override
    public String toString() {
        return super.toString() + "\nRental ID: " + rentalID
                + "\nRental price: " + rentalPrice
                + "\nCurrent item condition: " + currentCondition;
    }
}
