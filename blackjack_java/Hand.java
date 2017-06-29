package blackjack;

import java.util.ArrayList;

/**
 * Class Hand add 52 cards into an ArrayList<Card> and provides a method to get the ArrayList<Card>
 */
public class Hand {
    private ArrayList<Card> crdHands;

    public Hand(){
        crdHands = new ArrayList<Card>();
    }


    /**
     * method to add cards
     */
    public void addcards(){
        crdHands.add(new Card('9', Card.Suit.SPADES));
        crdHands.add(new Card('T', Card.Suit.SPADES));
        crdHands.add(new Card('J', Card.Suit.SPADES));
        crdHands.add(new Card('Q', Card.Suit.SPADES));
        crdHands.add(new Card('K', Card.Suit.SPADES));
        crdHands.add(new Card('A', Card.Suit.SPADES));
        crdHands.add(new Card('2', Card.Suit.SPADES));
        crdHands.add(new Card('3', Card.Suit.SPADES));
        crdHands.add(new Card('4', Card.Suit.SPADES));
        crdHands.add(new Card('5', Card.Suit.SPADES));
        crdHands.add(new Card('6', Card.Suit.SPADES));
        crdHands.add(new Card('7', Card.Suit.SPADES));
        crdHands.add(new Card('8', Card.Suit.SPADES));
        crdHands.add(new Card('9', Card.Suit.HEARTS));
        crdHands.add(new Card('T', Card.Suit.HEARTS));
        crdHands.add(new Card('J', Card.Suit.HEARTS));
        crdHands.add(new Card('Q', Card.Suit.HEARTS));
        crdHands.add(new Card('K', Card.Suit.HEARTS));
        crdHands.add(new Card('A', Card.Suit.HEARTS));
        crdHands.add(new Card('2', Card.Suit.HEARTS));
        crdHands.add(new Card('3', Card.Suit.HEARTS));
        crdHands.add(new Card('4', Card.Suit.HEARTS));
        crdHands.add(new Card('5', Card.Suit.HEARTS));
        crdHands.add(new Card('6', Card.Suit.HEARTS));
        crdHands.add(new Card('7', Card.Suit.HEARTS));
        crdHands.add(new Card('8', Card.Suit.HEARTS));
        crdHands.add(new Card('9', Card.Suit.DIAMONDS));
        crdHands.add(new Card('T', Card.Suit.DIAMONDS));
        crdHands.add(new Card('J', Card.Suit.DIAMONDS));
        crdHands.add(new Card('Q', Card.Suit.DIAMONDS));
        crdHands.add(new Card('K', Card.Suit.DIAMONDS));
        crdHands.add(new Card('A', Card.Suit.DIAMONDS));
        crdHands.add(new Card('2', Card.Suit.DIAMONDS));
        crdHands.add(new Card('3', Card.Suit.DIAMONDS));
        crdHands.add(new Card('4', Card.Suit.DIAMONDS));
        crdHands.add(new Card('5', Card.Suit.DIAMONDS));
        crdHands.add(new Card('6', Card.Suit.DIAMONDS));
        crdHands.add(new Card('7', Card.Suit.DIAMONDS));
        crdHands.add(new Card('8', Card.Suit.DIAMONDS));
        crdHands.add(new Card('9', Card.Suit.CLUBS));
        crdHands.add(new Card('T', Card.Suit.CLUBS));
        crdHands.add(new Card('J', Card.Suit.CLUBS));
        crdHands.add(new Card('Q', Card.Suit.CLUBS));
        crdHands.add(new Card('K', Card.Suit.CLUBS));
        crdHands.add(new Card('A', Card.Suit.CLUBS));
        crdHands.add(new Card('2', Card.Suit.CLUBS));
        crdHands.add(new Card('3', Card.Suit.CLUBS));
        crdHands.add(new Card('4', Card.Suit.CLUBS));
        crdHands.add(new Card('5', Card.Suit.CLUBS));
        crdHands.add(new Card('6', Card.Suit.CLUBS));
        crdHands.add(new Card('7', Card.Suit.CLUBS));
        crdHands.add(new Card('8', Card.Suit.CLUBS));
    }


    /**
     *
     * @return the whole 52 cards ArrayList
     */
    public ArrayList<Card> getCrdHands(){
        return crdHands;
    }

}
