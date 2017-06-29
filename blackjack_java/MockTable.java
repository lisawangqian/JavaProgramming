package blackjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The following is the rules of this BLACKJACK app.
 * The goal of blackjack is to beat the dealer's hand without going over 21.
 * 1) Face cards are worth 10. 1- 9 cards are worth 1-9 accordingly. Aces are worth 1 or 11, whichever makes a better hand.
 * 2) A player starts with 'FirstTwoCards", one of the dealer's cards is hidden until the end.
 * 3) To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.
 * The following is my score rules in this app.
 * 4) If you go over 21 you bust, the dealer wins if he does not bust and have a tie if he bust as well.
 * 5) If you are dealt 21 from the firstTwoCards (but dealer does not), you got a blackjack. Blackjack means you win double amount.
 * 6) If you and dealer both gets a blackjack, you have a tie
 * 7) you win when you have score less equal than 21 and bigger than dealer or dealer bust but you does not.
 * 8) If you and dealer have the same total <= 21, no win, no lose.
 * 9) Dealer will hit until reaches soft total 17 or higher.
 * 10) You can start a new round by "StartNewDeal", each round bet is $50.
 */
public class MockTable {
    private JPanel mPanel;
    private JButton mButtonDeal;
    private JPanel mPanelPlayer;
    private JPanel mPanelCtrl;
    private JPanel mPanelLeft;
    private JPanel mPanelRight;
    private JButton mButtonHit;
    private JButton mButtonStand;
    private JPanel mPanelDealer;
    private JPanel pLabPanel;
    private JPanel playerPanel;
    private JPanel dLabPanel;
    private JPanel dealerPanel;
    private JLabel dLabel;
    private JLabel pLabel;
    private JLabel moneyLabel;
    private JPanel majorPanel;
    private JTextField mMoneyLeft;
    private JTextField outcomeText;
    private JButton twoCardButton;
    private Deck deck;
    private Card currentCard;
    private int dealerScore = 0;
    private int playerScore = 0;


    private  int nXPos;

    private boolean playerTurn = false;
    private boolean dealTurn = false;
    private boolean dealerTurn = false;
    private boolean twocards = true;
    private int totalMoney = 1000;

    private int playerHasA = 0;
    private int dealerHasA = 0;

    private ArrayList<Card> playerCollection;
    private ArrayList<Card> dealerCollection;


    public static void main(String[] args) {

        //set the JFrame
        JFrame frame = new JFrame("MockTable");
        frame.setContentPane(new MockTable().mPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700, 600);
    }


    //pass in the graphics context of the jPanel you want to draw on
    protected void drawCards(Graphics g) {

        //use this counter to position the cards horizontally

        BufferedImage bufferedImage;

        bufferedImage = SoundImageUtils.genBuffImage("/src/blackjack/cardimages/" + currentCard + ".png");
            //nc = x-pos, 60 = y-pos
        g.drawImage(bufferedImage, nXPos, 60, null);
        nXPos = nXPos +25;


    }

    protected void drawBBCards(Graphics g) {

        //use this counter to position the cards horizontally

        BufferedImage bufferedImage;

        bufferedImage = SoundImageUtils.genBuffImage("/src/blackjack/cardimages/BB.png");
        //nc = x-pos, 60 = y-pos
        g.drawImage(bufferedImage, nXPos, 60, null);



    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        // custom-create components initialization
        mButtonDeal = new JButton();
        mButtonStand = new JButton();
        mButtonHit = new JButton();
        twoCardButton = new JButton();
        mMoneyLeft = new JTextField();
        mMoneyLeft.setText("$ " + totalMoney);
        outcomeText = new JTextField();
        outcomeText.setText("Welcome to blackjack!");




        //eventlisteners
        twoCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // twocards controls if this button is active. if it is, once clicked, call distribute()
                if (twocards) {
                    distribute();

                }


            }
        });



        mButtonDeal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dealTurn controls if this button is active. if it is, once clicked, call deal()
                if (dealTurn) {
                    deal();}


            }
        });

        mButtonHit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // playerTurn controls if this button is active. if it is, once clicked, call hit()
                if (playerTurn) {
                    hit();}


            }
        });

        mButtonStand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // playerTurn controls if this button is active. if it is, once clicked, call stand()
                if (playerTurn) {
                    stand();
                }


            }
        });

        initialization();

    }



    public void initialization() {

        //initialization
        nXPos = 100;
        dealerScore = 0;
        playerScore = 0;

        dealerTurn = false;
        playerTurn = false;
        dealTurn = false;
        twocards = true;

        //shuffle a hand of 52 Cards
        deck = new Deck();
        deck.shuffle();


        playerHasA = 0;
        dealerHasA = 0;
        playerCollection = new ArrayList<>();
        dealerCollection = new ArrayList<>();


    }

    /**
     * method to distribute firstTwoCards to the player
     * also distribute firstTwoCards to dealer with the second one hidden
      */
    public void distribute(){
        initialization();
        //firstTwoCards to the player
        currentCard = deck.dealCard();
        playerScore += convertValue(currentCard);
        playerCollection.add(currentCard);
        drawCards(playerPanel.getGraphics());
        //record the 'A's get
        if (currentCard.getFace() =='A'){
            playerHasA++;
        }
        currentCard = deck.dealCard();
        playerScore += convertValue(currentCard);
        playerCollection.add(currentCard);
        drawCards(playerPanel.getGraphics());
        if (currentCard.getFace() =='A'){
            playerHasA++;
        }

        //first card to the dealer
        nXPos = 100;
        currentCard = deck.dealCard();
        dealerCollection.add(currentCard);
        drawCards(dealerPanel.getGraphics());
        dealerScore += convertValue(currentCard);
        //record the 'A's get
        if (currentCard.getFace() =='A'){
            dealerHasA++;
        }

        //hidden second card for the dealer
        currentCard = deck.dealCard();
        drawBBCards(dealerPanel.getGraphics());

        //after distributing two cards to player/dealer, deactive this button
        twocards = false;
        playerTurn = true;
        nXPos = 150;

    }

    /**
     * the method to start a new deal
     */
    public void deal(){
        //clear the panel for new round
        playerPanel.repaint();
        dealerPanel.repaint();

        outcomeText.setText("Welcome to blackjack!");

        //active/deactive the JButtons accordingly (only FirsttwoCards button active at this time point)
        dealerTurn = false;
        twocards = true;
        playerTurn = false;
        dealTurn = false;

    }

    public void hit(){
        //this time point, only playturn is true(hit and stand active)
        //once "hit", deal the player a Card
        dealTurn = false;
        currentCard = deck.dealCard();

        //update the total earned score
        playerScore += convertValue(currentCard);
        //collect the Cards dealt
        playerCollection.add(currentCard);

        //record the As get
        if (currentCard.getFace() =='A'){
            playerHasA++;
        }
        //decide A is soft or hard in the total score computing
        while (playerScore > 21 && playerHasA > 0){
            playerScore -= 10;
            playerHasA--;
        }
        //add the card image onto the the playerPanel
        drawCards(playerPanel.getGraphics());




    }

    public void stand(){
        //if player click 'stand', it is not the player's turn anymore, it is the dealer(computer)'s turn
        playerTurn = false;
        dealTurn = false;
        dealerTurn = true;
        // call dealer to drawn Cards
        dealerFinish();

    }

    public void dealerFinish(){

        nXPos = 125;

        //draw Cards until the dealer get a soft 17 or higher
        while (dealerScore < 17) {
            currentCard = deck.dealCard();
            //collect the Cards dealt
            dealerCollection.add(currentCard);
            //add the card image onto the the dealerPanel
            drawCards(dealerPanel.getGraphics());
            //update the total earned score
            dealerScore += convertValue(currentCard);

            //record the As get
            if (currentCard.getFace() == 'A') {
                dealerHasA++;
            }
            //decide A is soft or hard in the total score computing
            while (dealerScore > 21 && dealerHasA > 0) {
                dealerScore -= 10;
                dealerHasA--;
            }

        }
        //after dealer drawing Cards, get the result of losing and winning
        //active deal button to let player startNewDeal
        getResult();
        dealTurn = true;



    }

    /**
     *
     * @param card the Card the player/dealer gets
     * @return the value(score) of that Card
     */
    public int convertValue(Card card){
        char letterValue = card.getFace();

        if (letterValue == 'A') {return 11;}
        else if (letterValue == '1') {return 1;}
        else if (letterValue == '2') {return 2;}
        else if (letterValue == '3') {return 3;}
        else if (letterValue == '4') {return 4;}
        else if (letterValue == '5') {return 5;}
        else if (letterValue == '6') {return 6;}
        else if (letterValue == '7') {return 7;}
        else if (letterValue == '8') {return 8;}
        else if (letterValue == '9') {return 9;}
        else {return 10;}


    }

    /**
     * method to compute the moneyLeft
     * If you go over 21 you bust, the dealer wins if he does not bust and have a tie if he bust as well.
     * If you are dealt 21 from the firstTwoCards (but dealer does not), you got a blackjack. Blackjack means you win double amount.
     * If dealer blackjack but you do not, you lose double amount.
     * If you and dealer both gets a blackjack, you have a tie.
     * you win when you have score less equal than 21 and bigger than dealer or dealer bust but you does not.
     * If you and dealer have the same total <= 21, no win, no lose.
     */
    public void getResult() {

        int playerCard = playerCollection.size();
        int dealerCard = dealerCollection.size();


        if (playerScore == 21 && playerCard == 2 ){
            if (dealerScore == 21 && dealerCard == 2){
                outcomeText.setText("Both blackjack! No win no lose!");
            }
            else{
                totalMoney += 100;
                outcomeText.setText("You blackjack! You win $100!");
            }
        }
        else if (dealerScore == 21 && dealerCard == 2){
            totalMoney -= 100;
            outcomeText.setText("Dealer blackjack! You lose $100!");
        }

        else if ((playerScore <= 21 && playerScore > dealerScore) | (playerScore <= 21 && dealerScore > 21)){
            totalMoney += 50;
            outcomeText.setText("You win $50!");
        }
        else if ((playerScore <= 21 && playerScore == dealerScore)) {
            outcomeText.setText("Tie, no win no lose!");

        }
        else if (playerScore > 21 && dealerScore > 21){
            outcomeText.setText("Both bust! no win no lose!");

        }
        else {
            outcomeText.setText("You lose $50!");
            totalMoney -= 50;

        }
        //set the moneyLeft JTextField
        mMoneyLeft.setText("$ " + totalMoney);

    }
}
