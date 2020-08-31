package Lab_Nine;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Lab_Nine.ShapeDriver;

/*	
C212 - Lab 9 - Bouncing Shapes
Version: 13.0.2
@Author  Bryant Hunsberger | bjhunsbe
Last Edited: 4/2/2020
*/

public class ShapeWindow extends JFrame {

	JPanel newPan;
	
	public ShapeWindow()
	{
		super();
		this.setSize(900,600);	
		this.setTitle("Our Shape Generator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		ShapeDriver newDrive = new ShapeDriver();
		newPan = newDrive;
		this.getContentPane().add(newPan);
 
		newPan.setBackground(Color.cyan);
		
		KeyListener key = newDrive;
		newPan.addKeyListener(key);
		newPan.setFocusable(true);
		newPan.requestFocus();
	}
	public static void main(String[] args) {       
		// Create a JFrame and invoke the constructor  
		
		JFrame shapeWindow = new ShapeWindow();
		
		
	}
}

