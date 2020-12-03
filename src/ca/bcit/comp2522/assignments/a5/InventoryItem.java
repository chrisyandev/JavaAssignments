package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;

/**
 * InventoryItem. Represents an item in inventory.
 *
 * @author Chris Yan
 * @version 2020
 */
public class InventoryItem implements Sellable, Serializable {

    private static final long serialVersionUID = 1L;

    /** Invoice Purchase Date. */
    private Date IPD;

    /** Stock Keeping Unit. */
    private long SKU;

    /** Item description. */
    private String desc;

    /** Item name. */
    private String name;

    /** Price item purchased at. */
    private double purchasePrice;

    /** Type of item. */
    private String type;

    /** Whether item can be sold. */
    private boolean sellable;

    /** Whether item is sold. */
    private boolean sold;

    /**
     * Initializes the state. Assumes item is just in inventory and
     * cannot be rented or sold.
     * @param IPD Invoice Purchase Date
     * @param SKU Stock Keeping Unit
     * @param desc item description
     * @param name item name
     * @param purchasePrice price purchased
     * @param type item type
     */
    public InventoryItem(final Date IPD, final long SKU,
                         final String desc, final String name,
                         final double purchasePrice, final String type) {
        this.IPD = IPD;
        this.SKU = SKU;
        this.desc = desc;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.type = type;

        sellable = false;
        sold = false;
    }

    /**
     * Gets whether item can be sold.
     * @return true if sellable
     */
    @Override
    public boolean isSellable() {
        return sellable;
    }

    /**
     * Sets whether item can be sold.
     * @param state true if sellable
     */
    @Override
    public void setSellable(final boolean state) {
        sellable = state;
    }

    /**
     * Gets whether item is sold.
     * @return true if sold
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * Sets whether item is sold.
     * @param sold true if sold
     */
    public void setSold(final boolean sold) {
        this.sold = sold;
    }

    /**
     * Gets the Invoice Purchase Date.
     * @return Invoice Purchase Date
     */
    public Date getIPD() {
        return IPD;
    }

    /**
     * Gets the Stock Keeping Unit.
     * @return Stock Keeping Unit
     */
    public long getSKU() {
        return SKU;
    }

    /**
     * Gets the item description.
     * @return item description
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Gets the item name.
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price item was purchased at.
     * @return price item was purchased at
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Gets the type of the item.
     * @return type of the item
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the Invoice Purchase Date.
     * @param IPD Invoice Purchase Date
     */
    public void setIPD(final Date IPD) {
        this.IPD = IPD;
    }

    /**
     * Sets the Stock Keeping Unit.
     * @param SKU Stock Keeping Unit
     */
    public void setSKU(final long SKU) {
        this.SKU = SKU;
    }

    /**
     * Sets the description.
     * @param desc description
     */
    public void setDesc(final String desc) {
        this.desc = desc;
    }

    /**
     * Sets the item name.
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets the price item was purchased at.
     * @param purchasePrice
     */
    public void setPurchasePrice(final double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * Sets the type of the item.
     * @param type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Checks if two InventoryItems are equal. If the Objects are
     * InventoryItems, checks if they are equal based on their properties.
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
        InventoryItem other = (InventoryItem) o;
        return other.IPD.equals(IPD)
                && other.SKU == SKU
                && other.name.equals(name)
                && other.desc.equals(desc)
                && other.type.equals(type);
    }

    /**
     * Creates a hash code based on some properties.
     * @return a hash code
     */
    @Override
    public int hashCode() {
        final int multiplier = 7;
        int result = 5;
        result = multiplier * result + IPD.hashCode();
        result = multiplier * result + Long.hashCode(SKU);
        result = multiplier * result + name.hashCode();
        result = multiplier * result + desc.hashCode();
        result = multiplier * result + type.hashCode();
        return result;
    }

    /**
     * Formats a String containing the object's state.
     * @return a formatted String
     */
    @Override
    public String toString() {
        return "Stock Keeping Unit: " + SKU
                + "\nInvoice Purchase Date: " + IPD
                + "\nPurchase Price: " + purchasePrice
                + "\nName of item: " + name
                + "\nDescription of item: " + desc
                + "\nType of item: " + type;
    }
}
