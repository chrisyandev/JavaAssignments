package ca.bcit.comp2522.assignments.a3;

/**
 * StackOverflowException. A checked exception used when
 * operations done to a full stack are illegal.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class StackOverflowException extends Exception {
    /**
     * Passes a custom error message to Exception's constructor.
     * @param message a custom error message
     */
    public StackOverflowException(final String message) {
        super(message);
    }
}
