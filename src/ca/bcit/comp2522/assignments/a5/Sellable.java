package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;

public interface Sellable extends Serializable {

    boolean isSellable();

    void setSellable(boolean state);

}
