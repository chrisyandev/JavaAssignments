package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;

/**
 * Sellable. Represents an item that is able to be sold.
 *
 * @author Chris Yan
 * @version 2020
 */
public interface Sellable extends Serializable {

    /**
     * Gets whether an item can currently be sold.
     * @return true if it can currently be sold
     */
    boolean isSellable();

    /**
     * Sets whether an item can currently be sold.
     * @param state true if it can currently be sold
     */
    void setSellable(boolean state);

}
