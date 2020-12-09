package ca.bcit.comp2522.assignments.a3;

public class ModulusOperation extends AbstractOperation {

    private static final char ADDITION_CODE = '%';

    public ModulusOperation() {
        super(ADDITION_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA % operandB;
    }
}
