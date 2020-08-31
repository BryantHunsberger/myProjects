package Lab_Nine;

import java.awt.Color;

public class Pentagon extends Polygon {

	final int NUMPOINTS = 5;
	
	public Pentagon(Color fillColor, Color borderColor, int x, int y, int[] xP, int[] yP) 
	{
		super(fillColor, borderColor, x, y, xP, yP);
		
		super.setTotalPoints(NUMPOINTS);
	}
	
	

}
