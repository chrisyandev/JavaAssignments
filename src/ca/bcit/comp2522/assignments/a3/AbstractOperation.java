package ca.bcit.comp2522.assignments.a3;

/**
 * AbstractOperation. An abstract implementation of Operation.
 *
 * @author Chris Yan
 * @version 1.0
 */
public abstract class AbstractOperation implements Operation {

    /** Holds the operator symbol. */
    protected char operationType;

    /**
     * Sets the operator symbol.
     * @param newOperationType the operator symbol
     */
    public AbstractOperation(final char newOperationType) {
        operationType = newOperationType;
    }

    /**
     * Gets the operator symbol.
     * @return the operator symbol
     */
    public final char getSymbol() {
        return operationType;
    }
}
