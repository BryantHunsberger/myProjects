package Lab_Nine;

import java.awt.Color;

public class Hexagon extends Polygon 
{
	
	final int NUMPOINTS = 6;
	
	public Hexagon(Color fillColor, Color borderColor, int x, int y, int[] xP, int[] yP) 
	{
		super(fillColor, borderColor, x, y, xP, yP);
		
		super.setTotalPoints(NUMPOINTS);
	}
}
