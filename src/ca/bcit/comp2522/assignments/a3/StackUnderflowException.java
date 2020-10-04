package ca.bcit.comp2522.assignments.a3;

/**
 * StackUnderflowException. A checked exception used when
 * operations done to an empty stack are illegal.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class StackUnderflowException extends Exception {
    /**
     * Passes a custom error message to Exception's constructor.
     * @param message a custom error message
     */
    public StackUnderflowException(final String message) {
        super(message);
    }
}
