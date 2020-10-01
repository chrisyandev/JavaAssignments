package ca.bcit.comp2522.assignments.a3;

/**
 * Operation. Interface for a math operation using Reverse Polish Notation.
 *
 * @author Chris Yan
 * @version 1.0
 */
public interface Operation {
    /**
     * Returns the operation symbol to the user.
     * @return the operation symbol
     */
    char getSymbol();

    /**
     * Performs a math operation.
     * @param operandA first operand
     * @param operandB second operand
     * @return operation result
     */
    int perform(int operandA, int operandB);
}
