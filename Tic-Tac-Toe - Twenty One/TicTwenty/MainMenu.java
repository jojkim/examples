//FINISH THE ABOUT AND GET STARTED ALONG WITH THE REST OF THE PROJECT!
//ALSO CHANGE BUTTON.SETBOUNDS FOR REAL BACKGROUND!
//
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class MainMenu implements ActionListener{

//Variables!
	private boolean black = false;
	private boolean xo = false;

	private JFrame frame;
	private JPanel base;
	private JPanel main;
	private JPanel cards;
	private JPanel tictac;
	private JLabel background;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu help;
	private JMenuItem menu;
	private JMenuItem history;
	private JMenuItem exit;
	private JMenuItem start;
	private JMenuItem about;
	private JButton tic;
	private JButton twe;

	private TwentyOne bj = new TwentyOne();
	private TicTacToe ttt = new TicTacToe();

//Generates the main menu, initializes variables, sets backgrounds, and sets cardlayout.
	public void buildMain(){
		ttt.initialize();
		frame = new JFrame("P4 Arcade");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000,600));
				
		base = new JPanel(new CardLayout());

		main = new JPanel();

		cards = new JPanel();
		cards = bj.getGame();
		
		tictac = new JPanel();
		tictac = ttt.getGame();

		try{
			background = new JLabel(new ImageIcon(ImageIO.read(new File("welcome.jpg"))));
		}

		catch(IOException i){}

		menuBar = new JMenuBar();

		file = new JMenu("File");
		help = new JMenu("Help");

		menu = new JMenuItem("Main Menu");
		menu.setActionCommand("menu");
		menu.addActionListener(this);
		menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));

		history = new JMenuItem("History");
		history.setActionCommand("history");
		history.addActionListener(this);
		history.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

		exit = new JMenuItem("Exit");
		exit.setActionCommand("exit");
		exit.addActionListener(this);

		start = new JMenuItem("Get Started");
		start.setActionCommand("start");
		start.addActionListener(this);
		start.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));

		about = new JMenuItem("About");
		about.setActionCommand("about");
		about.addActionListener(this);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

		tic = new JButton("Tic-Tac-Toe");
		tic.setBounds(375,300,250,50);
		tic.setActionCommand("tic");
		tic.addActionListener(this);

		twe = new JButton("Twenty-One");
		twe.setBounds(375,360,250,50);
		twe.setActionCommand("twe");
		twe.addActionListener(this);
		
		menuBar.add(file);
		menuBar.add(help);
		
		file.add(menu);
		file.add(history);
		file.add(exit);
		
		help.add(start);
		help.add(about);

		main.add(background);

		background.add(tic);
		background.add(twe);

		base.add(main, "1");
		base.add(cards, "3");
		base.add(tictac, "2");

		frame.add(base);
		frame.setJMenuBar(menuBar);
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);

	}

//Checks if a button is pushed and then perform an action
	public void actionPerformed(ActionEvent e){
		CardLayout layout = (CardLayout)(base.getLayout());

//returns to main menu
		if("menu".equals(e.getActionCommand())){
			black = false;
			xo = false;
			layout.show(base, "1");
			bj.reset();
		}

//opens BlackJack history
		else if("history".equals(e.getActionCommand())){
			if(black == true){
				System.out.println("21 Leader");
				bj.history();
			}
		}
//exits
		else if("exit".equals(e.getActionCommand())){
			System.exit(0);
		}

//opens Get Started
		else if("start".equals(e.getActionCommand())){
			JOptionPane.showMessageDialog(frame, "Click on either Tic-Tac-Toe or Twenty-One to play a game!");
		}

//opens About
		else if("about".equals(e.getActionCommand())){
			JOptionPane.showMessageDialog(frame, "In Tic-Tac-Toe, your goal is to get three-in-a-row. Just click on a blank square to mark it. Click th reset button to reset the game.\n\nIn Twenty-One, your goal is to have a higher value hand than the dealer without going over 21. The value of the cards are determined by the number on them. \nFace cards are valued at 10 points and aces are valued at either 1 or 11 points. \nThe game will point the right amount. Click on hit to get a new card, stand to end your turn, split to make a new hand (you can only spilt once), or give up to give up.");

		}

//opens Tic-Tac-Toe
		else if("tic".equals(e.getActionCommand())){
			black = false;
			xo = true;
			layout.show(base, "2");
		}

//opens Twenty-One
		else if("twe".equals(e.getActionCommand())){
			black = true;
			xo = false;
			layout.show(base, "3");
		}
	}
}
