package FinalVersionClassesLabof2023; //part of the same package

import java.util.Arrays;

public class Card implements Comparable<Card>{
    
    public final static String [] suits = {"Clubs", "Spades", "Diamonds", "Hearts"};
    public final static String [] ranks = {"ACE","2","3","4","5","6","7","8","9","10","JACK","QUEEN","KING"};
    
    public String suit;
    public String rank;

    public Card(String newsuit, String newrank) {
        this.suit = newsuit;
        this.rank = newrank;
    }
    
    public Card(String newSuit){
        randomCard(newSuit);
    }  
    
    public void randomCard(String newSuit){
        int randomValue = (int)(Math.random() * ranks.length);
        this.suit = newSuit;
        this.rank = ranks[randomValue];
    }
    
    public String getSuit(){
        return suit;
    }
    public String getRank(){
        return rank;
    }
     public void showCard(){
        System.out.println(this.rank + " of " + this.suit);
    }
    
     @Override
    public String toString() {
        return rank + " of " + suit;
    }
    
    @Override
    public int compareTo(Card otherCard) { //the compareTo method is added to allow the Card objects to be sorted in a specific order. 
        // Get the index of the rank of this card and the specified card
        int thisRank = Arrays.asList(ranks).indexOf(this.rank);// // Get the index of the rank of this card in the list of all possible ranks
        int otherRank = Arrays.asList(ranks).indexOf(otherCard.rank);// Get the index of the rank of the other card in the list of all possible ranks
        return Integer.compare(thisRank, otherRank);
        //returns a negative integer if thisrank < otherrank, and zero if equal 
        //positive if thisrank > otherrank
    }
    
    
    
}// end cf Card

