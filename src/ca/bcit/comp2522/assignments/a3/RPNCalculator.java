package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

/**
 * RPNCalculator. Contains methods to perform calculations
 * using Reverse Polish Notation.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class RPNCalculator {

    /** The minimum size of the Stack. */
    public static final int MIN_STACK_SIZE = 2;

    /** Holds the Stack. */
    private Stack stack;

    /**
     * Sets up an RPNCalculator.
     * @param stackSize max number of operands the Stack can hold
     */
    public RPNCalculator(final int stackSize) {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException(
                    "stackSize must be at least " + MIN_STACK_SIZE);
        }
        stack = new Stack(stackSize);
    }

    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     *
     * Example usage: RPNCalculator 10 "1 2 +"
     *
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     * to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {
        // Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }
        // Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);
        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println(
                    "formula can only contain integers, +, -, *, /, and %");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands in the formula, "
                    + "increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }

    /**
     * Parses the input. Operands are added to the Stack.
     * When an operator is encountered, the operation is performed.
     * @param formula the input string in RPN format
     * @return result after all operations are performed
     * @throws StackUnderflowException if the Stack is empty
     * @throws StackOverflowException if the Stack is full
     * @throws InvalidOperationTypeException if an operator is invalid
     */
    public int processFormula(final String formula)
            throws StackUnderflowException, StackOverflowException,
            InvalidOperationTypeException {
        if (formula == null) {
            throw new IllegalArgumentException(
                    "The String can't be null");
        }
        if (formula.trim().equals("")) {
            throw new StackUnderflowException("The String can't be empty");
        }
        Scanner scan = new Scanner(formula);
        Operation operation;
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                push(scan.nextInt());
            } else {
                operation = getOperation(scan.next().charAt(0));
                perform(operation);
            }
        }
        return getResult();
    }

    /**
     * Pops the last two operands from the Stack and performs an operation
     * on them. Pushes the result back onto the Stack.
     * @param operation the operation to be performed
     * @throws StackUnderflowException if the Stack is empty
     * @throws StackOverflowException if the Stack is full
     */
    public void perform(final Operation operation)
            throws StackUnderflowException, StackOverflowException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        }
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        int result = operation.perform(operand1, operand2);
        stack.push(result);
    }

    /**
     * Pushes a value to the Stack.
     * @param operand the value to be pushed
     * @throws StackOverflowException if the Stack is full
     */
    public void push(final int operand) throws StackOverflowException {
        if (stack.unused() == 0) {
            throw new StackOverflowException("The stack is full");
        }
        stack.push(operand);
    }

    /**
     * Gets the type of Operation based on the operator.
     * @param symbol the operator
     * @return the type of Operation
     * @throws InvalidOperationTypeException if the operator is invalid
     */
    private Operation getOperation(final char symbol)
            throws InvalidOperationTypeException {
        switch (symbol) {
            case '+':
                return new AdditionOperation();
            case '-':
                return new SubtractionOperation();
            case '*':
                return new MultiplicationOperation();
            case '/':
                return new DivisionOperation();
            case '%':
                return new ModulusOperation();
            default:
                throw new InvalidOperationTypeException(symbol);
        }
    }

    /**
     * Gets the end result after performing all operations.
     * @return the end result, which is at the top of the Stack
     * @throws StackUnderflowException if the Stack is empty
     */
    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException("There are no operands!");
        }
        return stack.peek();
    }
}
