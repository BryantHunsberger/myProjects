package Lab_Nine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {


	private int width;
	private int height;
	private double area;
	private Point center;
	
	public Rectangle(Color fillColor, Color borderColor, int x, int y, int width, int height) {
		
		super(fillColor, borderColor, x, y);
		
		this.width = width;
		
		this.height = height;	
		
		this.setArea((width * height));
		
		Point currentPt = new Point(x + (width/2),y + (height / 2));
		this.setCenter(currentPt);	
	}
	
	public Rectangle(Color fillColor, Color borderColor, int x, int y, int width) {
		
		super(fillColor, borderColor, x, y);
		
		this.width = width;
			
		this.height = width;
	}

	@Override
	void draw(Graphics g) 
	{
		
		g.setColor(super.getBorderColor());
		g.fillRect(super.getX(), super.getY(), width, height);

	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return ((width * 2) + (height * 2));
	}

	@Override
	public void moveLocation(int dx, int dy) {
		if ((super.getX() < 0) || (super.getX() + width > 900))
		{
			super.setOutBounds(true);
		}
		else
		{
			
			super.setX(dx + super.getX());
			
			if ((super.getY() < 0) || (super.getY() + height >600))
			{
				super.setOutBounds(true);
			}
			else
			{
				 
				super.setY(dy + super.getY());
			}
		}
		if ((super.getOutBounds() == null) || (super.getOutBounds() != true))
			
		{
			super.setOutBounds(false);
		}
	}


	public void getArea(double area) {
		this.area = area;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
}
