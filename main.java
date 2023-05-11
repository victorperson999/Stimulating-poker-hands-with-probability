/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalVersionClassesLabof2023;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Victor
 */
public class main {
    
    private static int numRoyalFlush = 0;// public integers to count amount of hand types to be accessed in the countHandType method
    private static int numStraightFlush = 0;
    private static int numFourOfAKind = 0;
    private static int numFullHouse = 0;
    private static int numFlush = 0;
    private static int numStraight = 0;
    private static int numThreeOfAKind = 0;
    private static int numTwoPair = 0;
    private static int numOnePair = 0;
    private static int numHighCard = 0;
    
    public static long Scan;// global variable used not only in main
    
    public static void main(String[] args) {
         
        System.out.println("Welcome to the poker program");// introduce program
        System.out.println("You will be able to draw 5 cards, stimulating a poker game");
        System.out.println("-------------------------");

        boolean correctHand = false;//IMPORTANT

            do{// this do loop for the amouunt of hands created we might have to change the contructor to receive amount of poker hands desired.
                // this is wrong so far
                try{    
                    Scanner scan = new Scanner(System.in);
                    System.out.println("please input the number of hands you want to simulate: ");
                    Scan = scan.nextLong();

                    if (Scan<=0){
                        System.out.println("You either entered zero amount of hands or a negative intger, you cant have either of those amount of hands :)");
                        correctHand=false;
                    }
                    else if (Scan>0){// else all longs are valid greater than 0

                        for (int k = 0; k<Scan; k++){// interate through Scan desired on amount of hands user desires to be drawn

                        Card[] Deck = new Card[52];// generate deck
                        int count = 0;
                        for (String suit : Card.ranks) {
                            for (String value : Card.suits) {
                                Deck[count] = new Card(value, suit);
                                count++;
                            }
                        }
                    // shuffle the deck
                    Collections.shuffle(Arrays.asList(Deck));// use java collections so shuffle deck

                        Hand hand = new Hand(5);// draw new hand plz

                        System.out.println("-------------");
                        System.out.println("Your hand:");
                        System.out.println("-------------");
                        for (int j = 0; j < 5; j++) {// print the hands
                            Card newCard = Deck[j];
                            hand.addCard(newCard);
                        }

                        hand.showHand();// show the hand

                        Hand.HandType handType = hand.getHandType();// get the hand type by calling Hand

                        switch (handType){// update the hand type count using switch cases
                            case ROYAL_FLUSH:
                                numRoyalFlush++;
                                break;
                            case STRAIGHT_FLUSH:
                                numStraightFlush++;
                                break;
                            case FOUR_OF_A_KIND:
                                numFourOfAKind++;
                                break;
                            case FULL_HOUSE:
                                numFullHouse++;
                                break;
                            case FLUSH:
                                numFlush++;
                                break;
                            case STRAIGHT:
                                numStraight++;
                                break;
                            case THREE_OF_A_KIND:
                                numThreeOfAKind++;
                                break;
                            case TWO_PAIR:
                                numTwoPair++;
                                break;
                            case ONE_PAIR:
                                numOnePair++;
                                break;
                            case HIGH_CARD:
                                numHighCard++;
                                break;
                            default:
                                System.out.println("Invalid hand type");
                                break;
                        }// end of switch
                      }// end of for
                        correctHand=true;// set to true because break out of do loop

                    }// end of else if 

                }catch (InputMismatchException e){
                    System.out.println("This is not a valid input, please try again");
                    correctHand = true;
                }// end of catch

                System.out.println("-----------------------");

            }while(correctHand==false);

            printHandTypeCounts();// call handtype counts to display results

     }// end of main method
     
         
    public static void printHandTypeCounts() {
          System.out.println("Final amount of hands drawn: " + Scan);
          System.out.println("-------------------------");

          System.out.println("Total Royal Flushes drawn: " + (int)numRoyalFlush + " Hand(s)" + "(" + ((float)numRoyalFlush/Scan * 100.0) + "%" + ")");
          System.out.println("Expected result: 0.000154% of occurences |"+ " Percentage error: " + (Math.abs(((double)(numRoyalFlush/Scan) * 100.0)-0.000154)/0.000154 * 100.0) + "%");
          System.out.println();
          System.out.println("Straight Flushes drawn: " + (int)numStraightFlush + " Hand(s)" + "(" + ((float)numStraightFlush/Scan * 100.0) + "%" + ")");
          System.out.println("Expected result: 0.00139% of occurences |"+ " Percentage error: " + (Math.abs(((double)numStraightFlush/Scan * 100.0)-0.00139)/0.00139 * 100.0)+ "%");
          System.out.println();
          System.out.println("Four of a kinds drawn: " + (int)numFourOfAKind + " Hand(s)" + "(" + ((float)numFourOfAKind/Scan * 100.0) + "%" + ")");
          System.out.println("Expected result: 0.024% of occurences |"+ " Percentage error: " + (Math.abs(((double)numFourOfAKind/Scan * 100.0)-0.024)/0.024 * 100.0)+ "%");
          System.out.println();
          System.out.println("Full houses drawn: " + (int)numFullHouse + " Hand(s)" + "(" + ((float)numFullHouse/Scan * 100.0) + "%" + ")");
          System.out.println("Expected result: 0.144% of occurences |"+ " Percentage error: " + (Math.abs(((double)numFullHouse/Scan * 100.0)-0.144)/0.144 * 100.0)+ "%");
          System.out.println();
          System.out.println("Flushes drawn: " + (int)numFlush + " Hand(s)" + "(" + ((float)numFlush/Scan * 100.0) + "%" + ")");
          System.out.println("Expected result: 0.197% of occurences |"+ " Percentage error: " + (Math.abs(((double)numFlush/Scan * 100.0)-0.197)/0.197 * 100.0)+ "%");
          System.out.println();
          System.out.println("Straights drawn: " + (int)numStraight + " Hand(s)" + "(" + ((float)numStraight/Scan * 100.0) + "%" + ")");
          System.out.println("Expected result: 0.392% of occurences |"+ " Percentage error: " + (Math.abs(((double)numStraight/Scan * 100.0)-0.392)/0.392 * 100.0)+ "%");
          System.out.println();
          System.out.println("Three of a kinds drawn: " + (int)numThreeOfAKind + " Hand(s)" + "(" + ((float)numThreeOfAKind/Scan * 100.0) + "%" + ")");
          System.out.println("Expected result: 2.11% of occurences |"+ " Percentage error: " + (Math.abs(((double)numThreeOfAKind/Scan * 100.0)-2.11)/2.11 * 100.0)+ "%");
          System.out.println();
          System.out.println("Two pairs drawn: " + (int)numTwoPair + " Hand(s)" + "(" + ((float)numTwoPair/Scan * 100.0) + "%" + ")");
          System.out.println("Expected result: 4.75% of occurences |"+ " Percentage error: " + (Math.abs(((double)numTwoPair/Scan * 100.0)-4.75)/4.75 * 100.0)+ "%");
          System.out.println();
          System.out.println("One pairs drawn: " + (int)numOnePair + " Hand(s)" + "(" + ((float)numOnePair/Scan * 100.0) + "%" + ")");
          System.out.println("Expected result: 42.3% of occurences |"+ " Percentage error: " + (Math.abs(((double)numOnePair/Scan * 100.0)-42.3)/42.3 * 100.0)+ "%");
          System.out.println();
          System.out.println("High cards drawn: " + (int)numHighCard + " Hand(s)" + "(" + ((float)numHighCard/Scan * 100.0) + "%" + ")");
          System.out.println("Expected result: 50.1% of occurences | "+ " Percentage error: " + (Math.abs(((double)numHighCard/Scan * 100.0)-42.3)/42.3 * 100.0)+ "%");
          
    }
     
}// end of main

