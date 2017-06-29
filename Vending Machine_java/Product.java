package P12_8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Product store the quantity of each product and restock if needed;
 * promote user to select option; get the name, quantity and price of the selected product.
 */
public class Product {
    private int quantity;
    private int priceCents;

    private int selection;
    private int[] productLeft = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};


    private static final int[] PINDEX = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final String[] PNAME = {"Peanut Butter Crackers", "Rice Krispy Treats","Slim Jims", "M&M Cookies", "Snikers", "Hershey Almond Bar","Twix", "Coke", "Fruit Punch", "Red Bull"};
    private static final int[] PPRICE = {50, 70, 60, 75, 100, 75, 125, 100, 175, 200};



    public Product(){

    }

    /**
     * restock the products, this number is VM customerized. default is 3 for each item
     */
    public void restock(){

        for (int i = 0; i < 10; i++){
            if (productLeft[i] < 3){
                productLeft[i] = 3;
            }
        }


    }

    /**
     * ask the user to select the option
     */
    public void select(){
        System.out.println("We have the following products:");
        String pselection = "";
        for (int i = 0; i < 10; i++){
            pselection += "(" + (i+1) + ") " + PNAME[i] + ": $" + PPRICE[i]/100.00 + " ";
            if (i == 4){
            pselection += "\n";
            }
        }

        System.out.println(pselection);
        System.out.print("Select Product (one integer between 1 to 10): ");


        while (true) {
            try {

                Scanner in = new Scanner(System.in);
                selection = in.nextInt() - 1;
                if (selection >= 0 && selection < 10) {

                    break;
                }
                //handle invalid input
                else{
                    System.out.print("Input a valid selection of Product (one integer between 1 to 10): ");
                }
            }
            //handle invalid input
            catch (InputMismatchException e) {
                System.out.print("Input a valid selection of Product (one integer between 1 to 10): ");
                continue;
            }
        }
        System.out.println();

    }


    /**
     *
     * @return the quantity of the product
     */
    public int getQuantity(){
        quantity = productLeft[selection];
        return quantity;
    }

    /**
     * remove one purchase
     */
    public void removePurchase(){
        productLeft[selection]--;

    }

    /**
     *
     * @return the selected product name
     */
    public String getProductName(){
        return PNAME[selection];
    }


    /**
     *
     * @return the price of the product
     */
    public int getPrice(){
        priceCents = PPRICE[selection];
        return priceCents;
    }

    /**
     *
     * @return the remaining number of each product
     */
    public String getRemaining(){
        String remaining = "";
        for (int i = 0; i < 10; i++){
            remaining += "(" + (i+1) + ") " + PNAME[i] + ":" + (int) Math.max(productLeft[i], 0) + " ";
        }
        return remaining;
    }


}
