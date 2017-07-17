import javax.swing.*;

public class Hand{

	private int total, inHand;
	private boolean ace = false;
	private boolean change = false;
	private Card [] hand;
//constructors
	public Hand(Card one){
		hand = new Card[7];
		hand[0] = one;
		inHand = 1;
		this.setTotal();
	}

	public Hand(Card one, Card two){
		hand = new Card[7];
		if(one.getValue() == 11)
			ace = true;
		if(two.getValue() == 11)
			ace = true;
		hand[0] = one;
		hand[1] = two;
		inHand = 2;
		this.setTotal();
	}
//return total
	public int getTotal(){
		return total;
	}
//returns all card info
	public Card getAllCard(int a){
		return hand[a];
	}
//returns card's image
	public JLabel getCard(int a){
		return hand[a].getImage();
	}
//returns card value
	public int getCardValue(int a){
		return hand[a].getValue();
	}
//sets total value of hand
	public void setTotal(){
		total = 0;
		for(int a = 0; a < inHand; a++)
			total += hand[a].getValue();
	}
//add a card to hand
	public void hit(Card card){
		hand[inHand] = card;
		if(card.getValue() == 11)
			ace = true;
		inHand += 1;
		this.bigAce();
		this.setTotal();
	}
//checks to see if ace is in hand and if it should be 11 or 1
	public void bigAce(){
		if(total > 21 && ace == true && change == false){
			for(int a = 0; a < inHand; a++){
				if(hand[a].getValue() == 11 && !(hand[a].getValue() == 1)){
					hand[a].setAce(1);
					change = true;
				}
			}
		}	
	}

//resets all things back the way it should be
	public void reset(){
		ace = false;
		change = false;
		total = 0;
		inHand = 0;
		for(int a = 0; a < hand.length; a++){
			hand[a] = null;
		}
	}
}
