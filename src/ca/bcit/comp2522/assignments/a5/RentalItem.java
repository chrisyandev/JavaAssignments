package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;

public class RentalItem extends InventoryItem implements Serializable {

    private static final long serialVersionUID = 1L;
    private static long idCounter = 100L;

    private Condition currentCondition;

    /** Contains all Rentals this item has been part of. */
    private Rental[] items;

    /** Unique rental identifier. */
    private long rentalID;
    private double rentalPrice;

    public RentalItem(Date IPD, long SKU, String desc, String name, double purchasePrice, String type, Condition currentCondition, double rentalPrice) {
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

    public Condition getCurrentCondition() {
        return currentCondition;
    }

    public Rental[] getItems() {
        return items;
    }

    public long getRentalID() {
        return rentalID;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setCurrentCondition(Condition currentCondition) {
        this.currentCondition = currentCondition;
    }

    public void setItems(Rental[] items) {
        Rental[] newItems = new Rental[this.items.length + items.length];

        for (int i = 0; i < this.items.length; i++) {
            newItems[i] = this.items[i];
        }
        for (int i = 0; i < items.length; i++) {
            newItems[i + this.items.length] = items[i];
        }
        this.items = newItems;
    }

    public void setRentalID(long rentalID) {
        this.rentalID = rentalID;
    }

    public void setRentalPrice(double rentalPrice) {
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
