package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;

public class InventoryItem implements Sellable, Serializable {

    private Date IPD;
    private long SKU;
    private String desc;
    private String name;
    private double purchasePrice;
    private long serialVersionUID;
    private String type;

    boolean sellable;
    boolean sold;

    @Override
    public boolean isSellable() {
        return sellable;
    }

    @Override
    public void setSellable(boolean state) {
        sellable = state;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Date getIPD() {
        return IPD;
    }

    public long getSKU() {
        return SKU;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public String getType() {
        return type;
    }

    public void setIPD(Date IPD) {
        this.IPD = IPD;
    }

    public void setSKU(long SKU) {
        this.SKU = SKU;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
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

    @Override
    public String toString() {
        return "InventoryItem";
    }
}
