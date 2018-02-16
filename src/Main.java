/*
 * The Main program will run an application that will simulate Hangman.
 * The user will have 10 tries to guess the word that is given to them. The
 * user can only input one letter at a time. After ten tries, if the user hasn't guessed
 * the word, then it's game over. If the user has guessed the word before 10 tries,then
 * they have won the game. The game will be simulated on a JFrame.
 * 
 * @author Brian Aguilar
 * @version 1.0
 * @since 2018-15-2
 * 
 */
public class Main {
	public static void main(String [] args) {
		//Starts up the application
		HangmanGUI gui = new HangmanGUI();
	}//main
}
