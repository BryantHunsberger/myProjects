package Lab_Nine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class ShapeDriver extends JPanel implements ActionListener, KeyListener 
{
	public final int FRAME_WIDTH = 600;    
	public final int FRAME_HEIGHT = 600;
	static ArrayList<Shape> myCurrentShapes = new ArrayList<Shape>();
	static ArrayList<Shape> circSquares = new ArrayList<Shape>();
	Color[] myColors = {Color.black, Color.blue, Color.green, Color.red, Color.orange, Color.pink};
	ActionListener listener;
	Timer time;
	int circleTrack = 0;
	int squareTrack = 0;
	int hexagonTrack = 0;
	int ovalTrack = 0;
	int pentagonTrack = 0;
	int polygonTrack = 0;
	int quadTrack = 0;
	int rectTrack = 0;
	int triangleTrack = 0;
	
	String[] possibleShapes = {"Circle", "Hexagon", "Oval", "Pentagon", "Polygon", "Quadrilateral", "Rectangle", "Square", "Triangle"};
	
	public ShapeDriver() {        
		listener = this;
		time = new Timer(50, listener);
		time.start();         

	}   
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//myCurrentShapes.add(new Circle(Color.black, Color.black, 40, 50, 50));
		 
		for (int i = 0; i < myCurrentShapes.size(); i++)
		{
			myCurrentShapes.get(i).draw(g);
		}
	
		 

	}
 
	@Override
	public void keyPressed(KeyEvent e) {
		if ((e.getKeyChar() == 'H') || (e.getKeyChar() == 'h'))
		{
			Random rand = new Random(); 
			int nextShape = rand.nextInt(9);
			String newShape = possibleShapes[nextShape];	
			
			if (newShape == "Circle")
			{
				Random fillPick = new Random();
				Random borderPick = new Random();
				int currentFill = fillPick.nextInt(5);
				int currentBorder = borderPick.nextInt(5);
				Random xLoc = new Random();
				Random yLoc = new Random();
				int xLocation = xLoc.nextInt(900);
				int yLocation = yLoc.nextInt(600);
				Random heightPick = new Random();
				int circHeight = heightPick.nextInt(400) + 1;
				
				//ArrayList<Circle> myCircs = new ArrayList<Circle>(100);
				myCurrentShapes.add(new Circle(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, circHeight));
				circSquares.add(myCurrentShapes.get(myCurrentShapes.size() - 1));
				//circleTrack += 1;
	
				
			}
			else if (newShape == "Hexagon")
			{
				Random fillPick = new Random();
				Random borderPick = new Random();
				int currentFill = fillPick.nextInt(5);
				int currentBorder = borderPick.nextInt(5);
				Random xLoc = new Random();
				Random yLoc = new Random();
				int xLocation = xLoc.nextInt(900);
				int yLocation = yLoc.nextInt(600);
				final int NUMPOINTS = 6;
				int track = 0;
				int[] xPoint = new int[NUMPOINTS];
				int[] yPoint = new int[NUMPOINTS];
				while (track < NUMPOINTS)
				{
					Random xPick = new Random();
					Random yPick = new Random();
					int xPickNum = xPick.nextInt(900);
					int yPickNum = yPick.nextInt(600);
					xPoint[track] = xPickNum;
					yPoint[track] = yPickNum;
					track += 1;
				}
				
				//ArrayList<Hexagon> myHex = new ArrayList<Hexagon>(100);
				//myHex.set(hexagonTrack, new Hexagon(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, xPoint, yPoint));
				myCurrentShapes.add(new Hexagon(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, xPoint, yPoint));
				//hexagonTrack += 1;
		
		
				
			}
			else if (newShape == "Oval")
			{
				Random xLoc = new Random();
				Random yLoc = new Random();
				int xLocation = xLoc.nextInt(900);
				int yLocation = yLoc.nextInt(600);
				Random fillPick = new Random();
				Random borderPick = new Random();
				int currentFill = fillPick.nextInt(5);
				int currentBorder = borderPick.nextInt(5);
				Random heightPick = new Random();
				int ovalHeight = heightPick.nextInt(400) + 1;
				Random widthPick = new Random();
				int ovalWidth = widthPick.nextInt(400) + 1;
				
				//ArrayList<Oval> myOvals = new ArrayList<Oval>(100);
				//myOvals.set(ovalTrack, new Oval(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, ovalHeight, ovalWidth));
				myCurrentShapes.add(new Oval(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, ovalHeight, ovalWidth));
				//ovalTrack += 1;
			
				
				
			}
			else if (newShape == "Pentagon")
			{
				Random fillPick = new Random();
				Random borderPick = new Random();
				int currentFill = fillPick.nextInt(5);
				int currentBorder = borderPick.nextInt(5);
				Random xLoc = new Random();
				Random yLoc = new Random();
				int xLocation = xLoc.nextInt(900);
				int yLocation = yLoc.nextInt(600);
				final int NUMPOINTS = 5;
				int track = 0;
				int[] xPoint = new int[NUMPOINTS];
				int[] yPoint = new int[NUMPOINTS];
				while (track < NUMPOINTS)
				{
					Random xPick = new Random();
					Random yPick = new Random();
					int xPickNum = xPick.nextInt(900);
					int yPickNum = yPick.nextInt(600);
					xPoint[track] = xPickNum;
					yPoint[track] = yPickNum;
					track += 1;
				}
				
				//ArrayList<Pentagon> myPents = new ArrayList<Pentagon>(100);
				//myPents.set(pentagonTrack, new Pentagon(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, xPoint, yPoint));
				myCurrentShapes.add(new Pentagon(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, xPoint, yPoint));
				//pentagonTrack += 1;
			
			
			}
			else if (newShape == "Polygon")
			{
				Random fillPick = new Random();
				Random borderPick = new Random();
				int currentFill = fillPick.nextInt(5);
				int currentBorder = borderPick.nextInt(5);
				Random xLoc = new Random();
				Random yLoc = new Random();
				int xLocation = xLoc.nextInt(900);
				int yLocation = yLoc.nextInt(600);
				Random pointNum = new Random();
				int numPoints = pointNum.nextInt(7) + 1;
				int track = 0;
				int[] xPoint = new int[numPoints];
				int[] yPoint = new int[numPoints];
				while (track < numPoints)
				{
					Random xPick = new Random();
					Random yPick = new Random();
					int xPickNum = xPick.nextInt(500);
					int yPickNum = yPick.nextInt(300);
					xPoint[track] = xPickNum;
					yPoint[track] = yPickNum;
					track += 1;
				}
				
				//ArrayList<Polygon> myPoly = new ArrayList<Polygon>(100);
			//	myPoly.set(polygonTrack, new Polygon(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, xPoint, yPoint, numPoints));
				myCurrentShapes.add(new Polygon(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, xPoint, yPoint, numPoints));
				//polygonTrack += 1;
			
				
			}
			else if (newShape == "Quadrilateral")
			{
				Random fillPick = new Random();
				Random borderPick = new Random();
				int currentFill = fillPick.nextInt(5);
				int currentBorder = borderPick.nextInt(5);
				Random xLoc = new Random();
				Random yLoc = new Random();
				int xLocation = xLoc.nextInt(900);
				int yLocation = yLoc.nextInt(600);
				final int NUMPOINTS = 4;
				int track = 0;
				int[] xPoint = new int[NUMPOINTS];
				int[] yPoint = new int[NUMPOINTS];
				while (track < NUMPOINTS)
				{
					Random xPick = new Random();
					Random yPick = new Random();
					int xPickNum = xPick.nextInt(900);
					int yPickNum = yPick.nextInt(600);
					xPoint[track] = xPickNum;
					yPoint[track] = yPickNum;
					track += 1;
				}
				
				
				//ArrayList<Quadrilateral> myQuads = new ArrayList<Quadrilateral>(100);
			//	myQuads.set(quadTrack, new Quadrilateral(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, xPoint, yPoint));
				myCurrentShapes.add(new Quadrilateral(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, xPoint, yPoint));
				//quadTrack += 1;
		
				
			}
			else if (newShape == "Rectangle")
			{
				Random fillPick = new Random();
				Random borderPick = new Random();
				int currentFill = fillPick.nextInt(5);
				int currentBorder = borderPick.nextInt(5);
				Random xLoc = new Random();
				Random yLoc = new Random();
				int xLocation = xLoc.nextInt(900);
				int yLocation = yLoc.nextInt(600);
				Random heightPick = new Random();
				int rectHeight = heightPick.nextInt(500) + 1;
				Random widthPick = new Random();
				int rectWidth = widthPick.nextInt(500) + 1;
				
				
				//ArrayList<Rectangle> myRects = new ArrayList<Rectangle>(100);
			//	myRects.set(rectTrack, new Rectangle(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, rectHeight, rectWidth));
				myCurrentShapes.add(new Rectangle(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, rectHeight, rectWidth));
				//rectTrack += 1;
			
		
			}
			else if (newShape == "Square")
			{
				Random fillPick = new Random();
				Random borderPick = new Random();
				int currentFill = fillPick.nextInt(5);
				int currentBorder = borderPick.nextInt(5);
				Random xLoc = new Random();
				Random yLoc = new Random();
				int xLocation = xLoc.nextInt(900);
				int yLocation = yLoc.nextInt(600);
				Random heightPick = new Random();
				int squareHeight = heightPick.nextInt(400) + 1;
				
				//ArrayList<Square> mySquares = new ArrayList<Square>(100);
				//mySquares.set(squareTrack, new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, squareHeight));
				myCurrentShapes.add(new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, squareHeight));
				circSquares.add(myCurrentShapes.get(myCurrentShapes.size() - 1));
				//squareTrack += 1;
			
		
			}
			else if (newShape == "Triangle")
			{
				Random fillPick = new Random();
				Random borderPick = new Random();
				int currentFill = fillPick.nextInt(5);
				int currentBorder = borderPick.nextInt(5);
				Random xLoc = new Random();
				Random yLoc = new Random();
				int xLocation = xLoc.nextInt(900);
				int yLocation = yLoc.nextInt(600);
				final int NUMPOINTS = 3;
				int track = 0;
				int[] xPoint = new int[NUMPOINTS];
				int[] yPoint = new int[NUMPOINTS];
				while (track < NUMPOINTS)
				{
					Random xPick = new Random();
					Random yPick = new Random();
					int xPickNum = xPick.nextInt(800);
					int yPickNum = yPick.nextInt(500);
					xPoint[track] = xPickNum;
					yPoint[track] = yPickNum;
					track += 1;
				}
				
				
				//ArrayList<Triangle> myTri = new ArrayList<Triangle>(100);
				//myTri.set(triangleTrack, new Triangle(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, xPoint, yPoint));
				myCurrentShapes.add(new Triangle(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, xPoint, yPoint));
				//triangleTrack += 1;
			
				
			}
			
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 
		this.repaint();
		int nextXMove = 0;
		int nextYMove = 0;
		for (int i = 0; i < myCurrentShapes.size(); i++)
		{
			if (i % 2 == 0)
			{
				nextXMove = -1;
				nextYMove = -1;
			}
			else if (i % 2 == 1)
			{
				
				nextXMove = 1;
				
				nextYMove = 1;
			}
			if (i % 3 == 0)
			{
				nextXMove *= 2;
				nextYMove *= 2;
			}
			else if (i % 7 == 0)
			{
				nextXMove *= 3;
				nextYMove *= 3;
			}
		 
			myCurrentShapes.get(i).moveLocation(nextXMove, nextYMove);
			if (myCurrentShapes.get(i).getOutBounds())
			{
				myCurrentShapes.remove(myCurrentShapes.get(i));
			}
		for (int j = 0; j < circSquares.size(); j++)
		{
			for (int k = 0; k < circSquares.size(); k++)
			{
				int currentXmin = circSquares.get(j).getX();
				int currentXmax = circSquares.get(j).getX() + circSquares.get(j).getWidth();
				int currentYmin = circSquares.get(j).getX();
				int currentYmax = circSquares.get(j).getX() + circSquares.get(j).getHeight();
				
				if (((circSquares.get(k).getX() >= currentXmin) || (circSquares.get(k).getX() <= currentXmax)) && ((circSquares.get(k).getY() >= currentYmin) || (circSquares.get(k).getY() <= currentXmin)))
				{
					if (circSquares.get(k).getBorderColor() == circSquares.get(j).getBorderColor())
					{
						if (circSquares.get(k).getArea() <= circSquares.get(j).getArea())
						{
							Random fillPick = new Random();
							Random borderPick = new Random();
							int currentFill = fillPick.nextInt(5);
							int currentBorder = borderPick.nextInt(5);
							Random xLoc = new Random();
							Random yLoc = new Random();
							int xLocation = xLoc.nextInt(900);
							int yLocation = yLoc.nextInt(600);
							Random heightPick = new Random();
							int squareHeight = heightPick.nextInt(300) + 1;
							
							//ArrayList<Square> mySquares = new ArrayList<Square>(100);
							
							//mySquares.set(squareTrack, new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, squareHeight));
							myCurrentShapes.add(new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, (int) (Math.sqrt(circSquares.get(k).getArea() * 2))));
							circSquares.add(myCurrentShapes.get(myCurrentShapes.size() - 1));
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
							
								myCurrentShapes.remove(circSquares.get(k));
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(j));
							}
						}
						else
						{
							Random fillPick = new Random();
							Random borderPick = new Random();
							int currentFill = fillPick.nextInt(5);
							int currentBorder = borderPick.nextInt(5);
							Random xLoc = new Random();
							Random yLoc = new Random();
							int xLocation = xLoc.nextInt(900);
							int yLocation = yLoc.nextInt(600);
							Random heightPick = new Random();
							int squareHeight = heightPick.nextInt(300) + 1;
							
							//ArrayList<Square> mySquares = new ArrayList<Square>(100);
							//mySquares.set(squareTrack, new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, squareHeight));
							myCurrentShapes.add(new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, (int) (Math.sqrt(circSquares.get(j).getArea() * 2))));
							circSquares.add(myCurrentShapes.get(myCurrentShapes.size() - 1));
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
							
								myCurrentShapes.remove(circSquares.get(k));
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(j));
							}
						}
					}
					else
					{
						if (circSquares.get(k).getArea() <= circSquares.get(j).getArea())
						{
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
								myCurrentShapes.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(k));
							}
						
						}
						else
						{
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(j));
							}
						}
					}
				}
				else if ((((circSquares.get(k).getX() + circSquares.get(k).getWidth()) >= currentXmin) || ((circSquares.get(k).getX() + circSquares.get(k).getWidth()) <= currentXmax)) && ((circSquares.get(k).getY() >= currentYmin) || (circSquares.get(k).getY() <= currentXmin)))
				{
					if (circSquares.get(k).getBorderColor() == circSquares.get(j).getBorderColor())
					{
						if (circSquares.get(k).getArea() <= circSquares.get(j).getArea())
						{
							Random fillPick = new Random();
							Random borderPick = new Random();
							int currentFill = fillPick.nextInt(5);
							int currentBorder = borderPick.nextInt(5);
							Random xLoc = new Random();
							Random yLoc = new Random();
							int xLocation = xLoc.nextInt(900);
							int yLocation = yLoc.nextInt(600);
							Random heightPick = new Random();
							int squareHeight = heightPick.nextInt(300) + 1;
							
							//ArrayList<Square> mySquares = new ArrayList<Square>(100);
							//mySquares.set(squareTrack, new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, squareHeight));
							myCurrentShapes.add(new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, (int) (Math.sqrt(circSquares.get(k).getArea() * 2))));
							circSquares.add(myCurrentShapes.get(myCurrentShapes.size() - 1));
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
							
								myCurrentShapes.remove(circSquares.get(k));
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(j));
							}
						}
						else
						{
							Random fillPick = new Random();
							Random borderPick = new Random();
							int currentFill = fillPick.nextInt(5);
							int currentBorder = borderPick.nextInt(5);
							Random xLoc = new Random();
							Random yLoc = new Random();
							int xLocation = xLoc.nextInt(900);
							int yLocation = yLoc.nextInt(600);
							Random heightPick = new Random();
							int squareHeight = heightPick.nextInt(300) + 1;
							
							//ArrayList<Square> mySquares = new ArrayList<Square>(100);
							//mySquares.set(squareTrack, new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, squareHeight));
							myCurrentShapes.add(new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, (int) (Math.sqrt(circSquares.get(j).getArea() * 2))));
							circSquares.add(myCurrentShapes.get(myCurrentShapes.size() - 1));
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
							
								myCurrentShapes.remove(circSquares.get(k));
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(j));
							}
						}
					}
					else
					{
						if (circSquares.get(k).getArea() <= circSquares.get(j).getArea())
						{
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
								myCurrentShapes.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(k));
							}
						
						}
						else
						{
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(j));
							}
						}
					}
				}
				else if ((((circSquares.get(k).getX()+ circSquares.get(k).getWidth()) >= currentXmin) || ((circSquares.get(k).getX() + circSquares.get(k).getWidth()) <= currentXmax)) && (((circSquares.get(k).getY() + circSquares.get(k).getHeight()) >= currentYmin) || ((circSquares.get(k).getY() + circSquares.get(k).getHeight()) <= currentXmin)))
				{
					if (circSquares.get(k).getBorderColor() == circSquares.get(j).getBorderColor())
					{
						if (circSquares.get(k).getArea() <= circSquares.get(j).getArea())
						{
							Random fillPick = new Random();
							Random borderPick = new Random();
							int currentFill = fillPick.nextInt(5);
							int currentBorder = borderPick.nextInt(5);
							Random xLoc = new Random();
							Random yLoc = new Random();
							int xLocation = xLoc.nextInt(900);
							int yLocation = yLoc.nextInt(600);
							Random heightPick = new Random();
							int squareHeight = heightPick.nextInt(300) + 1;
							
							//ArrayList<Square> mySquares = new ArrayList<Square>(100);
							//mySquares.set(squareTrack, new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, squareHeight));
							myCurrentShapes.add(new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, (int) (Math.sqrt(circSquares.get(k).getArea() * 2))));
							circSquares.add(myCurrentShapes.get(myCurrentShapes.size() - 1));
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
							
								myCurrentShapes.remove(circSquares.get(k));
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(j));
							}
						}
						else
						{
							Random fillPick = new Random();
							Random borderPick = new Random();
							int currentFill = fillPick.nextInt(5);
							int currentBorder = borderPick.nextInt(5);
							Random xLoc = new Random();
							Random yLoc = new Random();
							int xLocation = xLoc.nextInt(900);
							int yLocation = yLoc.nextInt(600);
							Random heightPick = new Random();
							int squareHeight = heightPick.nextInt(300) + 1;
							
							//ArrayList<Square> mySquares = new ArrayList<Square>(100);
							//mySquares.set(squareTrack, new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, squareHeight));
							myCurrentShapes.add(new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, (int) (Math.sqrt(circSquares.get(j).getArea() * 2))));
							circSquares.add(myCurrentShapes.get(myCurrentShapes.size() - 1));
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
							
								myCurrentShapes.remove(circSquares.get(k));
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(j));
							}
						}
					}
					else
					{
						if (circSquares.get(k).getArea() <= circSquares.get(j).getArea())
						{
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
								myCurrentShapes.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(k));
							}
						
						}
						else
						{
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(j));
							}
						}
					}
				}
				else if (((circSquares.get(k).getX() >= currentXmin) || (circSquares.get(k).getX() <= currentXmax)) && (((circSquares.get(k).getY() + circSquares.get(k).getHeight()) >= currentYmin) || ((circSquares.get(k).getY() + circSquares.get(k).getHeight()) <= currentXmin)))
				{
					if (circSquares.get(k).getBorderColor() == circSquares.get(j).getBorderColor())
					{
						if (circSquares.get(k).getArea() <= circSquares.get(j).getArea())
						{
							Random fillPick = new Random();
							Random borderPick = new Random();
							int currentFill = fillPick.nextInt(5);
							int currentBorder = borderPick.nextInt(5);
							Random xLoc = new Random();
							Random yLoc = new Random();
							int xLocation = xLoc.nextInt(900);
							int yLocation = yLoc.nextInt(600);
							Random heightPick = new Random();
							int squareHeight = heightPick.nextInt(300) + 1;
							
							//ArrayList<Square> mySquares = new ArrayList<Square>(100);
							//mySquares.set(squareTrack, new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, squareHeight));
							myCurrentShapes.add(new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, (int) (Math.sqrt(circSquares.get(k).getArea() * 2))));
							circSquares.add(myCurrentShapes.get(myCurrentShapes.size() - 1));
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
							
								myCurrentShapes.remove(circSquares.get(k));
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(j));
							}
						}
						else
						{
							Random fillPick = new Random();
							Random borderPick = new Random();
							int currentFill = fillPick.nextInt(5);
							int currentBorder = borderPick.nextInt(5);
							Random xLoc = new Random();
							Random yLoc = new Random();
							int xLocation = xLoc.nextInt(900);
							int yLocation = yLoc.nextInt(600);
							Random heightPick = new Random();
							int squareHeight = heightPick.nextInt(300) + 1;
							
							//ArrayList<Square> mySquares = new ArrayList<Square>(100);
							//mySquares.set(squareTrack, new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, squareHeight));
							myCurrentShapes.add(new Square(myColors[currentFill], myColors[currentBorder], xLocation, yLocation, (int) (Math.sqrt(circSquares.get(j).getArea() * 2))));
							circSquares.add(myCurrentShapes.get(myCurrentShapes.size() - 1));
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
							
								myCurrentShapes.remove(circSquares.get(k));
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(j));
							}
						}
					}
					else
					{
						if (circSquares.get(k).getArea() <= circSquares.get(j).getArea())
						{
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
								myCurrentShapes.remove(circSquares.get(k));
								circSquares.remove(circSquares.get(k));
							}
						
						}
						else
						{
							if (circSquares.get(j).equals(circSquares.get(k)))
							{
								int x = 0;
							}
							else
							{
								myCurrentShapes.remove(circSquares.get(j));
								circSquares.remove(circSquares.get(j));
							}
						}
					}
				}
			}
		}
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		 
	}
 
}
