package P12_8;

import java.util.ArrayList;

/**
 * VendingMachine decides on whether dispense or return coins depends on Coin and Product;
 * Also ask operator to remove money (added by Coin).
 */
public class VendingMachine {


    private String result = "";
    private Product mProduct = new Product();
    private Coin mCoin = new Coin();
    private int quantity;
    private int payment;
    private int price;
    private String pname = "";
    private int[] collection = new int[5];

    /**
     *
     * @param coins   the money the customer insert
     * @param product the product the customer select
     */
    public VendingMachine(Coin coins, Product product){
        mProduct = product;
        mCoin = coins;
        getState();

    }

    /**
     * get the state of how much money inserted and what product is selected
     * get the quantity of product
     */
    public void getState(){
        quantity = mProduct.getQuantity();
        payment = mCoin.getValue();
        price = mProduct.getPrice();
        collection = mCoin.getCCollection();

    }

    /**
     * @return  vendingmachine decision
     * set the state of VendingMachine to dispense, if product is available and money is sufficient
     * set the state of VendingMachine to return Coin if if product is unavailable and money is insufficient
     */
    public String setState(){
        if (quantity > 0 && payment >= price){
            mCoin.addEarn();
            return dispenseProduct();
        }
        else {
            return returnCoin();
        }

    }

    /**
     *
     * @return  dispensed product
     * ask Product to remove one purchase.
     */

    public String dispenseProduct(){
        mProduct.removePurchase();
        result = "\nPlease collect your purchased product: " + mProduct.getProductName() + ".";
        return result;

    }

    /**
     *
     * @return returned coin
     */
    public String returnCoin(){
        if (quantity <=0){
            result = "\nSorry, your selected product is not available, please come tomorrow. Please take your coins back: " + mCoin.getValue() + " cents.";
        }
        else{
            result = "\nSorry, your payment is insufficient. Please take your coins back: " + mCoin.getValue() + " cents.";
        }
        return result;

    }



}
