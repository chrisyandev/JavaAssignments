package ca.bcit.comp2522.assignments.a5;

public class RentalItem extends InventoryItem {

    private Condition currentCondition;
    private Rental[] items;
    private long rentalID;
    private double rentalPrice;
    private long serialVersionUID;

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
        this.items = items;
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
