package ca.bcit.comp2522.labs.lab04;

import javax.swing.*;

/**
 * Telephone. Creates and uses an instance of Telephone.
 *
 * @author Chris Yan
 * @version 1.0
 */
public final class Telephone {
    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        JFrame frame = new JFrame("Telephone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TelephonePanel());
        frame.pack();
        frame.setVisible(true);
    }

    /* Utility classes should not have a public constructor */
    private Telephone() { }
}
