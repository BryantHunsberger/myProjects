package Lab_Nine;

import java.awt.Color;
import java.awt.Graphics;

public class Polygon extends Shape {

	private int[] xPoints;
	private int[] yPoints;
	private int totalPoints;
	private int area = -1;
	
	public Polygon(Color fillColor, Color borderColor, int x, int y, int[] xP, int[] yP, int points) 
	{
		
		super(fillColor, borderColor, x, y);
		
		this.xPoints = xP;
		
		this.yPoints = yP;
		
		this.totalPoints = points;
	
	}
	
	public Polygon(Color fillColor, Color borderColor, int x, int y, int[] xP, int[] yP) 
	{
		
		super(fillColor, borderColor, x, y);
		
		this.xPoints = xP;
		
		this.yPoints = yP;

	
	}
	

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	@Override
	void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(super.getFillColor());
		g.fillPolygon(xPoints, yPoints, totalPoints);
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moveLocation(int dx, int dy) {
		for(int i = 0; i < totalPoints; i++)
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
					 
					xPoints[i] += dx;
					yPoints[i] += dx;
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
