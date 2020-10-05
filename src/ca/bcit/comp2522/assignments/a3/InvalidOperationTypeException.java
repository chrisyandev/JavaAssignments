package ca.bcit.comp2522.assignments.a3;

/**
 * InvalidOperationTypeException. A checked exception used when
 * an invalid operator is encountered.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class InvalidOperationTypeException extends Exception {
    /**
     * Passes a custom error message to Exception's constructor.
     * @param operation the invalid operator
     */
    public InvalidOperationTypeException(final char operation) {
        super("'" + operation + "' is an invalid Operation");
    }
}
