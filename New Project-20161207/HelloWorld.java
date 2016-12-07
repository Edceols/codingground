/***************************************************************
 * Tester program to play Blackjack
 * @author Eddie Chan
 * November 29 2016
 ****************************************************************/
import java.util.Scanner;
public class HelloWorld {
    public static void main (String[] args) {
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);
        boolean playerStay = false, dealerStay = false, end = false, playAgain = true;
        String answer = "null";

        // put Card objects in random order
        // -----------------------------------------------------------
        // print all 52 Cards in the order in which they are dealt
        // -----------------------------------------------------------
        /*for (int i = 0; i < 13; i++) {
        // print method used for formatting output
        // print string (%) in a space of 20 characters (-20s)
        System.out.printf("%-20s%-20s%-20s%-20s\n",
        myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
        myDeckOfCards.dealCard(), myDeckOfCards.dealCard());
        }
         */
        System.out.println("***************************************************************");
        System.out.println("*********Press enter to play Mr. Hodgins in BlackJack!*********");
        System.out.print(  "***************************************************************");
        while (playAgain == true) {
            playerStay = false;
            dealerStay = false;
            end = false;
            DeckOfCards myDeckOfCards = new DeckOfCards();
            myDeckOfCards.shuffle();
            scan.nextLine();
            System.out.println("\f**************************BlackJack!***************************");
            System.out.println("\nMr. Hodgins has drawn two cards. One of them is a " + myDeckOfCards.dealDealerCard() + ".");
            myDeckOfCards.dealDealerCard();
            System.out.println("You drew a " + myDeckOfCards.dealPlayerCard() + " and a " + myDeckOfCards.dealPlayerCard() + ".");
            System.out.println("\nYour total score is " +myDeckOfCards.getPlayerValue() + ".");

            while (myDeckOfCards.getPlayerValue() < 21 && myDeckOfCards.getDealerValue() < 21 && end == false) {
                if (playerStay == false) {
                    System.out.print("Would you like to \"hit\" or \"stay\"?: ");
                    answer = scan.nextLine();

                    while (!answer.equals("hit") && !answer.equals("h") && !answer.equals("stay") && !answer.equals("s") && playerStay ==false) {
                        System.out.print ("Please input a valid option. Would you like to \"hit\" or \"stay\" ");
                        answer = scan.nextLine();     
                    }
                }
                if (myDeckOfCards.getDealerValue() < 17) {
                    System.out.println("\nMr. Hodgins drew a card");
                    myDeckOfCards.dealDealerCard();
                }
                else {
                    System.out.println("\nMr. Hodgins stays");
                    dealerStay = true;
                }

                if (playerStay == false) {
                    if (answer.equals("hit") || answer.equals("h")) {
                        System.out.println("\nYou drew a " + myDeckOfCards.dealPlayerCard());
                        System.out.println("Your total score is " + myDeckOfCards.getPlayerValue());
                    }
                    else {
                        System.out.println("\nYou stay");
                        playerStay = true;
                    }
                }

                if (dealerStay == true && playerStay == true) 
                    end = true;
            }

            if (myDeckOfCards.getPlayerValue() == 21)
                System.out.println("\nYou got a blackjack! You win!");
            else if (myDeckOfCards.getPlayerValue() > 21 && myDeckOfCards.getDealerValue() > 21)
                System.out.println("You bust. The dealer also busts with a score of " + myDeckOfCards.getDealerValue() + " It's a tie.");
            else if (myDeckOfCards.getPlayerValue() > 21)
                System.out.println("\nYou bust. The dealer wins with a score of " + myDeckOfCards.getDealerValue() + ".");
            else if (myDeckOfCards.getDealerValue() == 21)
                System.out.println("\nThe dealer got a blackjack. You lose.");
            else if (myDeckOfCards.getDealerValue() > 21)
                System.out.println("\nThe dealer busts with a score of " + myDeckOfCards.getDealerValue()  + ". You win!");
            else if (myDeckOfCards.getPlayerValue() > myDeckOfCards.getDealerValue())
                System.out.println("\nThe dealer has a score " + myDeckOfCards.getDealerValue()+ "\nYour score is higher. You win!");
            else if (myDeckOfCards.getPlayerValue() < myDeckOfCards.getDealerValue())
                System.out.println("\nThe dealer has a score " + myDeckOfCards.getDealerValue() + "\nYour score is lower. You lose");
            else if (myDeckOfCards.getPlayerValue() == myDeckOfCards.getDealerValue())
                System.out.println("\nThe dealer has a score " + myDeckOfCards.getDealerValue() + " It's a tie");

            System.out.print("\nWould you like to play again? (y/n) ");
            answer = scan.next();
            while (!answer.equals("no") && !answer.equals("yes") && !answer.equals("n") && !answer.equals("y")) {
                System.out.println ("Please input a valid option (y/n): ");
                answer = scan.nextLine();
            }
            if (answer.equals("no") || answer.equals("n")) 
                playAgain = false;
            else
                System.out.print("\f");
        }
        System.out.println("\fThanks for playing BlackJack!");
    }
}