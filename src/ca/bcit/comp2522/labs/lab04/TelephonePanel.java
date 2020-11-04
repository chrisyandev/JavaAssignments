package ca.bcit.comp2522.labs.lab04;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelephonePanel extends JPanel {

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
        for (Component c : buttons) {
            if (c.getClass() == Button.class) {
                Button button = (Button) c;
                if (button.getLabel().equals("*")) {
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("key pressed: *");
                        }
                    });
                } else if (button.getLabel().equals("#")) {
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("key pressed: #");
                        }
                    });
                } else {
                    button.addActionListener(kpListener);
                }
            }
        }
    }

    class KeyPadListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().getClass() == Button.class) {
                Button button = (Button) e.getSource();
                int num = Integer.parseInt(button.getLabel());
                System.out.println("key pressed: " + num);
            }
        }
    }
}
