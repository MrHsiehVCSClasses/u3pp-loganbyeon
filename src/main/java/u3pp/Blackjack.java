package u3pp;

import java.util.Scanner;

/*
 * Constructor to instantitate any instance variable, especially deck.
 */
public class Blackjack {
    static Deck deck;
    static Card[] userHand;
    static Card[] dealerHand;

    public Blackjack(){
        deck = new Deck();
        deck.shuffle();

        userHand = new Card[21];
        dealerHand = new Card[21];

        userHand[deck.numDealt] = deck.deal();
        userHand[deck.numDealt] = deck.deal();

        dealerHand[deck.numDealt] = deck.deal();
        dealerHand[deck.numDealt] = deck.deal();
    }   
    
    /*
    * Helper method that takes array of Cards and returns the amount of points the hand is worth.
    */
    public static int calcPoints(Card[] hand){
        int points = 0;
        for (Card c : hand) {
            if (c.getValue().equals("King") || c.getValue().equals("Queen") || c.getValue().equals("Jack")) {
                points += 10;
            } else if (c.getValue().equals("Ace")) {
                points += 11;
            } else {
                points += Integer.parseInt(c.getValue()); 
            }
        }
        return points;
    }
    
    /**
     * Constructor that determines result of user's gameplay.
	 * @return a String with the result of user's gameplay.
	 */
    public static String determineResult(Card[] userHand, Card[] dealerHand){
        int userPoint = calcPoints(userHand);
        int dealerPoint = calcPoints(dealerHand);

        if (isBust(userHand) == true){
            return "Result: User Loses";
        }
        else if(isBust(dealerHand) == true){
            return "Result: User Wins";
        }

        if(userPoint > dealerPoint){
            return "Result: User Wins"; 
        }
        else if(userPoint == dealerPoint){
            return "Result: User Pushes";
        }
        return "Result: User Loses";
    }

    /**
     * Constructor that determines whether the hand is a bust or not.
	 * @return true if the hand is a Bust.
	 */
    public static boolean isBust(Card[] hand){
        int totalPoints = calcPoints(hand); 
        if(totalPoints > 21){
            return true;
        }
        return false;
    }

    /**
     * Constructor that determines whether the hand is a Blackjack or not.
	 * @return true if the hand is a Blackjack.
	 */
    public static boolean isBlackjack(Card[] hand){
        int totalPoints = calcPoints(hand);
        if (totalPoints == 21 && hand.length == 2){
            return true;
        } 
        return false;
    }

    /**
     * Constructor that determines whether the dealer should keep hitting or not.
	 * @return true if the dealer should keep hitting.
	 */
    public static boolean shouldDealerKeepHitting(Card[] hand){
        int totalPoints = calcPoints(hand);
        if (totalPoints <= 16){
            return true;
        }
        return false;
    }

    /**
     * Constructor for User experience. 
     * Playing Blackjack!
	 */
    public static void play(Scanner scanner){
        System.out.print("Welcome to BlackJack! What is your name? ");
        String userName = scanner.next();
        System.out.println();
        System.out.println("Hello " + userName + "! I am Gambletron 5000! Let's play some cards.");
        
        while(true){
            // Checks if user won
            if (isBlackjack(userHand)) { 
                System.out.println("Congrats " + userName + " you got a BlackJack!");
                continue;
            }
            // Checks if dealer won
            if (isBlackjack(dealerHand)){
                continue;
            }
            
            // User's turn:
            while (isBust(userHand) == false){
                // User's hand
                System.out.print("Your Hand: " );
                for (Card c: userHand) {
                    System.out.print(c.toString() + " ");
                }
                System.out.println();

                // Dealer's hand
                System.out.print("Dealer's Hand: " );
                for(Card c: dealerHand){
                    System.out.print(c.toString() + " ");
                }
                System.out.println();

                // Hit or Stay?
                System.out.print("Would you like to (H)it or (S)tay: ");
                String userMove = scanner.next().substring(0, 1).toLowerCase();
                System.out.println();

                while(!(userMove.equals("h")) || !(userMove.equals("s"))){
                    System.out.println("Invalid input, try again.");
                    System.out.print("Would you like to (H)it or (S)tay: ");
                    userMove = scanner.next().substring(0, 1).toLowerCase();
                    System.out.println();
                }

                if(userMove.equals("h")){
                    deck.deal();
                    if(isBust(userHand) == true){ 
                        continue;
                    }
                }
                else {
                    // if user selected "no" to hitting
                    break;
                }

                System.out.print("Would you like to play again? (Y)es/(N)o: ");
                String userInput = scanner.next().substring(0, 1).toLowerCase();
                System.out.println();
                
                while(!(userInput.equals("y")) || !(userInput.equals("n"))){
                    System.out.println("Invalid input, try again.");
                    System.out.print("Would you like to play again? (Y)es/(N)o: ");
                    userInput = scanner.next().substring(0, 1).toLowerCase();
                    System.out.println();
                }
            }

            if(isBust(userHand) == true){ 
                System.out.println(userName + ", I'm so sorry you busted!");
                continue;
            }
           
            while(shouldDealerKeepHitting(dealerHand)){
                deck.deal();
            } 
            if(isBust(dealerHand) == true){ 
                System.out.println("Dealer has busted.");
                continue;
            }
            System.out.println(determineResult(userHand, dealerHand));
            continue;
        }
    }
}