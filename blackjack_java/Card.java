package blackjack;

/**
 * provide by Gerber.
 * Class Card set and get the SUIT and FACE of a card object
 */
public class Card {

    //public static enum
    public static enum Suit {
        CLUBS('C'), DIAMONDS('D'), HEARTS('H'), SPADES('S');
        private char value;

        //you MUST make this constructor private!
        private Suit(char value) {
            this.value = value;
        }

        public char getValue(){
            return value;
        }

    }

    //instance members
    private char mFace;
    private Suit mSuit;

    //constructor
    public Card(char face, Suit suit) {
        mFace = face;
        mSuit = suit;
    }


    @Override
    public String toString() {
        return String.valueOf(mFace) + mSuit.getValue();
    }


    //getters and setters
    public char getFace() {
        return mFace;
    }

    public void setFace(char face) {
        mFace = face;
    }

    public Suit getSuit() {
        return mSuit;
    }

    public void setSuit(Suit suit) {
        mSuit = suit;
    }
}
