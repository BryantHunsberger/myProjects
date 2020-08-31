import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

// This visualizes my sorting array on the same JFrame, it takes a few minutes, but it functions!

public class Lab11Controller implements Observer
{
    JFrame myFrame;
    private int[] theArray;
    private static Lab11View firstView  = new Lab11View(720,1280);;
    private static Lab11Model firstModel;

    public static void main(String[] args)
    {
        firstModel = new Lab11Model(1200);
        Lab11Controller newControl = new Lab11Controller();

        firstModel.addObserver(newControl);
        // Unsorted Random Array
        ///////////////////////////////////////////////////////////////////////////////////////////////
        firstModel.randomize(720);

        // Sorted Random Array - Columns then Rows
        ///////////////////////////////////////////////////////////////////////////////////////////////
        firstModel.sortArray();


    }

    @Override
    public void update(Observable observable, Object o)
    {
        firstView.clear();
        this.theArray = firstModel.getArray();

        firstView.timer = new Timer(1000, firstView);
        firstView.timer.start();

        for(int i = 0; i < theArray.length; i++)
        {
            firstView.drawPoint(i,710, theArray[i]);
        }
    }
}
