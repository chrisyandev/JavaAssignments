package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;

/**
 * SalesItem. Represents an item that can be sold.
 *
 * @author Chris Yan
 * @version 2020
 */
public class SalesItem extends InventoryItem implements Serializable {

    /* Used for serialization */
    private static final long serialVersionUID = 1L;

    /** Used to generate unique salesIDs. */
    private static long idCounter = 10L;

    /** Price item is selling for. */
    private double salePrice;

    /** Unique item identifier. */
    private long salesID;

    /**
     * Initializes the state and sets the salesID.
     * @param IPD Invoice Purchase Date
     * @param SKU Stock Keeping Unit
     * @param desc item description
     * @param name item name
     * @param purchasePrice price purchased
     * @param type item type
     * @param salePrice selling price
     */
    public SalesItem(final Date IPD, final long SKU, final String desc,
                     final String name, final double purchasePrice,
                     final String type, final double salePrice) {
        super(IPD, SKU, desc, name, purchasePrice, type);
        this.salePrice = salePrice;
        salesID = idCounter;
        idCounter++;

        super.setSellable(true);
    }

    /**
     * Gets the selling price.
     * @return the selling price
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * Gets the sales ID.
     * @return the sales ID
     */
    public long getSalesID() {
        return salesID;
    }

    /**
     * Sets the selling price.
     * @param salePrice
     */
    public void setSalePrice(final double salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * Sets the sales ID.
     * @param salesID
     */
    public void setSalesID(final long salesID) {
        this.salesID = salesID;
    }

    /**
     * Formats a String containing the object's state.
     * @return a formatted String
     */
    public String toString() {
        return super.toString() + "\nSale ID: " + salesID
                + "\nSales price: " + salePrice
                + "\nSold: " + super.isSold();
    }
}
