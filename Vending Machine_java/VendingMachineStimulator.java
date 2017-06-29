package P12_8;

import java.util.Scanner;

/**
 * CONSOLE APPLICATION
 * Write a program that simulates a vending machine. Products can be purchased by
 * inserting coins with a value at least equal to the cost of the product. A user selects a
 * product from a list of available products, adds coins, and either gets the product or
 * gets the coins returned. The coins are returned if insufficient money was supplied
 * or if the product is sold out. The machine does not give change if too much money
 * was added. Products can be restocked and money removed by an operator. Follow
 * the design process that was described in this chapter. Your solution should include a
 * class VendingMachine that is not coupled with the Scanner or PrintStream classes.
 */
public class VendingMachineStimulator {
    public static void main(String[] args) {



        //construct Product, Coin and VendingMachine objects
        Product product = new Product();
        Coin coins = new Coin();
        VendingMachine buy = new VendingMachine(coins, product);

        while (true){
            //promote user to select product and insert coins by calling select() and insertCoins() methods
            product.select();
            coins.insertCoins();
            buy = new VendingMachine(coins, product);

            //Vending machine decision according product availability and coins sufficiency.
            System.out.println(buy.setState());

            //promote the user to decide if wants to continue to purchase.
            System.out.println("\nDo you want to make another purchase (Y/N): ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().toUpperCase();
            if (input.compareTo("Y") != 0){
                break;
            }
        }

        //VendingMachine operator remove the money earned
        System.out.println("_________________________________________________");
        System.out.println("VendingMachine collects $" + coins.operator()/100.00 + " today!");
        System.out.println("VendingMachine has the following numbers of products left:");
        System.out.println(product.getRemaining());
        //VendingMachine get a restock
        product.restock();
        System.out.println("VendingMachine restocks the products!");
        System.out.println("VendingMachine has the following numbers of products now:");
        System.out.println(product.getRemaining());
        System.out.println("_________________________________________________");






    }
}
