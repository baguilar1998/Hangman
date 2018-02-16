/* WordGuesser is a class that will simulate the Hangman program. This program will
 * hold the word that the user will have to guess and will check the current status 
 * of the game. It will check things such as all incorrect guesses, if all the correct
 * letters were guessed etc. This will be displayed on a JFrame.
 * 
 * @author Brian Aguilar
 * @version 1.0
 * @since 2018-15-2
 * 
 */
import java.util.Hashtable;
public class WordGuesser {
	
	//Fields needed for the game
	private String word;
	private Hashtable <Character,Boolean> wordCharacters;
	private int wrongLetters;
	private boolean allLettersGuessed;
	private char guess;
	
	/*
	 * WordGuesser Constructor with no parameters
	 */
	public WordGuesser() {
		word=null;
		wordCharacters=null;
		wrongLetters=0;
		guess='\0';
	}//WordGuesser with no parameters
	
	/*
	 * WordGuesser Constructor with one parameter
	 * @param word the word that needs to be guessed
	 */
	public WordGuesser(String word) {
		super();
		this.word=word;
		wordCharacters = new Hashtable<Character,Boolean>();
		setHashtable();
	}//WordGuesser with one parameter
	
	/*
	 * Sets the guess of the user. If the user enters in any other character
	 * that's not a lower case letter, an exception is thrown.
	 * @param guess a lower case letter
	 */
	public void setGuess(char guess){
		if(!(guess>= 'a' && guess <='z')) throw new IllegalArgumentException();
		this.guess=guess;
	}//setGuess
	
	/*
	 * A helper function that implements the Hashtable data structure.
	 * This Hashtable will store all the unique letters of the word
	 * that needs to be guessed.
	 */
	private void setHashtable() {
		for(int i=0;i<word.length();++i) {
			if(word.charAt(i)==' ')continue;
				wordCharacters.put(word.charAt(i), false);
		}
	}//setHashtable
	
	/*
	 * @return the letter that the user guessed
	 */
	public char getGuess() {
		return guess;
	}//getGuess
	
	/*
	 * @return the number of times the user has guessed a wrong letter
	 */
	public int getWrongLetters() {
		return wrongLetters;
	}//getWrongLetters
	
	/*
	 * @return if the user guessed all the correct letters or not
	 */
	public boolean getAllLettersGuessed() {
		return allLettersGuessed;
	}//getAllLettersGuessed
	
	/*
	 * Updates the game. This will display to the user what word they are trying
	 * to guess. It will display to them all letters that they have guessed correctly.
	 * Along with the number of times they have guessed the wrong letter
	 * @return the current state of the game
	 */
	public String gameUpdate() {
		String gameUpdater="<html><center>";
		gameUpdater+="You are guessing: ";
		
		for(int i=0;i<word.length();++i) {
			if(word.charAt(i)==' ')gameUpdater+=" ";
			else if(!wordCharacters.get(word.charAt(i)) )gameUpdater+="_";
			else gameUpdater+=""+word.charAt(i);
		}
		
		gameUpdater+="<br>You have guessed ("+wrongLetters+") wrong letters <br>";
		gameUpdater+="Guess a letter: </center></html>";
		return gameUpdater;
	}//gameUpdate
	
	/*
	 * Checks the user's guess. If the guess was incorrect, the number of 
	 * letters that have they guessed wrong will increase by 1. If they 
	 * have guessed a letter correctly, it will be visible for them to see 
	 * that letter so that they will be one step closer into guessing the correct word
	 * @param letter the user's guess
	 */
	public void checkGuess(char letter) {
		boolean isFound=false;
		for(int i=0;i<wordCharacters.size();++i) {
			if(wordCharacters.containsKey(letter)) {
				wordCharacters.put(letter, true);
				isFound=true;
			}
		}
		if(isFound)return;
		++wrongLetters;
	}//checkGuess
	
	/*
	 * Checks the current state of the game.This will keep checking the game
	 * until the game is over. The game is over when the user had guessed all
	 * letters of the word or when they had made 10 incorrect guesses.
	 */
	public void checkGame() {
		if(wrongLetters == 10) {
			return;
		}
		allLettersGuessed=true;
		for(int i=0;i<wordCharacters.size();i++) {
			if(wordCharacters.contains(false))allLettersGuessed=false;
		}
	}//checkGame
	
	/*
	 * Displays the results of the game to the user if they have won
	 * or lost the game. 
	 * @return the results of the game
	 */
	public String displayResults() {
		String resultDisplayer="<html>";
		if(allLettersGuessed) {
			resultDisplayer+="<center>You win<br>";
			resultDisplayer+="You have guessed '"+word+"' correctly</center></html>";
		}else {
			resultDisplayer+="<center>Sorry, You lost!<br>";
			resultDisplayer+="The correct guess was '" +word+"'</center></html>";
		}
		return resultDisplayer;
	}//displayResults
	

}
