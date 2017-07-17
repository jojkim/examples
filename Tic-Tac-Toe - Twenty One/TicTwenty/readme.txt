P4 Arcade by Hilal Bari and John Kim

Purpose: The purpose of this project was to demostrate our ability to work together and our skill with
Java Swing. To do so, we were given the task of creating a program that would give the user a choice 
between playing a graphically version of Tic-Tac-Toe or a graphically version of Twenty-One, also
known as Blackjack.

To run:
1. Make sure all revelant files are in the same location as the java files.
2. Run the "make compile" command in order to create the class files.
3. Run the "make run" command in order to start the program.
	*If you are running the program on a remote server, please enable X11
	forwarding.
4. The Main menu will give you two options: Tic-Tac-Toe or Twenty-One. Click on the one you wish
   to play.
5. On the Tic-Tac-Toe menu, click on either "Human vs Human" to play against your fellow men or
   "Human vs Computer" to play against the computer.
   
   On the Twenty-One menu, click on the start button to be taken to the Number of Decks selection
   screen. Click on one of the numbers to start the game.

6. In Tic-Tac-Toe, click on the space that you wish to mark. Continue until someone gets
   three-in-a-row or all spaces are filled. Check the Get Started for more information.

   In Twenty-One, the cards on the botton of the screen are yours. Click on the hit button to draw
   another card, stand to end your turn, spilt to create a second hand, or give up to give up. 
   Check the Get Started to see more details on the rules.

7. Once you finishing playing, exit the window and in the termial enter "make clean" to remove the
   class files.

Design Choices
Tic-Tac-Toe: The panel contains a game panel and a menu panel. The menu panel
contains the leaderboard and a reset button. The game panel contains the 9
JButtons that are clicked in order to achieve a win. Player one always goes
first and is a Georgia Bulldawg. Player 2 goes second and is a florida gator.
In order to start a full new game, you must click the reset button. Undo does
not work if the game has ended and there are still empty spaces.

Twenty-One: The background is suppose to resemble a card table. The reason why the number of decks
has to be clicked is because neither one of us could figure out an easier way. We placed the hit, stand,
split, and give up bottons under the deck image in the center of the screen because it seen to be the
best place for them. The split button actually doesn't work, displaying a
dialog box instead. We did not successfully implement it.

Extra Credit
We implemented the "true" behavior of the ace. The ace will automatically adjust its value
depending on the sitaution.
