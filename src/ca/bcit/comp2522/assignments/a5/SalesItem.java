package ca.bcit.comp2522.assignments.a5;

public class SalesItem extends InventoryItem {

    private double salePrice;
    private long salesID;
    private long serialVersionUID;

    public double getSalePrice() {
        return salePrice;
    }

    public long getSalesID() {
        return salesID;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setSalesID(long salesID) {
        this.salesID = salesID;
    }

    public String toString() {
        return "SalesItem";
    }
}
