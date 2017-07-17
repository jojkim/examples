//Class for Twenty-One
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class TwentyOne implements ActionListener{

	private boolean bot, win, done, gameEnd, playerBust, dealerBust, quit, spilt;
	private int onHand, offHand, pWin, dWin, tie, pBust, dBust, giveUp;
	private Stack board;
	private JPanel base, game, main, deck;
	private JButton human, deck1, deck2, deck3, deck4;
	private JButton deck5, deck6, deck7, deck8;
	private JButton hit, stand, split, give;
	private JLabel background1, background2, background3, cardDeck;
	private JLabel card1, card2, card3, card4, card5, card6, face, back1, back2, back3, back4, back5;
	private JLayeredPane bottomPane, topPane;
	private	CardLayout flip;
	private Shoe shoe;
	private Hand player, dealer, right;

	//For MainMenu's CardLayout
	public JPanel getGame(){
		return this.base;
	}

	//Twenty-One's constructor
	public TwentyOne(){
		
		//initializing variable that will not be use for a bit
		bot = false;
		win = false;
		done = false;
		gameEnd = false;
		playerBust = false;
		dealerBust = false;
		quit = false;
		spilt = false;
		board = new Stack();
		card1 = new JLabel();
		card2 = new JLabel();
		card3 = new JLabel();
		card4 = new JLabel();
		card5 = new JLabel();
		card6 = new JLabel();
		face = new  JLabel();
		flip = new CardLayout();
		shoe = new Shoe();

		//initializing main variables
		base = new JPanel(new CardLayout());
		game = new JPanel();
		main = new JPanel();
		deck = new JPanel();

		//setting backgrounds images
		try{
			background1 = new JLabel(new ImageIcon(ImageIO.read(new File("title.png"))));

			background2 = new JLabel(new ImageIcon(ImageIO.read(new File("deck.png"))));

			background3 = new JLabel(new ImageIcon(ImageIO.read(new File("felt.jpg"))));

			cardDeck =  new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));
			cardDeck.setBounds(465,252,71,96);

			back1 = new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));
			back2 = new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));
			back3 = new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));
			back4 = new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));
			back5 = new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));
		}

		catch(IOException i){}
		
		//this will be the player's hand
		bottomPane = new JLayeredPane();
		bottomPane.setBounds(0,425,1000,175);
		bottomPane.setBorder(BorderFactory.createLineBorder(Color.white));

		//this will be the computer's hand
		topPane = new JLayeredPane();
		topPane.setBounds(0,0,1000,175);
		topPane.setBorder(BorderFactory.createLineBorder(Color.white));
		
		//this is the start button. called human due to abandoned plans for a computer vs computer
		human = new JButton("Start Game");
		human.setBounds(250,300,500,80);
		human.setActionCommand("man");
		human.addActionListener(this);

		//Sets number of decks to be used for the game
		deck1 = new JButton("1");
		deck1.setBounds(300,165,100,75);
		deck1.setActionCommand("1");
		deck1.addActionListener(this);

		deck2 = new JButton("2");
		deck2.setBounds(420,165,100,75);
		deck2.setActionCommand("2");
		deck2.addActionListener(this);

		deck3 = new JButton("3");
		deck3.setBounds(540,165,100,75);
		deck3.setActionCommand("3");
		deck3.addActionListener(this);

		deck4 = new JButton("4");
		deck4.setBounds(660,165,100,75);
		deck4.setActionCommand("4");
		deck4.addActionListener(this);

		deck5 = new JButton("5");
		deck5.setBounds(300,260,100,75);
		deck5.setActionCommand("5");
		deck5.addActionListener(this);

		deck6 = new JButton("6");
		deck6.setBounds(420,260,100,75);
		deck6.setActionCommand("6");
		deck6.addActionListener(this);

		deck7 = new JButton("7");
		deck7.setBounds(540,260,100,75);
		deck7.setActionCommand("7");
		deck7.addActionListener(this);

		deck8 = new JButton("8");
		deck8.setBounds(660,260,100,75);
		deck8.setActionCommand("8");
		deck8.addActionListener(this);

		//the main four in-game buttons
		hit = new JButton("HIT");
		hit.setBounds(305,360,90,30);
		hit.setActionCommand("hit");
		hit.addActionListener(this);

		stand = new JButton("STAND");
		stand.setBounds(405,360,90,30);
		stand.setActionCommand("stand");
		stand.addActionListener(this);

		split = new JButton("SPLIT");
		split.setBounds(505,360,90,30);
		split.setActionCommand("split");
		split.addActionListener(this);

		give = new JButton("GIVE UP");
		give.setBounds(605,360,90,30);
		give.setActionCommand("give");
		give.addActionListener(this);

		//adding a background and a button to the first panel
		main.add(background1);
		background1.add(human);

		//adding a backgrounds and eight buttons to the second panel
		deck.add(background2);
		background2.add(deck1);
		background2.add(deck2);
		background2.add(deck3);
		background2.add(deck4);
		background2.add(deck5);
		background2.add(deck6);
		background2.add(deck7);
		background2.add(deck8);

		//adding a background, playing buttons, and both JLayeredPanes
		game.add(background3);
		background3.add(cardDeck);
		background3.add(hit);
		background3.add(stand);
		background3.add(split);
		background3.add(give);
		background3.add(bottomPane);
		background3.add(topPane);

		//adding panels to main panel
		base.add(main, "1");
		base.add(deck, "2");
		base.add(game, "3");
	}

	//performs actions based on input
	public void actionPerformed(ActionEvent e){

		flip = (CardLayout)(base.getLayout());

		//goes to deck selections
		if("man".equals(e.getActionCommand())){
			flip.show(base, "2");
		}
		
		//one deck for the game
		else if("1".equals(e.getActionCommand())){
			shoe.setDeckNum(1);
			this.start();
		}

		//two decks for the game
		else if("2".equals(e.getActionCommand())){
			shoe.setDeckNum(2);
			this.start();
		}
		
		//three decks for the game
		else if("3".equals(e.getActionCommand())){
			shoe.setDeckNum(3);
			this.start();
		}

		//four decks for the game
		else if("4".equals(e.getActionCommand())){
			shoe.setDeckNum(4);
			this.start();
		}

		//five decks for the game
		else if("5".equals(e.getActionCommand())){
			shoe.setDeckNum(5);
			this.start();
		}

		//six decks for the game
		else if("6".equals(e.getActionCommand())){
			shoe.setDeckNum(6);
			this.start();
		}
		
		//seven decks for the game
		else if("7".equals(e.getActionCommand())){
			shoe.setDeckNum(7);
			this.start();
		}

		//eight decks for the game
		else if("8".equals(e.getActionCommand())){
			shoe.setDeckNum(8);
			this.start();
		}

		//player clicks "hit"
		else if("hit".equals(e.getActionCommand())){
			player.hit(shoe.pop());
			player.setTotal();
			player.bigAce();
			player.setTotal();

			if(onHand == 2){
				card3 = player.getCard(onHand);
				onHand++;
				card3.setBounds(500,10,72,96);
				bottomPane.add(card3);
			}

			else if(onHand == 3){
				card4 = player.getCard(onHand);
				onHand++;
				card4.setBounds(550,10,72,96);
				bottomPane.add(card4);
			}

			else if(onHand == 4){
				card5 = player.getCard(onHand);
				onHand++;
				card5.setBounds(500,10,72,96);
				bottomPane.add(card5);
			}

			else if(onHand == 5){
				card5 = player.getCard(onHand);
				onHand++;
				card5.setBounds(500,10,72,96);
				bottomPane.add(card5);
			}
			
			if(player.getTotal() > 21){
				playerBust = true;
				this.end();
			}

		}

		//player hits "stand"
		else if("stand".equals(e.getActionCommand())){
			//this triggers the computer's turn
			if(gameEnd == false){
				this.bot();
			}

			//this ends the game
			else if(gameEnd == true)
				this.end();
		}

		//splits the hand
		else if("split".equals(e.getActionCommand())){
			JOptionPane.showMessageDialog(base, "We couldn't figure out how to do this. We apologize for our failure.");
		}

		//gives up the game
		else if("give".equals(e.getActionCommand())){
			quit = true;
			this.end();
		}
	}
/*
	public void split(int a){
		if(spilt == false){
			try{
				for(int b = 0; b < 7; b++){
					for(int c = 0; c < 7; c++){
						if(a%2 == 0 && (player.getCardValue(b) == player.getCardValue(c))){
							if(done == false){
								bottomPane.remove(card1);
								bottomPane.remove(card2);
								card1.setBounds(300,10,72,96);
								card2.setBounds(600,10,72,96);
								bottomPane.add(card1);
								bottomPane.add(card2);
								game.revalidate();
								game.repaint();
								right = new Hand(player.getAllCard(b));
								spilt = true;
							}
							else
								JOptionPane.showMessageDialog(base, "You cannot currently split.");
						}
					}
				}
			}
			catch(NullPointerException n){}
		}
		else
			JOptionPane.showMessageDialog(base, "You can only split once per game.");
	}
*/
	//resets all the various components and variables 
	public void reset(){
		flip.show(base, "1");
		bot = false;
		done = false;
		gameEnd = false;
		playerBust = false;
		dealerBust = false;
		quit = false;
		spilt = false;
		onHand = 0;
		offHand = 0;

		if(!(card1.equals(null)))
			bottomPane.remove(card1);
		if(!(card2.equals(null)))
			bottomPane.remove(card2);
		if(!(card3.equals(null)))
			bottomPane.remove(card3);
		if(!(card4.equals(null)))
			bottomPane.remove(card4);
		if(!(card5.equals(null)))
			bottomPane.remove(card5);
		if(!(card6.equals(null)))
			bottomPane.remove(card6);

		topPane.remove(face);
		topPane.remove(back1);
		topPane.remove(back2);
		topPane.remove(back3);
		topPane.remove(back4);
		topPane.remove(back5);

		try{
			back1 = new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));
			back2 = new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));
			back3 = new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));
			back4 = new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));
			back5 = new JLabel(new ImageIcon(ImageIO.read(new File("b1fv.png"))));

		}
		catch(IOException a){}	

		game.revalidate();
		game.repaint();

		for(int a = 0; 0 < shoe.size(); a++)
			shoe.pop();

		player.reset();
		dealer.reset();
	}

	//prepares a number of components for the start of the game.
	public void start(){
		shoe.makeDeck();
		shoe.shuffle();
		flip.show(base, "3");
		player = new Hand(shoe.pop(), shoe.pop());
		
		card1 = player.getCard(0);
		card2 = player.getCard(1);
		card1.setBounds(400,10,72,96);
		card2.setBounds(450,10,72,96);
		bottomPane.add(card1, new Integer(12));
		bottomPane.add(card2, new Integer(11));
		onHand = 2;
		
		dealer = new Hand(shoe.pop(), shoe.pop());
		face = dealer.getCard(0);
		face.setBounds(400,10,72,96);
		back1.setBounds(450,10,72,96);
		topPane.add(face, new Integer(12));
		topPane.add(back1, new Integer(11));
		offHand = 2;
	}

	//governs the computer's moves
	public void bot(){
		try{
			int count = 0;
			while(done == false){
				if(dealer.getTotal() < 17){
					dealer.hit(shoe.pop());
					dealer.setTotal();
					dealer.bigAce();
					dealer.setTotal();

					if(dealer.getTotal() > 21){
						dealerBust = true;
						done = true;
						this.end();
					}
				}
				else if(dealer.getTotal() >= 17){
					done = true;
					gameEnd = true;
					this.end();
				}
			}
		}
		catch(java.util.EmptyStackException d){}
	}
	
	public void history(){
		JOptionPane.showMessageDialog(base, "Player wins: " + pWin + "\nPlayer bust: " + pBust + "\nDealer wins: " +dWin
		 + "\nDealer bust: " + dBust + "\nSurrenders: " + giveUp + "\nTies: " + tie);
	}
	

	public void show(){
		try{
			topPane.remove(back1);
			back1 = dealer.getCard(1);
			back1.setBounds(450,10,72,96);
			topPane.add(back1);
			if(!(dealer.getCard(2).equals(null))){
				back2 = dealer.getCard(2);
				back2.setBounds(500,10,72,96);
				topPane.add(back2);
			}
			if(!(dealer.getCard(3).equals(null))){
				back3 = dealer.getCard(3);
				back3.setBounds(550,10,72,96);
				topPane.add(back3);
			}
			if(!(dealer.getCard(4).equals(null))){
				back4 = dealer.getCard(4);
				back4.setBounds(600,10,72,96);
				topPane.add(back4);
			}
			if(!(dealer.getCard(5).equals(null))){
				back5 = dealer.getCard(2);
				back5.setBounds(650,10,72,96);
				topPane.add(back5);
			}
	
			game.revalidate();
			game.repaint();
		}
		catch(NullPointerException n){}
	}

	//Checks the conditions to determine the winner.
	public void end(){
		this.show();
		if(playerBust == true){
			JOptionPane.showMessageDialog(base, "Player has busted!");
			pBust++;
			dWin++;
		}
		else if(dealerBust == true){
			JOptionPane.showMessageDialog(base, "Dealer has busted!");
			dBust++;
			pWin++;
		}
		else if(quit == true){
			JOptionPane.showMessageDialog(base, "You surrendered.");
			giveUp++;
			dWin++;
		}
		else if(player.getTotal() > dealer.getTotal()){
			JOptionPane.showMessageDialog(base, "Player wins with a hand worth " + player.getTotal() + " points!");
			pWin++;
		}
		else if(dealer.getTotal() > player.getTotal()){
			JOptionPane.showMessageDialog(base, "Dealer wins with a hand worth " + dealer.getTotal() + " points!");
			dWin++;
		}
		else if(dealer.getTotal() == player.getTotal()){
			JOptionPane.showMessageDialog(base, "Game is tied. Dealer wins.");
			tie++;
		dWin++;
		}
		this.reset();
	}
}
