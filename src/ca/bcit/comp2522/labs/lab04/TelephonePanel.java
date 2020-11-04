package ca.bcit.comp2522.labs.lab04;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TelephonePanel. Represents a user interface for interacting
 * with a telephone panel.
 *
 * @author Chris Yan
 * @version 1.0
 */
public class TelephonePanel extends JPanel {

    /** Constructs the telephone panel. */
    public TelephonePanel() {
        this.setLayout(new BorderLayout());

        JPanel titleContainer = new JPanel();
        this.add(titleContainer, BorderLayout.NORTH);
        JLabel title = new JLabel("Your Telephone");
        titleContainer.add(title);

        JPanel keypad = new JPanel();
        keypad.setLayout(new GridLayout(4, 3));
        keypad.add(new Button("1"));
        keypad.add(new Button("2"));
        keypad.add(new Button("3"));
        keypad.add(new Button("4"));
        keypad.add(new Button("5"));
        keypad.add(new Button("6"));
        keypad.add(new Button("7"));
        keypad.add(new Button("8"));
        keypad.add(new Button("9"));
        keypad.add(new Button("*"));
        keypad.add(new Button("0"));
        keypad.add(new Button("#"));
        this.add(keypad, BorderLayout.CENTER);

        KeyPadListener kpListener = new KeyPadListener();
        Component[] buttons = keypad.getComponents();
        // Adds an ActionListener to every button
        for (Component c : buttons) {
            if (c.getClass() == Button.class) {
                Button button = (Button) c;
                // Different ActionListeners for non-numeric buttons
                if (button.getLabel().equals("*")) {
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(final ActionEvent e) {
                            System.out.println("key pressed: *");
                        }
                    });
                } else if (button.getLabel().equals("#")) {
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(final ActionEvent e) {
                            System.out.println("key pressed: #");
                        }
                    });
                } else {
                    button.addActionListener(kpListener);
                }
            }
        }
    }

    /** Represents an ActionListener for keypad number buttons. */
    class KeyPadListener implements ActionListener {
        public void actionPerformed(final ActionEvent e) {
            if (e.getSource().getClass() == Button.class) {
                Button button = (Button) e.getSource();
                int num = Integer.parseInt(button.getLabel());
                System.out.println("key pressed: " + num);
            }
        }
    }
}
