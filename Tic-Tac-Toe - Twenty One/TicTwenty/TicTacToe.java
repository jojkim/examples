import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class TicTacToe{
//Setting up Gui
//
	JPanel frame = new JPanel();
	public static JButton[][] spaces = new JButton[3][3];
	int gameMoves = 0;
	boolean win = false;
	ImageIcon disabledIcon;
	String XorO;
	JButton reset = new JButton("Reset");
	JButton undo = new JButton("Undo");
	JPanel main = new JPanel(new BorderLayout());        
	JPanel menu = new JPanel(new BorderLayout());
	JPanel game = new JPanel(new GridLayout(3,3)); 
	JLabel xorolabel = new JLabel("Player 1's Turn");
	int p1wins;
	int p2wins;
	JLabel xwins = new JLabel("Player 1 Wins: " + p1wins);
	JLabel owins = new JLabel("Player 2 Wins: " + p2wins);
	Stack <Integer>  moves = new Stack <Integer>();
//Boolean to check win status
	boolean test1 = false; boolean test2 = false; boolean test3 = false; boolean test4 = false;
	boolean test5 = false; boolean test6 = false; boolean test7 = false; boolean test8 = false; boolean test9 = false;

	boolean trial1 = false; boolean trial2 = false; boolean trial3 = false; boolean trial4 = false; 
	boolean trial5 = false; boolean trial6 = false; boolean trial7 = false; boolean trial8 = false; boolean trial9 = false;

	public JPanel getGame(){
		return frame;
	}

	public TicTacToe() {
		frame.setSize(500,500);
	}
//Initializing the method
	public void initialize() {

		frame.add(main);

		main.setPreferredSize(new Dimension(475,475));
		menu.setPreferredSize(new Dimension(450,100));                     
		game.setPreferredSize(new Dimension(450,350));

		main.add(menu, BorderLayout.NORTH);
		main.add(game, BorderLayout.CENTER);

		menu.add(reset, BorderLayout.EAST);
		menu.add(undo, BorderLayout.WEST);

		main.add(xorolabel, BorderLayout.SOUTH);
		menu.add(xwins, BorderLayout.NORTH);
		menu.add(owins, BorderLayout.SOUTH);
		reset.addActionListener(new resetAction());
		undo.addActionListener(new undo());
//Loop to get the buttons onto the game panel
		for(int a = 0; a < 3; a++)                      
		{
			for(int b = 0; b < 3; b++) 
			{
				spaces[a][b] = new JButton();               
				spaces[a][b].setText("");
				spaces[a][b].setVisible(true);

				game.add(spaces[a][b]);
				spaces[a][b].addActionListener(new clicked());
				frame.revalidate();
				frame.repaint();
			}
		}
	}
//Resets back to original frame and a new game
	class resetAction implements ActionListener {
		public void actionPerformed(ActionEvent r) {
			if(r.getSource() == reset)
			{
				for(int a = 0; a < 3; a++)                      
				{
					for(int b = 0; b < 3; b++) 
					{         
						spaces[a][b].setIcon(null);
						spaces[a][b].setEnabled(true);

						frame.revalidate();
						frame.repaint(); 
						gameMoves = 0;
						win = false;

						test1 = false; test2 = false; test3 = false; test4 = false;
						test5 = false; test6 = false; test7 = false; test8 = false; test9 = false;

						trial1 = false; trial2 = false; trial3 = false; trial4 = false;
						trial5 = false; trial6 = false; trial7 = false; trial8 = false; trial9 = false;
						while(moves.empty() != false)
							moves.pop();
					}
				}
			}
		}
	}
	class undo implements ActionListener {
		public void actionPerformed(ActionEvent r) {
			if(r.getSource() == undo){
				if(moves.peek() == 1){
					spaces[0][0].setIcon(null);
					spaces[0][0].setEnabled(true);
					gameMoves--;
					moves.pop();
				}
				else if(moves.peek() == 2){
					spaces[0][1].setIcon(null);
					spaces[0][1].setEnabled(true);
					gameMoves--;
					moves.pop();
				}
				else if(moves.peek() == 3){
					spaces[0][2].setIcon(null);
					spaces[0][2].setEnabled(true);
					gameMoves--;
					moves.pop();
				}
				else if(moves.peek() == 4){
					spaces[1][0].setIcon(null);
					spaces[1][0].setEnabled(true);
					gameMoves--;
					moves.pop();
				}
				else if(moves.peek() == 5){
					spaces[1][1].setIcon(null);
					spaces[1][1].setEnabled(true);
					gameMoves--;
					moves.pop();
				}
				else if(moves.peek() == 6){
					spaces[1][2].setIcon(null);
					spaces[1][2].setEnabled(true);
					gameMoves--;
					moves.pop();
				}
				else if(moves.peek() == 7){
					spaces[2][0].setIcon(null);
					spaces[2][0].setEnabled(true);
					gameMoves--;
					moves.pop();
				}
				else if(moves.peek() == 8){
					spaces[2][1].setIcon(null);
					spaces[2][1].setEnabled(true);
					gameMoves--;
					moves.pop();
				}
				else if(moves.peek() == 9){
					spaces[2][2].setIcon(null);
					spaces[2][2].setEnabled(true);
					gameMoves--;
					moves.pop();
				}
			}
		}
	}
//ActionListener for when a button is clicked plus checking to see who won
	class clicked implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			gameMoves++;

			if (gameMoves == 1 || gameMoves == 3 || gameMoves == 5 || gameMoves == 7 || gameMoves == 9)
			{
				disabledIcon = new ImageIcon("uga.jpg");
				XorO = "Player 1";
				xorolabel.setText("Player 2's Turn");
			}
			else if (gameMoves == 2 || gameMoves == 4 || gameMoves == 6 || gameMoves == 8 || gameMoves == 10) 
			{
				disabledIcon = new ImageIcon("florida.gif");
				XorO = "Player 2";
				xorolabel.setText("Player 1's Turn");
			}

			if (e.getSource() == spaces[0][0]) {
				if(XorO.equals("Player 1")) {
					test1 = true;
					spaces[0][0].setIcon(disabledIcon);
					spaces[0][0].setDisabledIcon(disabledIcon);
					spaces[0][0].setEnabled(false);
					moves.push(1);}
				else {
					trial1 = true;
					spaces[0][0].setIcon(disabledIcon);
					spaces[0][0].setDisabledIcon(disabledIcon);
					spaces[0][0].setEnabled(false);
					moves.push(1);}
			}
			else if (e.getSource() == spaces[0][1]) {
				if(XorO.equals("Player 1")){
					test2 = true;
					spaces[0][1].setIcon(disabledIcon);
					spaces[0][1].setDisabledIcon(disabledIcon);
					spaces[0][1].setEnabled(false);
					moves.push(2);}
				else {
					trial2 = true;
					spaces[0][1].setIcon(disabledIcon);
					spaces[0][1].setDisabledIcon(disabledIcon);
					spaces[0][1].setEnabled(false);
					moves.push(2);}
					
			}
			else if (e.getSource() == spaces[0][2]) {
				if(XorO.equals("Player 1")){
					test3 = true;
					spaces[0][2].setIcon(disabledIcon);
					spaces[0][2].setDisabledIcon(disabledIcon);
					spaces[0][2].setEnabled(false);
					moves.push(3);}
				else {
					trial3 = true;
					spaces[0][2].setIcon(disabledIcon);
					spaces[0][2].setDisabledIcon(disabledIcon);
					spaces[0][2].setEnabled(false);
					moves.push(3);}
			}
			else if (e.getSource() == spaces[1][0]) {
				if(XorO.equals("Player 1")) {
					test4 = true;
					spaces[1][0].setIcon(disabledIcon);
					spaces[1][0].setDisabledIcon(disabledIcon);
					spaces[1][0].setEnabled(false);
					moves.push(4);}
				else {
					trial4 = true;
					spaces[1][0].setIcon(disabledIcon);
					spaces[1][0].setDisabledIcon(disabledIcon);
					spaces[1][0].setEnabled(false);
					moves.push(4);}
			}
			else if (e.getSource() == spaces[1][1]) {
				if(XorO.equals("Player 1")) {
					test5 = true;
					spaces[1][1].setIcon(disabledIcon);
					spaces[1][1].setDisabledIcon(disabledIcon);
					spaces[1][1].setEnabled(false);
					moves.push(5);}
				else {
					trial5 = true;
					spaces[1][1].setIcon(disabledIcon);
					spaces[1][1].setDisabledIcon(disabledIcon);
					spaces[1][1].setEnabled(false);
					moves.push(5);}
			}
			else if (e.getSource() == spaces[1][2]) {
				if(XorO.equals("Player 1")){
					test6 = true;
					spaces[1][2].setIcon(disabledIcon);
					spaces[1][2].setDisabledIcon(disabledIcon);
					spaces[1][2].setEnabled(false);
					moves.push(6);}
				else {
					trial6 = true;
					spaces[1][2].setIcon(disabledIcon);
					spaces[1][2].setDisabledIcon(disabledIcon);
					spaces[1][2].setEnabled(false);
					moves.push(6);}
			}
			else if (e.getSource() == spaces[2][0]) {
				if(XorO.equals("Player 1")){
					test7 = true;
					spaces[2][0].setIcon(disabledIcon);
					spaces[2][0].setDisabledIcon(disabledIcon);
					spaces[2][0].setEnabled(false);
					moves.push(7);}
				else {
					trial7 = true;
					spaces[2][0].setIcon(disabledIcon);
					spaces[2][0].setDisabledIcon(disabledIcon);
					spaces[2][0].setEnabled(false);
					moves.push(7);}
			}
			else if (e.getSource() == spaces[2][1]) {
				if(XorO.equals("Player 1")){
					test8 = true;
					spaces[2][1].setIcon(disabledIcon);
					spaces[2][1].setDisabledIcon(disabledIcon);
					spaces[2][1].setEnabled(false);
					moves.push(8);}
				else {
					trial8 = true;
					spaces[2][1].setIcon(disabledIcon);
					spaces[2][1].setDisabledIcon(disabledIcon);
					spaces[2][1].setEnabled(false);
					moves.push(8);}
			}
			else if (e.getSource() == spaces[2][2]) {
				if(XorO.equals("Player 1")) {
					test9 = true;
					spaces[2][2].setIcon(disabledIcon);
					spaces[2][2].setDisabledIcon(disabledIcon);
					spaces[2][2].setEnabled(false);
					moves.push(9);}
				else {
					trial9 = true;
					spaces[2][2].setIcon(disabledIcon);
					spaces[2][2].setDisabledIcon(disabledIcon);
					spaces[2][2].setEnabled(false);
					moves.push(9);}
			}
//Winning Conditions
			if(test1 == true && test2 == true && test3 == true) {
				win = true;}
			else if(test4 == true && test5 == true && test6 == true) {
				win = true;}
			else if(test7 == true && test8 == true && test9 == true) {
				win = true;}
			else if(test1 == true && test4 == true && test7 == true) {
				win = true;}
			else if(test2 == true && test5 == true && test8 == true) {
				win = true;}
			else if(test3 == true && test6 == true && test9 == true) {
				win = true;}
			else if(test1 == true && test5 == true && test9 == true) {
				win = true;}
			else if(test3 == true && test5 == true && test7 == true) {
				win = true;}
			if(trial1 == true && trial2 == true && trial3 == true) {
				win = true;}
			else if(trial4 == true && trial5 == true && trial6 == true) {
				win = true;}
			else if(trial7 == true && trial8 == true && trial9 == true) {
				win = true;}
			else if(trial1 == true && trial4 == true && trial7 == true) {
				win = true;}
			else if(trial2 == true && trial5 == true && trial8 == true) {
				win = true;}
			else if(trial3 == true && trial6 == true && trial9 == true) {
				win = true;}
			else if(trial1 == true && trial5 == true && trial9 == true) {
				win = true;}
			else if(trial3 == true && trial5 == true && trial7 == true) {
				win = true;}
//What happens when a player wins
			if (win == true) {
				if(XorO.equals("Player 1")) 
				{
					p1wins++;
				JOptionPane.showMessageDialog(null, "Player 1  WINS!");
				menu.remove(xwins);
				xwins = new JLabel("Player 1 Wins: " +  p1wins);
				menu.add(xwins, BorderLayout.NORTH);
				menu.revalidate();
				menu.repaint();
				}
			else if(XorO.equals("Player 2")) {
				p2wins++;
				JOptionPane.showMessageDialog(null, "Player 2 WINS");
				menu.remove(owins);
				owins = new JLabel("Player 2 Wins: " + p2wins);
				menu.add(owins, BorderLayout.SOUTH); 
				menu.revalidate();
				menu.repaint();
				}
				for(int a = 0; a < 3; a++)                      
				{
					for(int b = 0; b < 3; b++) 
					{
						spaces[a][b].setEnabled(false);   
					}
				}
			}
			else if (gameMoves == 9 && win == false) {
				JOptionPane.showMessageDialog(null, "Tie Game!");
			}
		}
	}
}
