package ca.bcit.comp2522.assignments.a5;

import java.util.Date;

public class SalesItem extends InventoryItem {

    private static final long serialVersionUID = 1L;

    private double salePrice;
    private long salesID;

    public SalesItem(Date IPD, long SKU, String desc, String name, double purchasePrice, String type, double salePrice, long salesID) {
        super(IPD, SKU, desc, name, purchasePrice, type);
        this.salePrice = salePrice;
        this.salesID = salesID;
    }

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
