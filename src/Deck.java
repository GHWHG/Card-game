import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> currentDeck = new ArrayList<Card>();

    public void makeNewDeck(){

        for (int suite=1;suite<=4;suite++){
            for (int rank=1;rank<=13;rank++){
                if (suite==1){
                    Card newCard = new Card("clubs",rank);
                    currentDeck.add(newCard);
                }
                else if(suite==2){
                    Card newCard = new Card("diamonds",rank);
                    currentDeck.add(newCard);
                }
                else if(suite==3){
                    Card newCard = new Card("hearts",rank);
                    currentDeck.add(newCard);
                }
                else{
                    Card newCard = new Card("spades",rank);
                    currentDeck.add(newCard);
                }
            }
        }
    }

    public void printDeck(){
        for (Card currentCard:currentDeck){
            System.out.println(currentCard);
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(currentDeck);
    }

    public Card dealCard(){
        Card currentCard = currentDeck.get(0);
        currentDeck.remove(0);
        return currentCard;
    }

    public Boolean isEmpty(){
        return currentDeck.size()==0;
    }

}
