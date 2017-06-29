package P12_6;

import java.util.Scanner;

/**
 * CONSOLE APPLICATION
 * Write a program that teaches arithmetic to a young child. The program tests addition
 * and subtraction. In level 1, it tests only addition of numbers less than 10 whose sum
 * is less than 10. In level 2, it tests addition of arbitrary one-digit numbers. In level 3, it
 * tests subtraction of one-digit numbers with a nonnegative difference.
 * Generate random problems and get the player’s input. The player gets up to two
 * tries per problem. Advance from one level to the next when the player has achieved a
 * score of five points.
 */
public class Driver {
    public static void main(String[] args) {
        //ask user to input the name
        System.out.print("Please enter your name: ");
        Scanner in = new Scanner(System.in);
        String childName = in.nextLine();

        //generate a ChildTest object with the entered name
        ChildTest child = new ChildTest(childName);
        //call child method goTest()
        child.goTest();

    }
}
