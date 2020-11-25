package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;

public class SalesItem extends InventoryItem implements Serializable {

    private static final long serialVersionUID = 1L;
    private static long idCounter = 10L;

    private double salePrice;
    private long salesID;

    public SalesItem(Date IPD, long SKU, String desc, String name, double purchasePrice, String type, double salePrice) {
        super(IPD, SKU, desc, name, purchasePrice, type);
        this.salePrice = salePrice;
        salesID = idCounter;
        idCounter++;

        super.setSellable(true);
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
        return super.toString() + "\nSale ID: " + salesID
                + "\nSales price: " + salePrice
                + "\nSold: " + super.isSold();
    }
}
