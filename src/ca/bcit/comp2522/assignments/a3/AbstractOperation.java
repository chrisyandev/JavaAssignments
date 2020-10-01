package ca.bcit.comp2522.assignments.a3;

public abstract class AbstractOperation implements Operation {

    protected char operationType;

    public AbstractOperation(char newOperationType) {
        operationType = newOperationType;
    }

    public final char getOperationType() {
        return operationType;
    }
}
