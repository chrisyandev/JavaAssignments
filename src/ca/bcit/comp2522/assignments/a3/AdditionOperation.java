package ca.bcit.comp2522.assignments.a3;

/**
 * AdditionOperation. Contains methods for addition operations.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class AdditionOperation extends AbstractOperation {

    /** Holds the addition operator. */
    private static final char ADDITION_CODE = '+';

    /** Default constructor. Initializes field in superclass. */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }

    /**
     * Adds two operands.
     * @param operandA first operand
     * @param operandB second operand
     * @return the sum of two operands
     */
    public int perform(final int operandA, final int operandB) {
        return operandA + operandB;
    }
}
