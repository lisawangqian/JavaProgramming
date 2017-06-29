package P12_8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Coin class collect the coins a user inserts, compute the total value and store the money collected (nonreturnable).
 */
public class Coin {
    private int totalCents;
    private int penny;
    private int nickel;
    private int dime;
    private int quarter;
    private int dollar;
    private int[] cCollection = {0, 0, 0, 0, 0};
    private int moneyGetCents;
    private ArrayList<Integer> paymentList = new ArrayList<>();

    private static final int[] VALUES = {1, 5, 10, 25, 100};


    public Coin(){
        totalCents = 0;
        penny = 0;
        nickel = 0;
        dime = 0;
        quarter = 0;
        dollar = 0;
    }

    /**
     * method to collect inserted coins
     */
    public void insertCoins(){
        try {

            System.out.print("Please enter the number of DOLLAR coins you want to inserted (non-negative INTEGER): ");
            Scanner in = new Scanner(System.in);
            dollar = in.nextInt();
            cCollection[0] = dollar;

            System.out.print("Please enter the number of QUARTER coins you want to inserted (non-negative INTEGER): ");
            in = new Scanner(System.in);
            quarter = in.nextInt();
            cCollection[1] = quarter;

            System.out.print("Please enter the number of DIME coins you want to inserted (non-negative INTEGER): ");
            in = new Scanner(System.in);
            dime = in.nextInt();
            cCollection[2] = dime;


            System.out.print("Please enter the number of NICKEL coins you want to inserted (non-negative INTEGER): ");
            in = new Scanner(System.in);
            nickel = in.nextInt();
            cCollection[3] = nickel;

            System.out.print("Please enter the number of PENNY coins you want to inserted (non-negative INTEGER): ");
            in = new Scanner(System.in);
            penny = in.nextInt();
            cCollection[4] = penny;
        }
        //handle invalid input
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input");
        }


    }

    /**
     *
     * @return total value of inserted coins
     */
    public int getValue(){
        totalCents = penny * VALUES[0] + nickel * VALUES[1] + dime * VALUES[2] + quarter * VALUES[3] + dollar * VALUES[4];
        return totalCents;

    }

    /**
     *
     * @return the numbers of different coins inserted in an array.
     */
    public int[] getCCollection(){
        return cCollection;
    }

    /**
     * if product is dispensed, the coins value is collected
     */
    public void addEarn(){
        paymentList.add(totalCents);
    }



    /**
     *
     * @return  money removed
     */
    public int operator(){
        moneyGetCents = 0;
        for (int money: paymentList){
            moneyGetCents += money;
        }

        return moneyGetCents;

    }



}

