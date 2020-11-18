package ca.bcit.comp2522.labs.lab05;

/**
 * Submersible. Represents a object that can be submersed in water.
 *
 * @author Chris Yan
 * @version 2020
 */
public interface Submersible {

    /**
     * Gets the max depth the object can reach.
     * @return the max depth
     */
    int getMaxDepth();

    /**
     * Sets the max depth the object can reach.
     * @param maxDepth
     */
    void setMaxDepth(int maxDepth);

}
