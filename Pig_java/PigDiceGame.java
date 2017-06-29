package Pig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The user will play against the computer.
 On a turn, a player rolls the die repeatedly until either:

 > A 1 is rolled
 > The player chooses to hold (stop rolling)

 If a 1 is rolled, that player's turn ends and no points are earned.
 If the player chooses to hold, all of the points rolled during that turn are added to his or her score.

 Scoring Examples

 Example 1: User rolls a 3 and decides to continue. He then chooses to roll seven more times (6, 6, 6, 4, 5, 6, 1).
 Because he rolled a 1, the user's turn ends and he earns 0 points.

 Example 2: The computer rolls a random number of times before holding. For example, the computer rolls 5 times.
 (6, 3, 4, 2, 6) and then holds. The computer accumulates 21 points (6+3+4+2+6=21).

 Game play is returned to the user, who must roll as least once, and so on.


 Game End

 When a player reaches a total of 100 or more points, the game ends and that player is the winner.
 */


public class PigDiceGame extends JFrame{
    //declare all needed JPanel, JLabel and JTextField, JTextArea, JButton for making UI
    private JPanel framePanel;

    private JPanel pPanel;
    private JPanel oPanel;

    private JPanel psLabelP;
    private JPanel pLPanel;
    private JPanel pRPanel;
    private JPanel pMPanel;
    private JPanel csLabelP;
    private JPanel cMPanel;
    private JPanel rMPanel;


    private JPanel cPanel;
    private JPanel rPanel;
    private JLabel pLabel;

    private JLabel psLabel;
    private JLabel cLabel;
    private JLabel csLabel;
    private JLabel rLabel;
    private JLabel rtLabel;
    private JLabel ctLabel;
    private JLabel ptLabel;

    private JButton rollButton;
    private JButton holdButton;
    private JButton resButton;


    private JTextArea rollText;
    private JTextArea comText;
    private JTextArea resText;

    private JTextField pScoreField;
    private JTextField comField;

    private JScrollPane scrollPaneRoll;
    private JScrollPane scrollPaneRoll2;
    private JScrollPane scrollPaneRoll3;

    //declare the variables to track the scores of player and computer, and who wins
    private int pScore;
    private int cScore ;
    private String result;
    private int playOneRound;
    //declare a boolean variable to track whose turn it is to make sure the button was inactive when it it not their turn
    private boolean playerturn = true;
    //declare a boolean variable to track if hold button is active for the player since he needs to roll at least once each round
    private boolean holdactive= false;





    public PigDiceGame() {
        //initialization of tracking variables
        pScore = 0;
        cScore = 0;
        result ="NOT KNOWN YET";
        playerturn = true;
        holdactive= false;
        playOneRound = 0;

        //initialization of UI components
        framePanel = new JPanel();

        pPanel = new JPanel();
        oPanel = new JPanel();

        cPanel = new JPanel();
        rPanel = new JPanel();


        pLPanel = new JPanel();
        pRPanel = new JPanel();
        pMPanel = new JPanel();
        psLabelP = new JPanel();
        csLabelP = new JPanel();
        cMPanel = new JPanel();
        rMPanel = new JPanel();

        pLabel = new JLabel("     PLAYER    ");
        psLabel = new JLabel("SCORE");
        cLabel = new JLabel("     COMPUTER  ");
        csLabel = new JLabel("SCORE");
        rLabel = new JLabel ("   RESULT  ");

        ptLabel = new JLabel("               PLAYER\'S ROLLING NUMBERS");
        ctLabel = new JLabel("       COMPUTER\'S ROLLING NUMBERS");
        rtLabel = new JLabel("                            RESULT");

        rollButton = new JButton("ROLL");
        holdButton=new JButton("HOLD");
        resButton = new JButton("RESTART");

        pScoreField = new JTextField("NOT KNOWN YET");
        comField = new JTextField("NOT KNOW YET");
        pScoreField.setEditable(false);
        comField.setEditable(false);

        rollText = new JTextArea(10, 10);
        comText = new JTextArea(10, 10);
        resText = new JTextArea(10, 10);
        rollText.setEditable(false);
        comText.setEditable(false);
        resText.setEditable(false);

        scrollPaneRoll = new JScrollPane(rollText);
        scrollPaneRoll2 = new JScrollPane(comText);
        scrollPaneRoll3 = new JScrollPane(resText);

        //method to generate behaviors after clicking buttons and recording the process of games running
        createUIComponents();





    }



    private void createUIComponents() {

        //generate ActionListener of rollButton
        rollButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //checkpoint to see if it is the player's turn (if this button should be activated)
                if (playerturn & pScore < 100) {
                    int toss = 1 + (int) (Math.random() * 6);
                    rollText.append("" + toss + "  ");
                    if (toss == 1) {
                        playOneRound = 0;
                        rollText.append("; ");
                        //if get "1", the turn is not the player's anymore,
                        playerturn = false;
                        //it is computer's turn
                        computerRun();
                    } else {
                        playOneRound += toss;
                        //activate hold button, so can hold if the player wants
                        holdactive = true;

                    }


                }



            }

        });

        //generate ActionListener of holdButton
        holdButton = new JButton("HOLD");
        holdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //checkpoint of if this button is active for player
                if (playerturn && holdactive) {
                    //if clicked, it is computer's turn
                    //need to collect the score of this round of rolling for the player
                    //then reset the playOneRound to 0 for next round collecting
                    rollText.append("; ");
                    pScore += playOneRound;
                    playOneRound = 0;
                    playerturn = false;
                    //if player gets less than 100, it is the computer's turn
                    //otherwise, should get the result(player wins, but want it call the method getResult to get it)
                    if (pScore < 100) {
                        computerRun();
                    }
                    else{
                        playerturn = false;
                        pScoreField.setText("" + pScore);
                        getResult();
                    }
                }

            }
        });


        //generate ActionListener of resButton
        resButton = new JButton("RESTART");
        resButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //if clicked, reset the display windows and variables for tracking scores and whoseturn in a new round
                rollText.append("\n");
                rollText.append("--------------NEW GAME---------------");
                rollText.append("\n");
                comText.append("\n");
                comText.append("----------NEW GAME----------");
                comText.append("\n");

                pScore = 0;
                cScore = 0;
                playerturn = true;
                holdactive= false;
                playOneRound = 0;
                result ="NOT KNOWN YET";
                pScoreField.setText("NOT KNOWN YET");
                comField.setText("NOT KNOW YET");







            }
        });




        //add all the UI Components to the frame
        //according to designer pattern with multiple subPanels to organize the appearence of components
        psLabelP.setLayout(new BorderLayout());
        psLabelP.add(psLabel, BorderLayout.WEST);
        psLabelP.add(pScoreField, BorderLayout.CENTER);

        pLPanel.setLayout(new GridLayout(4,1));
        pLPanel.add(rollButton);
        pLPanel.add(holdButton);
        pLPanel.add(psLabelP);


        pRPanel.setLayout(new BorderLayout());
        pRPanel.add(ptLabel, BorderLayout.NORTH);
        pRPanel.add(scrollPaneRoll, BorderLayout.CENTER);



        pMPanel.setLayout(new GridLayout(1,2));
        pMPanel.add(pLPanel);
        pMPanel.add(pRPanel);

        pPanel.setLayout(new BorderLayout());
        pPanel.add(pMPanel, BorderLayout.CENTER);
        pPanel.add(pLabel, BorderLayout.WEST);



        csLabelP.setLayout(new BorderLayout());
        csLabelP.add(csLabel, BorderLayout.WEST);
        csLabelP.add(comField, BorderLayout.CENTER);

        cMPanel.setLayout(new BorderLayout());
        cMPanel.add(ctLabel, BorderLayout.NORTH);
        cMPanel.add(scrollPaneRoll2, BorderLayout.CENTER);
        cMPanel.add(csLabelP, BorderLayout.SOUTH);

        cPanel.setLayout(new BorderLayout());
        cPanel.add(cLabel, BorderLayout.WEST);
        cPanel.add(cMPanel, BorderLayout.CENTER);



        rMPanel.setLayout(new BorderLayout());
        rMPanel.add(rtLabel, BorderLayout.NORTH);
        rMPanel.add(scrollPaneRoll3, BorderLayout.CENTER);
        rMPanel.add(resButton, BorderLayout.SOUTH);


        rPanel.setLayout(new BorderLayout());
        rPanel.add(rLabel, BorderLayout.WEST);
        rPanel.add(rMPanel, BorderLayout.CENTER);


        oPanel.setLayout(new GridLayout(1,2));
        oPanel.add(cPanel);
        oPanel.add(rPanel);


        framePanel.setLayout(new GridLayout(2,1));
        framePanel.add(pPanel);
        framePanel.add(oPanel);


        add(framePanel);
    }

    //define the method of computer running
    public void computerRun() {
        //set player score
        pScoreField.setText("" + pScore);

        //local variable to check if 1 is tossed.
        boolean iftoss = true;
        int thisRound = 0;
        int n = 0;
        //Let it toss for a random number
        int ranNum = 2 + (int) (Math.random() * 4);
        //This is a designer defined setting
        while (cScore <100 && iftoss && n < ranNum) {
            int toss = 1 + (int) (Math.random() * 6);
            n++;
            comText.append("" + toss + "  ");
            if (toss == 1) {
                thisRound = 0;
                iftoss = false;
            } else {
                thisRound += toss;
            }
        }
        //make sure when it is the player's turn, he needs to roll at least once
        holdactive = false;
        comText.append("; ");
        cScore += thisRound;
        //set computer score
        comField.setText("" + cScore);

        //if computer gets less than 100, it is the player's turn
        //otherwise, should get the result(computer wins, but want it call the method getResult to get it)
        if (cScore < 100){
            playerturn = true;
        }
        else{
            //call the method to display the result
            getResult();
        }


    }

    // compare their scores and display the result to the scrollrolling area
    public void getResult(){
        if (pScore > cScore){
            result = "GOOD JOB, YOU WIN! \n";
        }
        else{
            result = "SORRY, YOU LOSE!\n";
        }
        resText.append(result);
    }




}
