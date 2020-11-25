package ca.bcit.comp2522.assignments.a5;

import java.util.Date;

public class RentalItem extends InventoryItem {

    private static final long serialVersionUID = 1L;

    private Condition currentCondition;
    private Rental[] items;
    private long rentalID;
    private double rentalPrice;

    public RentalItem(Date IPD, long SKU, String desc, String name, double purchasePrice, String type, Condition currentCondition, long rentalID, double rentalPrice) {
        super(IPD, SKU, desc, name, purchasePrice, type);
        this.currentCondition = currentCondition;
        this.rentalID = rentalID;
        this.rentalPrice = rentalPrice;

        items = new Rental[] {};
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

    @Override
    public String toString() {
        return "RentalItem";
    }
}
