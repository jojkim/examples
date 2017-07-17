import java.util.*;

public class Shoe{

	private Stack<Card> deck;
	private int numOfDecks;

	public Shoe(){
		this.deck = new Stack<Card>();
	}

	public Stack<Card> getDeck(){
		return this.deck;
	}

	public int getDeckNum(){
		return this.numOfDecks;
	}

	public void setDeckNum(int num){
		this.numOfDecks = num;
	}
	public void makeDeck(){
		for(int num = 1; num < 53; num++){
			for(int ber = 0; ber < this.numOfDecks; ber++){
				Card card = new Card(num);
				this.deck.push(card);
			}
		}
	}

	public void shuffle(){
		Collections.shuffle(this.deck);
	}

	public Card pop(){
		return this.deck.pop();
	}

	public int size(){
		return this.deck.size();
	}

	public boolean empty(){
		return this.deck.empty();
	}
}
