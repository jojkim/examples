import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

//One is Clubs, Two is Spades, Three is Hearts, and Four is Diamonds
//Ace, King, Queen, Jacks, 10, 9, 8, 7, 6, 5, 4, 3, 2
//Goes in multiples of four
//Ace: 1-4, King: 5-8, etc.
public class Card{

	private int value, cardNumber;
	private String name;
	JLabel cardImage;
//constructor	
	public Card(int num){
		this.cardNumber = num;
		this.setValue(num);
		this.setName(num);
		this.setImage();
	}

	public int getCardNumber(){
		return this.cardNumber;
	}

	public int getValue(){
		return this.value;
	}

	public String getName(){
		return this.name;
	}

	public JLabel getImage(){
		return this.cardImage;
	}
//sets value of card
	public void setValue(int num){
		if(num <= 4)
			value = 11;
		else if(num > 4 && num <= 8)
			value = 10;
		else if(num > 8 && num <= 12)
			value = 10;
		else if(num > 12 && num <= 16)
			value = 10;
		else if(num > 16 && num <= 20)
			value = 10;
		else if(num > 20 && num <= 24)
			value = 9;
		else if(num > 24 && num <= 28)
			value = 8;
		else if(num > 28 && num <= 32)
			value = 7;
		else if(num > 32 && num <= 36)
			value = 6;
		else if(num > 36 && num <= 40)
			value = 5;
		else if(num > 40 && num <= 44)
			value = 4;
		else if(num > 44 && num <= 48)
			value = 3;
		else if(num > 48 && num <= 52)
			value = 2;
	}
//sets ace's value to one
	public void setAce(int num){
		if(num <= 4)
			value = 1;
	}
//sets name of card
	public void setName(int num){
		if(num == 1)
			this.name = "Ace of Clubs";
		else if(num == 2)
			this.name = "Ace of Spades";
		else if(num == 3)
			this.name = "Ace of Hearts";
		else if(num == 4)
			this.name = "Ace of Diamonds";
		else if(num == 5)
			this.name = "King of Clubs";
		else if(num == 6)
			this.name = "King of Spades";
		else if(num == 7)
			this.name = "King of Hearts";
		else if(num == 8)
			this.name = "King of Diamonds";
		else if(num == 9)
			this.name = "Queen of Clubs";
		else if(num == 10)
			this.name = "Queen of Spades";
		else if(num == 11)
			this.name = "Queen of Hearts";
		else if(num == 12)
			this.name = "Queen of Diamonds";
		else if(num == 13)
			this.name = "Jack of Clubs";
		else if(num == 14)
			this.name = "Jack of Spades";
		else if(num == 15)
			this.name = "Jack of Hearts";
		else if(num == 16)
			this.name = "Jack of Diamonds";
		else if(num == 17)
			this.name = "Ten of Clubs";
		else if(num == 18)
			this.name = "Ten of Spades";
		else if(num == 19)
			this.name = "Ten of Hearts";
		else if(num == 20)
			this.name = "Ten of Diamonds";
		else if(num == 21)
			this.name = "Nine of Clubs";
		else if(num == 22)
			this.name = "Nine of Spades";
		else if(num == 23)
			this.name = "Nine of Hearts";
		else if(num == 24)
			this.name = "Nine of Diamonds";
		else if(num == 25)
			this.name = "Eight of Clubs";
		else if(num == 26)
			this.name = "Eight of Spades";
		else if(num == 27)
			this.name = "Eight of Hearts";
		else if(num == 28)
			this.name = "Eight of Diamonds";
		else if(num == 29)
			this.name = "Seven of Clubs";
		else if(num == 30)
			this.name = "Seven of Spades";
		else if(num == 31)
			this.name = "Seven of Hearts";
		else if(num == 32)
			this.name = "Seven of Diamonds";
		else if(num == 33)
			this.name = "Six of Clubs";
		else if(num == 34)
			this.name = "Six of Spades";
		else if(num == 35)
			this.name = "Six of Hearts";
		else if(num == 36)
			this.name = "Six of Diamonds";
		else if(num == 37)
			this.name = "Five of Clubs";
		else if(num == 38)
			this.name = "Five of Spades";
		else if(num == 39)
			this.name = "Five of Hearts";
		else if(num == 40)
			this.name = "Five of Diamonds";
		else if(num == 41)
			this.name = "Four of Clubs";
		else if(num == 42)
			this.name = "Four of Spades";
		else if(num == 43)
			this.name = "Four of Hearts";
		else if(num == 44)
			this.name = "Four of Diamonds";
		else if(num == 45)
			this.name = "Three of Clubs";
		else if(num == 46)
			this.name = "Three of Spades";
		else if(num == 47)
			this.name = "Three of Hearts";
		else if(num == 48)
			this.name = "Three of Diamonds";
		else if(num == 49)
			this.name = "Two of Clubs";
		else if(num == 50)
			this.name = "Two of Spades";
		else if(num == 51)
			this.name = "Two of Hearts";
		else if(num == 52)
			this.name = "Two of Diamonds";
	}
//set card's image
	public void setImage(){
		try{
			cardImage = new JLabel(new ImageIcon(ImageIO.read(new File(this.getCardNumber()+".png"))));
		}
		catch(IOException i){};
	}
	
	public String toString(){
		return "Card Name: " + this.getName()  + "\nCard Value: " + this.getValue() + "\nCard Number: " + this.getCardNumber();
	}
}
