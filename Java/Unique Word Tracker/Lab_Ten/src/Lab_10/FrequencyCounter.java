package Lab_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*	
C212 - Lab 10 - FrequencyCounter
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 4/15/2020 
*/

// This class tracks the words, lines, and frequencies of any file that is passed to the constructor
public class FrequencyCounter {

	private String fileName;
	Set<String> myUniqueWords = new TreeSet<>();
	Map<String,Integer> wordOccurences = new TreeMap<>();
	private int numberWords;
	private int numberLines;
	
	// This Constructor passes a given file from main
	FrequencyCounter(String fileName)
	{
		this.setFileName(fileName);
		this.setNumberWords(0);
		this.setNumberLines(0);
	}
	
	// This method is the core of the class, it reads into the given file, and then iterates through
	// the text to find frequencies, lines, and numbers. A set and a map are constructed within to track
	// unique words and to make correlations to frequency
	// @param, no parameters
	// @return, no return
	public void populateFiles()
	{
		File inputFile = new File(this.fileName);
		try {
			// create new File object and pass to the scanner
			Scanner myFileInfo = new Scanner(inputFile);
			
			while (myFileInfo.hasNext())
			{
				this.numberWords += 1;
				
				myUniqueWords.add(myFileInfo.next().toLowerCase());
			}
			
			for (String word : myUniqueWords)
			{
				wordOccurences.put(word, 0);
			}
	
			myFileInfo.close();
			
			Scanner myFileInfo2 = new Scanner(inputFile);
			
			while (myFileInfo2.hasNext())
			{
				String nextVal = myFileInfo2.next();
				wordOccurences.replace(nextVal, wordOccurences.get(nextVal) + 1);
			}
			
			myFileInfo2.close();
			
			Scanner myNextLine = new Scanner(inputFile);
			
			while (myNextLine.hasNext())
			{
				this.numberLines += 1;
				myNextLine.nextLine();
			}
			
			myNextLine.close();
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}

	// These are all the getters and setters for our private instance variables
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public int getMyUniqueWords() {
		
		return myUniqueWords.size();
	}
	
	public Map getWordOccurences() {
		
		return this.wordOccurences;
	}

	public int getNumberWords() {
		return numberWords;
	}

	public void setNumberWords(int numberWords) {
		this.numberWords = numberWords;
	}

	public int getNumberLines() {
		return numberLines;
	}

	public void setNumberLines(int numberLines) {
		this.numberLines = numberLines;
	}
}
