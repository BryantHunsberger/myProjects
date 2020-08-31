package Lab_Six;

import javax.swing.JFrame;
import java.util.Scanner;

/*	
C212 - Lab 6 - CheckBoardOfTriangles
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 2/26/2020 
*/

// This class takes user input, and passes user size to the checkBoardMaker class. 
// This class also develops a JFrame in which user parameters can be used to develop
// our checkboard
public class CheckBoardOfTriangles {

	public static void main(String[] args) {
		
		final int CLOSE = -1;
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("We are going to print a checkboard!");
		System.out.println("Pick a size for your checkboard (-1 TO EXIT): ");
		int boardSize = userInput.nextInt();
		
		while (boardSize != CLOSE)
		{
			printCheckBoard(boardSize);
			userInput.nextLine();
			System.out.println("Pick a size for your checkboard (-1 TO EXIT): ");
			boardSize = userInput.nextInt();
		}
		
		/////////////Testing////////////////
		System.out.println("\n\nTesting: ");
		System.out.println("Checkerboard size 15: ");
		printCheckBoard(15);
		System.out.println("\nCheckerboard size 40: ");
		printCheckBoard(40);
		
		userInput.close();
	}
	
	// This method printCheckBoard develops our JFrame
	// @param size, user int size for checkerboard measurements
	public static void printCheckBoard(int size) 
	{
		JFrame frame = new JFrame();
		frame.setSize(900,600);
		frame.setTitle("Our Checker Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckBoardMaker component = new CheckBoardMaker();
		component.setSize(size);
		frame.add(component);
		frame.setVisible(true);
		
	}
	
	
}
