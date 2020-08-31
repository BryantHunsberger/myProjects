package Lab_Six;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

/*	
C212 - Lab 6 - checkBoardMaker
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 2/26/2020 
*/

// This class takes information from the CheckBoardOfTraingles, and within this class
// computes triangle sizes, then creates squares from this information for the checkerboard
// @param size, this private int takes in size from the user for the board
@SuppressWarnings("serial")
public class CheckBoardMaker extends JComponent {

	private int size;
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		int interval = 1;
		for (int i = 0; i < size*8; i+= size)
		{
			interval += 1;
			for (int j = 0; j < size*8; j+=size)
			{
		
				Polygon polyOne = new Polygon();
				polyOne.addPoint(j, i);
				polyOne.addPoint(j + size,i);
				polyOne.addPoint(j, i+size);
				if (interval % 2 == 0)
				{
					g.setColor(Color.white);
					g.fillPolygon(polyOne);
				}
				else
				{
					g.setColor(Color.black);
					g.fillPolygon(polyOne);
				}
				Polygon polyTwo = new Polygon();
				polyTwo.addPoint(j + size, i + size);
				polyTwo.addPoint(j + size, i);
				polyTwo.addPoint(j, i+size);
				if (interval % 2 == 0)
				{
					g.setColor(Color.white);
					g.fillPolygon(polyTwo);
				}
				else
				{
					g.setColor(Color.black);
					g.fillPolygon(polyTwo);
				}
				g2.drawPolygon(polyOne);
				g2.drawPolygon(polyTwo);
				
				interval += 1;
				
			}
		}
		
	}
	
	// Sets the size for our checkerboard, length and width of our triangles will be equal
	// @param newSize, this is the int represented size of our checkerboard sides
	
	public void setSize(int newSize)
	{
		this.size = newSize;
	}

}
