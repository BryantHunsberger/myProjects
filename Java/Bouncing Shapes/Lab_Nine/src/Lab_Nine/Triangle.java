package Lab_Nine;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	private int[] xPoints;
	private int[] yPoints;
	final int NUMPOINTS = 3;
	private int area = -1;
	
	public Triangle(Color fillColor, Color borderColor, int x, int y, int[] xVals, int[] yVals) {
		
		super(fillColor, borderColor, x, y);
		
		this.xPoints = xVals;
		
		this.yPoints = yVals;
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw(Graphics g) {
		
		g.setColor(super.getFillColor());
		g.fillPolygon(xPoints, yPoints, NUMPOINTS);
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moveLocation(int dx, int dy) {
		for(int i = 0; i < NUMPOINTS; i++)
		{
			if ((xPoints[i] < 0) || (xPoints[i] > 900))
			{
				super.setOutBounds(true);
			}
			else
			{
				
				
				
				if ((yPoints[i] < 0) || (yPoints[i] >600))
				{
					super.setOutBounds(true);
				}
				else
				{
					 
					yPoints[i] += dx;
					xPoints[i] += dx;
				}
			}
			
		}
		if ((super.getOutBounds() == null) || (super.getOutBounds() != true))
			
		{
			super.setOutBounds(false);
		}
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}


}
