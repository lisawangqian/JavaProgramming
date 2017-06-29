package Pig;

import javax.swing.*;

/**
 * Created by lisa on 10/30/15.
 */
public class Pig {
    public static void main(String[] args) {
        //generate the JFrame object and initialize it as an object of the subclass PigDiceGame
        JFrame frame = new PigDiceGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //set the size and make it visible
        frame.setSize(700, 400);
        frame.setVisible(true);

    }
}
