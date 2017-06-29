package blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class Deck shuffle the hand of cards; deal a Card to the player/dealer; update the hand by removing the ones dealt.
 */
public class Deck {

    private ArrayList<Card> shuffledHand;

    public Deck(){
          Hand hand = new Hand();
          hand.addcards();
          shuffledHand = hand.getCrdHands();
    }

    /**
     * method to shuffle the hand of Cards
     */

    public void shuffle(){
        Collections.shuffle(shuffledHand);

    }

    /**
     *
     * @return the Card that is dealt
     * update the hand by removing the dealt Card
     */
    public Card dealCard(){
        Card getaCard = shuffledHand.get(0);
        shuffledHand.remove(0);
        return getaCard;

    }


}
