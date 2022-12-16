package u3pp;

import java.util.Random;

public class Deck {
    Card[] deck =  new Card[52];
    int numDealt = 0;

    /*
    * Default constructor that creates 52 unique cards.
    */
    public Deck() {
        for(int i = 0; i < Card.SUITS.length; i++){
            for(int j = 0; j < Card.VALUES.length; j++){
                deck[numDealt] = new Card(Card.SUITS[i], Card.VALUES[j]);
                numDealt++;
            }
        }
    }
    
    /**
	 * Constructs that returns how many cards haven't been dealt with in deck.
	 * @return the number of cards haven't been dealt with in deck.
	 */
    public int numLeft(){
        return 52 - numDealt;
    }

    /**
	 * Constructor that takes a card off the "top" of the deck and returns it.
	 * @return the card off the "top" of the deck.
	 */
    public Card deal() {
        Card c = deck[numDealt];
        numDealt++;
        // System.out.println(c.toString());
        return c;
    }

    /**
	 * Constructor that restores the deck to "full" or 52 cards and randomizes the order of the cards to be dealt.
	 */
    public void shuffle() {
        numDealt = 0;
        Random rand = new Random();

        for (int i = 0; i < deck.length; i++) {
            int randIndex = rand.nextInt(deck.length);
            Card temp = deck[randIndex];
            deck[randIndex] = deck[i];
            deck[i] = temp;
        }
    }
}