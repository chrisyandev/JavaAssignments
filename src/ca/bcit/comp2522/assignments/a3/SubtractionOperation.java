package ca.bcit.comp2522.assignments.a3;

/**
 * SubtractionOperation. Contains methods for subtraction operations.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class SubtractionOperation extends AbstractOperation {

    /** Holds the subtraction operator. */
    private static final char SUBTRACTION_CODE = '-';

    /** Default constructor. Initializes field in superclass. */
    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }

    /**
     * Subtracts the second operand from the first operand.
     * @param operandA first operand
     * @param operandB second operand
     * @return the difference between two operands
     */
    public int perform(final int operandA, final int operandB) {
        return operandA - operandB;
    }
}
