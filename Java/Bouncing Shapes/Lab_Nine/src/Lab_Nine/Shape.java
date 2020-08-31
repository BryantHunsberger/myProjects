package Lab_Nine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

abstract class Shape {
	
	private Color fillColor;
	private Color borderColor;
	private Boolean isFilled;
	private Point Location;
	private Boolean outBounds;
	private int area;
	
	// the three constructors initialize the instance fields
	public Shape(Color fillColor, Color borderColor, int x, int y) 
	{
		this.fillColor = fillColor;
		this.borderColor = borderColor;
		Point currentPt = new Point(x,y);
		this.Location = currentPt;	
	}
	
	// set borderColor to Black since not provided
	public Shape(Color fillColor, int x, int y) 
	{
		this.fillColor = fillColor;
		Point currentPt = new Point(x,y);
		this.Location = currentPt;
		this.borderColor = Color.black;
		
	}
	
	// set fillColor to white and border color to black
	public Shape(int x, int y) 
	{
		Point currentPt = new Point(x,y);
		this.Location = currentPt;
		this.fillColor = Color.white;
		this.borderColor = Color.black;
	}
	
	// will fill the shape with some random image. You can select any image for larger shapes
	
	public void setFillColor(Color c) 
	{ 
		this.fillColor = c;
	}
	
	public Color getFillColor() 
	{
		return this.fillColor;
	}
	
	
	public void setBorderColor(Color c) 
	{ 
		this.borderColor = c;
	}
	
	public Color getBorderColor() 
	{ 
		return this.borderColor;
	}
	
	public void setLocation(Point pt) 
	{ 
		this.Location = pt;
	}
	
	public Point getLocation() 
	{ 
		return this.Location;
	}
	
	abstract void draw(Graphics g);
	
	// Note: subclasses of Shape do not inherent private members so we need methods the subclasses
	// can use to get the x and y values from the private Point instance field
    public int getX() 
    { 
    	
    	return (int) this.Location.getX();
    }
    
    public void setX(int x) 
    {
    	this.Location.setLocation(x, getY());
    }
    
	public int getY() 
	{ 
		return (int) this.Location.getY();
	}
	
	public void setY(int y) 
	{ 
		this.Location.setLocation(getX(), y);
	}
	
	// if fillColor is white returns true, else returns false
	public boolean isFilled() 
	{ 
		if (this.fillColor == Color.white)
		{
			return this.isFilled = true;
		}
		else
		{
			return this.isFilled = false;
		}
	}
	
	// moves location by dx and dy
	
	public abstract void moveLocation(int dx, int dy);
	
	
	abstract double getPerimeter();

	public Boolean getOutBounds() {
		return outBounds;
	}

	public void setOutBounds(Boolean outBounds) {
		this.outBounds = outBounds;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
}
