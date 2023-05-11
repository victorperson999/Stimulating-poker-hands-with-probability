/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalVersionClassesLabof2023;
import java.util.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Victor
 */

public class deck{

   private final ArrayList<Card> cards;

    public deck() {
        
        this.cards = new ArrayList<>();
        
        for (String suit : Card.suits){
            for (String rank : Card.ranks){
                this.cards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(this.cards);
    }
    
    public void shuffle(){
        Collections.shuffle(this.cards, new Random());
    }

    public ArrayList<Card> getDeck() {
        return cards;
    }
  
}// end of deck
    
    
    










    
    
    
    
    

