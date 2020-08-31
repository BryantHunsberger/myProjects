package Lab_Six;

/*	
C212 - Lab 6 - GameOfLife
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 2/26/2020 
*/

// This class keep track of our different boards we create throughout the GameOfLife
// @param NUMCOL, this keeps track of our different board widths
// @param NUMROW, this keeps track of our different board lengths
// @param board, this represents the current board given a certain generation
public class GameOfLife {

	private int NUMCOL;
	private int NUMROW;
	private boolean[][] board;
	
	// This is our constructor for our GameOfLife class, it sets our current values for our board
	// @param initialBoard, this is the board passed in from MakeGameOfLife, given a generation
	// @param columns, this is the width passed in by MakeGameOfLife, given a generation
	// @param rows, this is the legnth passed in from MakeGameOfLife, given a generation
	public GameOfLife(boolean[][] initialBoard, int columns, int rows)
	{
		this.NUMROW = rows;
		this.NUMCOL = columns;
		this.board = new boolean[rows][columns];
		
		boolean[][] someBoard = new boolean[rows][columns];
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				someBoard[i][j] = initialBoard[i][j];
			}
		
		}
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				this.board[i][j] = someBoard[i][j];
			}
		
		}
		
	}
	
	// getter, gets our current board
	public boolean[][] getBoard() {
		return board;
	}
	
	// setter, sets our current board to a certain value
	public void setBoard(boolean[][] board) {
		this.board = board;
	}
	
	// getter, gets our current width of our board
	public int getNUMCOL() {
		return NUMCOL;
	}
	
	// getter, gets our current legnth of our board
	public int getNUMROW() {
		return NUMROW;
	}
	
	// This method is the essence for the rules of the GameOfLife, for a given point, this method
	// determines how many neighbors this point has based on GameOfLife rules.
	// @param x, this is the current x coordinate
	// @param y, this is the current y coordinate
	// @return int, returns how many neighbors a certain point has
	public int checkNeighbor(int x, int y)
	{
		int countNeighbors = 0;
		
		if ((x != 0) && (y != 0) && (this.board[x-1][y-1] == true))
		{
			countNeighbors += 1;
		}
		if ((x != 0) && (this.board[x-1][y] == true))
		{
			countNeighbors += 1;
		}
		if ((y != NUMCOL - 1) && (x != 0) && (this.board[x-1][y+1] == true))
		{
			countNeighbors += 1;
		}
		if ((y != NUMCOL - 1) && (this.board[x][y+1] == true))
		{
			countNeighbors += 1;
		}
		if ((x != NUMROW - 1) && (y != NUMCOL - 1) && (this.board[x+1][y+1] == true))
		{
			countNeighbors += 1;
		}
		if ((x != NUMROW - 1) && (this.board[x+1][y] == true))
		{
			countNeighbors += 1;
		}
		if ((y != 0) && (x != NUMROW - 1) && (this.board[x+1][y-1] == true))
		{
			countNeighbors += 1;
		}
		if ((y != 0) && (this.board[x][y-1] == true))
		{
			countNeighbors += 1;
		}
		
		
		return countNeighbors;
	}
	
	
}
