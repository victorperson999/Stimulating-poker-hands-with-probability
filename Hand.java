
package FinalVersionClassesLabof2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class Hand {// make sure to ask mr jf if collections.sort is necessary in every handcheck method (currently is implemented)

      public static enum HandType {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH,
        ROYAL_FLUSH
}
    
   private final ArrayList<Card> cards;

    public Hand(int numCards) {
        this.cards = new ArrayList<>();
    }
    
    public void addCard(Card card) {
        this.cards.add(card);
    }
    
    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
 
   @Override
    public String toString() {
        return cards.toString();
    }
    
    public boolean hasRoyalFlush(){// this is definitely wrong remember to edit method? make sure with mr JF
        List<Card> sortedCards = new ArrayList<>(cards);
        Collections.sort(sortedCards);// instance where the compareTo method is used in card class

        // Check if the cards are a royal flush
        return sortedCards.get(0).rank.equals("ACE") &&
               sortedCards.get(1).rank.equals("10") &&
               sortedCards.get(2).rank.equals("JACK") &&
               sortedCards.get(3).rank.equals("QUEEN") &&
               sortedCards.get(4).rank.equals("KING") &&
               sortedCards.get(0).suit.equals(sortedCards.get(1).suit) &&
               sortedCards.get(1).suit.equals(sortedCards.get(2).suit) &&
               sortedCards.get(2).suit.equals(sortedCards.get(3).suit) &&
               sortedCards.get(3).suit.equals(sortedCards.get(4).suit);
        }
    
    public boolean hasStraightFlush(){// checks attributes of both a flush and straight, not sure, just make sure to check it over!
        return hasFlush() && hasStraight();
    }
    
    public boolean hasFourOfAKind(){
        for (int i = 0; i < cards.size() - 3; i++) {
        if (cards.get(i).getRank().equals(cards.get(i + 1).getRank())) {
                if (cards.get(i + 1).getRank().equals(cards.get(i + 2).getRank())) {
                    if (cards.get(i + 2).getRank().equals(cards.get(i + 3).getRank())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean hasFullHouse(){// seems plausible
        Collections.sort(cards);
        int numPairs = 0;
        int numTrips = 0;
        for (int i = 0; i < cards.size() - 1; i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getRank().equals(cards.get(j).getRank())) {
                    numPairs++;
                }
            }
        }
        for (int i = 0; i < cards.size() - 2; i++) {
            if (cards.get(i).getRank().equals(cards.get(i + 1).getRank())) {
                if (cards.get(i + 1).getRank().equals(cards.get(i + 2).getRank())) {
                    numTrips++;
                }
            }
        }
        return numPairs == 2 && numTrips == 1;
    }
    
    public boolean hasFlush(){// maybe correct
        Collections.sort(cards);
        String suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean hasStraight(){
        Collections.sort(cards);// sort cards in ascending order // instance where the compareTo method is used in card class
        int rankIndex = Arrays.asList(Card.ranks).indexOf(cards.get(0).rank);// Get the index of the first card's rank in the ranks array
        for (int i = 1; i < cards.size(); i++) {// iterate through the remaining cards in hand
            int nextRankIndex = Arrays.asList(Card.ranks).indexOf(cards.get(i).rank);// Get the index of the next card's rank in the ranks array
            if (nextRankIndex != rankIndex + 1) {// Check if the next card's rank is exactly one more than the current card's rank, otherwise...
                return false;// then not straight
            }
            rankIndex = nextRankIndex;//current rank index to the next rank index
        }
     return true;// if all the cards are in sequence, then return true.
    }
    
    public boolean hasThreeOfAKind(){// is three of a kind cards .size-2?
        Collections.sort(cards);
        for (int i = 0; i < cards.size() - 2; i++) {
            if (cards.get(i).getRank().equals(cards.get(i + 1).getRank())) {
                if (cards.get(i + 1).getRank().equals(cards.get(i + 2).getRank())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean hasTwoPair(){
        Collections.sort(cards);
        int numPairs = 0;
        for (int i = 0; i < cards.size() - 1; i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getRank().equals(cards.get(j).getRank())) {
                    numPairs++;
                }
            }
        }
            return numPairs == 2;
    }
    
    public boolean hasOnePair(){
        Collections.sort(cards);
        for (int i = 0; i < cards.size() - 1; i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(j).getRank().equals(cards.get(i).getRank())) {
                    return true;
                }
            }
        }
        return false;
    }
        
        
    public HandType getHandType(){
        if (hasRoyalFlush()){
            return HandType.ROYAL_FLUSH;
        }
        // check for straight flush
        if (hasStraightFlush()) {
            return HandType.STRAIGHT_FLUSH;
        }
        // check for four of a kind
        if (hasFourOfAKind()) {
            return HandType.FOUR_OF_A_KIND;
        }
        // check for full house
        if (hasFullHouse()) {
            return HandType.FULL_HOUSE;
        }
        // check for flush
        if (hasFlush()) {
            return HandType.FLUSH;
        }
        // check for straight
        if (hasStraight()) {
            return HandType.STRAIGHT;
        }
        // check for three of a kind
        if (hasThreeOfAKind()) {
            return HandType.THREE_OF_A_KIND;
        }
        // check for two pairs
        if (hasTwoPair()) {
            return HandType.TWO_PAIR;
        }
        // check for one pair
        if (hasOnePair()) {
            return HandType.ONE_PAIR;
        }
        // otherwise, it's a high card hand
        return HandType.HIGH_CARD;
    }
    
    public void showHand() {// show hand of cards
        for (Card card : cards) {
            card.showCard();
        }
    }
}// end of Hand
        
