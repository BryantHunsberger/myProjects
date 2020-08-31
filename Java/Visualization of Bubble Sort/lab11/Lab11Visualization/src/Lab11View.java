import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Lab11View extends JComponent implements ActionListener {

    JFrame myFrame;
    private int height;
    private int width;
    private ArrayList<Integer> xArray = new ArrayList<Integer>();
    private ArrayList<Integer> yArray = new ArrayList<Integer>();
    private ArrayList<Integer> values = new ArrayList<Integer>();
    private boolean isCleared = false;

    javax.swing.Timer timer;

    public Lab11View(int height, int width)
    {
        this.height = height;
        this.width = width;
        myFrame = new JFrame();

        myFrame.add(this);
        myFrame.setSize(720, 1280);
        myFrame.setVisible(true);
    }

    public void drawPoint(int x, int y, int value)
    {
        xArray.add(x);
        yArray.add(y);
        values.add(value);
        isCleared = false;
    }

    public void clear()
    {
        xArray.clear();
        yArray.clear();
        values.clear();
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
        pGraphics.fillRect(0, 0, lWidth, lHeight);

        // set paint color for drawing, using the constructor with RGB int values:
        // https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html#Color(int,%20int,%20int)
        Color lForegroundColor = new Color(0, 0, 0);
        pGraphics.setColor(lForegroundColor);

        // just for testing purposes,
        // let's draw a diagonal line across the Graphics context:
        Color blackPix = Color.BLACK;
        Color greyPix = Color.gray;
        Color whitePix = Color.white;
        if (!isCleared) {

            pGraphics.setColor(Color.gray);
            lClipArea = pGraphics.getClip();
            lWidth = lClipArea.getBounds().width;
            lHeight = lClipArea.getBounds().height;
            pGraphics.fillRect(0, 0, lWidth, lHeight);

            for (int i = 0; i < xArray.size(); i++) {
                lForegroundColor = new Color(255, 0, 0);
                pGraphics.setColor(lForegroundColor);
                pGraphics.drawLine(i, 710, i, 710 - values.get(i));
            }
        } else {
            pGraphics.setColor(Color.BLACK);
            lClipArea = pGraphics.getClip();
            lWidth = lClipArea.getBounds().width;
            lHeight = lClipArea.getBounds().height;
            pGraphics.fillRect(0, 0, lWidth, lHeight);
        }
    }

    // end of paintComponent()

    public void actionPerformed(ActionEvent e) {

        // tell the JComponent that it ought to repaint itself:
        this.repaint();
    } // end of actionPerformed()

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

}
