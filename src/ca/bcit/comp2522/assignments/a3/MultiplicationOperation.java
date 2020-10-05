package ca.bcit.comp2522.assignments.a3;

/**
 * MultiplicationOperation. Contains methods for multiplication operations.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class MultiplicationOperation extends AbstractOperation {

    /** Holds the multiplication operator. */
    private static final char MULTIPLICATION_CODE = '*';

    /** Default constructor. Initializes field in superclass. */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    /**
     * Multiplies two operands.
     * @param operandA first operand
     * @param operandB second operand
     * @return the product of two operands
     */
    public int perform(final int operandA, final int operandB) {
        return operandA * operandB;
    }
}
