package Lab_10;

import java.util.Scanner;

/*	
C212 - Lab 10 - RecursiveIterator
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 4/15/2020 
*/

// This class RecursiveIterative takes in a string of any length given by the user, then sets the 
// first letter aside, reverses the rest of the string, and then adds the first letter. This gives 
// us our original string in a reverse manner
public class RecursiveIterative {

	public static void main(String[] args) {

		Scanner nextIn = new Scanner(System.in);
		System.out.println("Type in a string you would like to have reversed!: ");
		String myString = nextIn.nextLine();
		System.out.println("Your Recursively reversed string is: " + stringReverse(myString) + "\n" + 
		"Your Iteratively reversed string is: " + iterativeStringReverse(myString));
		
	}
	
	// This method takes a user string passed by main, sets aside the first letter in the word,
	// then passes the remaining word to a helper method
	// @param text, this is the user input for the string being reversed
	// @return String, the reversed string is returned back to main
	public static String stringReverse(String text)
	{
		String myFirstLetter = text.substring(0, 1);
		
		String restOfText = text.substring(1);
		
		String reversed = stringReverseHelper(restOfText, "", restOfText.length()- 1);
		
		return (reversed + myFirstLetter);
	}
	
	// This helper method does a recursive version of reversing a user given string. It 
	// takes the given string, and reverses it 1 letter at a time
	// @param input, this is the string representation without the first letter
	// @param reversed, this is the new string that will be added to
	// @param i, this is the length of the part of string passed to the method
	// returns the reversed string
	private static String stringReverseHelper(String input, String reversed, int i)
	{
		String inputShort = input.substring(0,i + 1);
		String myRevString = reversed + input.substring(i + 1);
		
		if (i < 0)
		{
			return myRevString;
		}
		else
		{
			int newI = i -1;
			return (stringReverseHelper(inputShort, myRevString, newI));
		}
		
	}
	
	// This method reverses a user given string in an iterative manner, it starts with a blank string
	// and adds 1 letter at a time backwards until the string is reversed
	// @param text, this is the string passed in by the user
	// returns the reversed string back to main
	private static String iterativeStringReverse(String text)
	{
		
		String myFirstLetter = text.substring(0, 1);
		
		String restOfText = text.substring(1);
		
		String myNewWord = "";
		
		for (int i = restOfText.length() - 1; i >= 0; i--)
		{
			myNewWord += restOfText.substring(i , i+1);
		}
		
		return (myNewWord + myFirstLetter);
	}

}
