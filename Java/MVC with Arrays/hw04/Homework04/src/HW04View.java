// C343 / Summer 2020
// Homework-04
// Bryant Hunsberger | bjhunsbe


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class HW04View extends JComponent implements ActionListener
{
    private int height;
    private int width;
    private boolean isCleared = false;
    public static ArrayList<Integer> xVals = new ArrayList<Integer>();
    public static ArrayList<Integer> yVals = new ArrayList<Integer>();
    public static ArrayList<Integer> rVals = new ArrayList<Integer>();
    public static ArrayList<Integer> gVals = new ArrayList<Integer>();
    public static ArrayList<Integer> bVals = new ArrayList<Integer>();
    public static ArrayList<Integer> secX = new ArrayList<Integer>();

    public static ArrayList<Integer> getSecX() {
        return secX;
    }

    public static ArrayList<Integer> getSecY() {
        return secY;
    }

    public static ArrayList<Integer> secY = new ArrayList<Integer>();

    JFrame myFrame;
    javax.swing.Timer timer;

    public HW04View(int height, int width)
    {
        this.height = height;
        this.width = width;
        myFrame = new JFrame();

        myFrame.add(this);
        myFrame.setSize(this.height, this.width);
        myFrame.setVisible(true);
    }
    public void drawPoint(int x, int y, int r, int g, int b)
    {
        isCleared = false;
        this.xVals.add(x);
        this.yVals.add(y);
        this.rVals.add(r);
        this.gVals.add(g);
        this.bVals.add(b);
    }

    public void clear()
    {
        xVals.clear();
        yVals.clear();
        rVals.clear();
        gVals.clear();
        bVals.clear();
        secX.clear();
        secY.clear();
        isCleared = true;
    }
    public void paintComponent(Graphics pGraphics) {
        //
        // "The Graphics class is the abstract base class for all graphics contexts
        //   that allow an application to draw onto components that are realized on\
        //   various devices, as well as onto off-screen images."
        // https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
        super.paintComponent(pGraphics);

        // clear background at every re-painting:
        pGraphics.setColor(Color.gray);
        Shape lClipArea = pGraphics.getClip();
        int lWidth = lClipArea.getBounds().width;
        int lHeight = lClipArea.getBounds().height;
        pGraphics.fillRect(0,0,lWidth,lHeight);

        // set paint color for drawing, using the constructor with RGB int values:
        // https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html#Color(int,%20int,%20int)
        Color lForegroundColor = new Color(127,127,127);
        //pGraphics.setColor(lForegroundColor);

        if (!isCleared) {

            pGraphics.setColor(lForegroundColor);
            lClipArea = pGraphics.getClip();
            lWidth = lClipArea.getBounds().width;
            lHeight = lClipArea.getBounds().height;
            pGraphics.fillRect(0,0,lWidth,lHeight);

            for (int i = 0; i < xVals.size() - 1; i++)
            {
                /*
                if (rVals.get(i) > 255)
                {
                    rVals.set(i,255);
                }
                else if (rVals.get(i) < 0)
                {
                    rVals.set(i,0);
                }
                if (gVals.get(i) > 255)
                {
                    gVals.set(i,255);
                }
                else if (gVals.get(i) < 0)
                {
                    gVals.set(i,0);
                }
                if (bVals.get(i) > 255)
                {
                    bVals.set(i,255);
                }
                else if (bVals.get(i) < 0)
                {
                    bVals.set(i,0);
                } */
                lForegroundColor = new Color(rVals.get(i), gVals.get(i), bVals.get(i));
                pGraphics.setColor(lForegroundColor);
                pGraphics.drawRect(xVals.get(i), yVals.get(i), 1, 1);
            }
            for (int i = 0; i < secX.size() - 1; i++)
            {
                lForegroundColor = new Color(0, 0, 0);
                pGraphics.setColor(lForegroundColor);
                pGraphics.drawRect(secX.get(i), secY.get(i), 3, 3);
            }
        }
        else
        {
            lForegroundColor = new Color(127,127,127);
            pGraphics.setColor(lForegroundColor);
            lClipArea = pGraphics.getClip();
            lWidth = lClipArea.getBounds().width;
            lHeight = lClipArea.getBounds().height;
            pGraphics.fillRect(0,0,lWidth,lHeight);
        }

    }

    public void actionPerformed(ActionEvent e) {

        // tell the JComponent that it ought to repaint itself:
        this.repaint();
    } // end of actionPerformed()
}
