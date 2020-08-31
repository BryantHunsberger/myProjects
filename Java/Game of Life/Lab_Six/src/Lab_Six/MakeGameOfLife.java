package Lab_Six;

import java.util.Scanner;

/*	
C212 - Lab 6 - MakeGameOfLife
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 2/26/2020 
*/

// This class creates the components necessary to develop our GameOfLife
// This class creates objects within the GameOfLife class
// MakeGameOfLife has many methods, which use user input to develop patterns
public class MakeGameOfLife {
	
	public static void main(String[] args) 
	{
		
		Scanner userResponse = new Scanner(System.in);
		System.out.println("Input the dimensions of the first board: ");
		System.out.print("Width of board: ");
		int boardWidth = userResponse.nextInt();
		userResponse.nextLine();
		System.out.print("Length of board: ");
		int boardLength = userResponse.nextInt();
		userResponse.nextLine();
		int[][] firstBoard = new int[boardLength][boardWidth];
		System.out.println("Within this board we are going to select which spaces we would like occupied using coordinates INCLUDING ZERO!: (-1 to EXIT) ");
		System.out.println("Select your Y-Coordinate: ");
		int xCoord = userResponse.nextInt();
		userResponse.nextLine();
		System.out.println("Select your X-Coordinate: ");
		int yCoord = userResponse.nextInt();
		userResponse.nextLine();
		
		
		while ((xCoord != -1) && (yCoord != -1))
		{
			while ((xCoord >= boardLength) || (xCoord >= boardWidth) || ((xCoord < 0) && (xCoord != -1)))
			{
				System.out.println("Select your Y-Coordinate: ");
				xCoord = userResponse.nextInt();
				userResponse.nextLine();
				if (xCoord == -1)
				{
					break;
				}
			}
			while ((yCoord >= boardLength) || (yCoord >= boardWidth) || ((yCoord < 0) && (yCoord != -1)))
			{
				System.out.println("Select your Y-Coordinate: ");
				yCoord = userResponse.nextInt();
				userResponse.nextLine();
				if (yCoord == -1)
				{
					break;
				}
			}
			
			firstBoard[xCoord][yCoord] = 1;
			
			System.out.println("Select your Y-Coordinate: ");
			xCoord = userResponse.nextInt();
			userResponse.nextLine();
			if (xCoord == -1)
			{
				break;
			}
			while ((xCoord >= boardLength) || (xCoord >= boardWidth) ||(xCoord < 0))
			{
				System.out.println("Select your Y-Coordinate: ");
				xCoord = userResponse.nextInt();
				userResponse.nextLine();
			}
			System.out.println("Select your X-Coordinate: ");
			yCoord = userResponse.nextInt();
			userResponse.nextLine();
			if (yCoord == -1)
			{
				break;
			}
			while ((yCoord >= boardLength) || (yCoord >= boardWidth) ||(yCoord < 0))
			{
				System.out.println("Select your X-Coordinate: ");
				yCoord = userResponse.nextInt();
				userResponse.nextLine();
			}
			
			
		}
	
		boolean[][] ourBoard = board(firstBoard, boardWidth, boardLength);
		
		System.out.println("How many Generations would you like your board to run?: ");
		int gens = userResponse.nextInt();
		userResponse.nextLine();			
		System.out.println("How frequently would you like to print your board?: ");
		int frequency = userResponse.nextInt();
		userResponse.nextLine();
		
		grow(gens, frequency, boardWidth, boardLength, ourBoard);
		
		System.out.println("\n\n\n\n\n\n");
		System.out.println("Here our tests for our program: ");
		
		/////////////////////// Tests ////////////////////////////////
		
		System.out.println("Still Life: ");
		boolean[][] stillLifeBoard = new boolean[5][6];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				if (((i == 2) && (j == 1)) || ((i == 1) && (j == 2)) || ((i == 1) && (j == 3)) || ((i == 2) && (j == 4))
						|| ((i == 3) && (j == 2)) || ((i == 3) && (j == 3)))
				{
					stillLifeBoard[i][j] = true;
				}
				
				else
				{
					stillLifeBoard[i][j] = false;
				}
			}
		}
		
		grow(100, 20, 6, 5, stillLifeBoard);
		
		System.out.println("\n\n");
		System.out.println("Oscillator: ");
		boolean[][] oscillatorBoard = new boolean[5][5];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (((i == 2) && (j == 1)) || ((i == 2) && (j == 2)) || ((i == 2) && (j == 3)))
				{
					oscillatorBoard[i][j] = true;
				}
				
				else
				{
					oscillatorBoard[i][j] = false;
				}
			}
		}
		
		grow(20, 1, 5, 5, oscillatorBoard);
		
		userResponse.close();
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// This method board essentially turns the first user created board from a binary board into
	// a boolean board.
	// @param myBoard, takes our first user created board, with size #columns and #rows
	// @param numberColumns, this is basically the width for our primary board
	// @param numberRows, this is our length for our primary board
	// @return, boolean[][] returns our first board in terms of trues and falses 
	public static boolean[][] board(int[][] myBoard, int numberColumns, int numberRows)
	{
		boolean[][] newBoard = new boolean[numberRows][numberColumns];
		
		for (int i = 0; i < numberRows; i++)
		{
			for (int j = 0; j < numberColumns; j++)
			{
				if (myBoard[i][j] == 1)
				{
					newBoard[i][j] = true;
				}
				else
				{
					newBoard[i][j] = false;
				}
			}
		}
		 
		return newBoard;
		
		
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// This method uses our current board which is represented in true and false, then converts these
	// values into a form that is easier processed graphically. Our true and falses are now expressed in 
	// terms of "o" and "+".
	// @param board, this is our current boolean board with true and false representations
	// @param cols, this is the width of our current board
	// @param rows, this is the length of our current board
	// @return String, this returns a string representation of our true and false values of our
	// original board
	public static String toString(boolean[][] board, int cols, int rows)
	{
		
		String buildString = "";
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (board[i][j] == true)
				{
					buildString += "o";
					buildString += " ";
				}
				else
				{
					buildString += "+";
					buildString += " ";
				}
			}
			
			buildString += "\n";
		}
		
		return buildString;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// this method plays the key role in allowing our current board to mutate into new board based on
	// rules set by the GameOfLife. 
	// @param generation, this determines how many different boards we will create
	// @param freqPrint, this is how often we will print our board, how many different generations we
	// will print our boards
	// @param colWidth, this is our first board width
	// @param rowLength, this is our first board length
	// @param board, this is our first board the user created
	public static void grow(int generation, int freqPrint, int colWidth, int rowLength, boolean[][] board)
	{
		int genInt = 1;
		int freqInt = 1;
		int currentLength = rowLength;
		int currentWidth = colWidth;
		
		GameOfLife newGame = new GameOfLife(board, colWidth, rowLength);
		
		while (genInt <= generation)
		{
			if ((freqInt % freqPrint == 0) || freqInt == 1)
			{
				System.out.println("Generation: " + genInt);
				boolean[][] theBoard = newGame.getBoard();
				int numCols = newGame.getNUMCOL();
				int numRows = newGame.getNUMROW();
				System.out.println(toString(theBoard, numCols, numRows));
			}
			
			freqInt += 1;
			
			boolean[][] findBoard = newGame.getBoard();
			currentLength += 1;
			currentWidth += 1;
			
			boolean[][] createNewBoard = new boolean[currentLength][currentWidth];
			
			for (int i = 0; i < newGame.getNUMROW(); i++)
			{
				for (int j = 0; j < newGame.getNUMCOL(); j++)
				{
					if (newGame.checkNeighbor(i, j) == 3)
					{
						createNewBoard[i][j] = true;
					}
					else if ((newGame.checkNeighbor(i,j) == 2) && (findBoard[i][j] == true))
					{
						createNewBoard[i][j] = true;
					}
					else
					{
						createNewBoard[i][j] = false;
					}
					
					
				}
			}
			
			
			genInt += 1;
			
			newGame = new GameOfLife(createNewBoard,currentWidth, currentLength);
			
			
		}
		
		
	}
	
}
