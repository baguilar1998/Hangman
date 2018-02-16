/*
 * RandomWordGenerator is a helper class that will generate a random word
 * that is provided from a set text file.
 * 
 * @author Brian Aguilar
 * @version 1.0
 * @since 2018-15-2
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class RandomWordGenerator {
	
	// Fields needed to go through the file
	private File file;
	private Scanner fileReader;
	private ArrayList<String> listOfWords;
	
	/*
	 * RandomWordGenerator Constructor
	 * @param fileName the name of the file. If the file is not found,
	 * a pop-up window will appear telling the user that the file could
	 * not be found.
	 */
	public RandomWordGenerator(String fileName) {
		try {
			file = new File(fileName);
			fileReader = new Scanner(file);
		}catch(FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File not found");
			return;
		}
		listOfWords = new ArrayList<String>();
	}//RandomWordGenerator Constructor
	
	/*
	 * A helper function that reads through file which contains a list 
	 * of words and stores it in an ArrayList. 
	 */
	private void generateList() {
		while(fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			listOfWords.add(line);
		}
	}//generateList
	
	/*
	 * Creates a list of words that were in the text file and returns
	 * a random word from that list.
	 * @return a random word in the ArrayList
	 */
	public String generateRandomWord() {
		generateList();
		return listOfWords.get((int)(Math.random() * listOfWords.size()));
	}//generateRandomWord
}
