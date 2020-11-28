package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;

/**
 * Condition. Represents the condition that items can be in.
 *
 * @author Chris Yan
 * @version 2020
 */
public enum Condition implements Serializable {

    /** Average condition. */
    AVERAGE,

    /** Poor condition. */
    POOR,

    /** Excellent condition. */
    EXCELLENT,

    /** Great condition. */
    GREAT,

    /** Damaged condition. */
    DAMAGED
}
