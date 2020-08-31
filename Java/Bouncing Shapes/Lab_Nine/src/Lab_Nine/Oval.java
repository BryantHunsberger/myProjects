package Lab_Nine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Shape {

	private int height;
	private int width;
	private double area;
	private Point center;
	
	public Oval(Color fillColor, Color borderColor, int x, int y, int height, int width) 
	{
		super(fillColor, borderColor, x, y);

		this.height = height;
		
		this.width = width;
		
		this.setArea(((Math.PI) * Math.pow(width/2, 2)));
		
		Point currentPt = new Point(x + (width/2),y + (height / 2));
		this.setCenter(currentPt);
	}

	public Oval(Color fillColor, Color borderColor, int x, int y, int height) 
	{
		super(fillColor, borderColor, x, y);
		
		this.height = height;
		
		this.width = height;
	}

	@Override
	void draw(Graphics g) 
	{
		// TODO Auto-generated method stub
		g.setColor(super.getFillColor());
		g.fillOval(super.getX(), super.getY(), width, height);
		
	}
		

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moveLocation(int dx, int dy) {
		if (((super.getX()  < 0) || ((super.getX() + width) > 900)))
		{
			super.setOutBounds(true);
		}
		else
		{
			
			
			
			if ((super.getY()  < 0) || ((super.getY() + (height)) >600))
			{
				super.setOutBounds(true);
			}
			else
			{
				 
				super.setY(dx + super.getY());
				super.setX(dx + super.getX());
			}
		}
		if ((super.getOutBounds() == null) || (super.getOutBounds() != true))
			
		{
			super.setOutBounds(false);
		}
		
		
	}

	public int getArea() {
		return (int) area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
	

}
