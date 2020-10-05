package ca.bcit.comp2522.assignments.a3;

/**
 * Stack. Uses an array to implement a stack structure.
 * Includes methods to modify the stack.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class Stack {

    /** Holds the Stack values. */
    private int[] stackValues;

    /** Number of elements in the Stack. */
    private int count;

    /**
     * Initializes an array to hold the Stack.
     * @param size the length of the array
     */
    public Stack(final int size) {
        if (size < 1) {
            throw new IllegalArgumentException("size can't be less than 1");
        }
        stackValues = new int[size];
        count = 0;
    }

    /**
     * Gets the size of the Stack.
     * @return the size of the Stack
     */
    public int capacity() {
        return stackValues.length;
    }

    /**
     * Gets the number of elements in the Stack.
     * @return the number of elements in the Stack
     */
    public int size() {
        return count;
    }

    /**
     * Gets the number of available slots in the Stack.
     * @return the number of available slots
     */
    public int unused() {
        return capacity() - size();
    }

    /**
     * Adds an element to the Stack if there is space.
     * @param value element to be added
     * @throws StackOverflowException if the Stack is full
     */
    public void push(final int value) throws StackOverflowException {
        if (unused() == 0) {
            throw new StackOverflowException("This stack is full!");
        }
        stackValues[count] = value;
        count++;
    }

    /**
     * Removes the element at the top of the Stack if it exists.
     * @return value of the removed element
     * @throws StackUnderflowException if the Stack is empty
     */
    public int pop() throws StackUnderflowException {
        if (size() == 0) {
            throw new StackUnderflowException(
                    "Cannot call Stack.pop() on an empty stack!");
        }
        int popped = stackValues[count - 1];
        stackValues[count - 1] = 0;
        count--;
        return popped;
    }

    /**
     * Gets the value of the element on top of the Stack.
     * @return the value of the top-most element
     * @throws StackUnderflowException if the Stack is empty
     */
    public int peek() throws StackUnderflowException {
        if (size() == 0) {
            throw new StackUnderflowException(
                    "Cannot call Stack.peek() on an empty stack!");
        }
        return stackValues[count - 1];
    }
}
