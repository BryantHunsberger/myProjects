package Lab_10;

/*	
C212 - Lab 10 - StringData
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 4/15/2020 
*/

// This class stores statistics for individual words
public class StringData {

	private String myString;
	private int count;
	private int stringLength;
	
	// @param word, this is the current word passed into this class
	// @param wordFrequency, this is the amount of times this word appears in the text
	public StringData(String word, int wordFrequency)
	{
		this.setMyString(word);
		this.setCount(wordFrequency);
		this.setStringLength(word.length()); // This sets the length of the given word
	}

	// These are the getters and setters for the private instance variables
	
	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStringLength() {
		return stringLength;
	}

	public void setStringLength(int stringLength) {
		this.stringLength = stringLength;
	}
}
