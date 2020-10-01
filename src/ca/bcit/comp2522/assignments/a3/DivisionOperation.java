package ca.bcit.comp2522.assignments.a3;

/**
 * DivisionOperation. Contains methods for division operations.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class DivisionOperation extends AbstractOperation {

    /** Holds the division operator. */
    private static final char DIVISION_OPERATION = '/';

    /** Default constructor. Initializes field in superclass. */
    public DivisionOperation() {
        super(DIVISION_OPERATION);
    }

    /**
     * Gets the operator symbol.
     * @return the operator symbol
     */
    public char getSymbol() {
        return DIVISION_OPERATION;
    }

    /**
     * Divides the first operand by the second operand.
     * @param operandA first operand
     * @param operandB second operand
     * @return the quotient of two operands
     */
    public int perform(final int operandA, final int operandB) {
        return operandA / operandB;
    }
}
