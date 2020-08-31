// C343 / Summer 2020
// Homework-04
// Bryant Hunsberger | bjhunsbe


import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.Timer;

public class HW04Controller implements Observer
{
    public static HW04Model newModel;
    public static HW04View newView;
    public static int[][] distanceTable;
    public static char[][] colorTable;
    int currentRowNum = 0;

    public static void main(String[] args)
    {
        newModel = new HW04Model(1200,715);
        newView = new HW04View(1200, 715);

        HW04Controller newControl = new HW04Controller();

        newModel.addObserver(newControl);

        newModel.confirmView();

        try {
            newModel.readFiles();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        newView.timer = new Timer(1000, newView);
        newView.timer.start();

        System.out.println("\nEdit Distance of Flatland Alternate Editions: " + newModel.dist(newModel.getStringOne(),
              newModel.getStringTwo()));

    }

    @Override
    public void update(Observable observable, Object o)
    {
        newView.clear();
        this.distanceTable = new int[currentRowNum + 1][newModel.getStringTwo().length() + 1];
        this.colorTable = new char[currentRowNum + 1][newModel.getStringTwo().length() + 1];

        for(int i = 0; i < currentRowNum + 1; i++)
        {
            distanceTable[i] = newModel.dLine(i);
            colorTable[i] = newModel.eLine(i);
            newView.getSecX().add(newModel.getCurrentRow() + 1);
            newView.getSecY().add(newModel.getCurrentVal() + 1);
        }

        for(int y = 1; y < newModel.getStringOne().length(); y++)
        {
            if((newModel.getStringOne().substring(y-1, y).equals("a")) ||
                    (newModel.getStringOne().substring(y-1, y).equals("e")) ||
                            (newModel.getStringOne().substring(y-1, y).equals("o")) ||
                                    (newModel.getStringOne().substring(y-1, y).equals("u")) ||
                                            (newModel.getStringOne().substring(y-1, y).equals("i")))
            {
                newView.drawPoint(y+1,0, 0,255,255);
            }
            else if((newModel.getStringOne().substring(y-1, y).equals(" ")) ||
                        (newModel.getStringOne().substring(y-1, y).equals(",")) ||
                             (newModel.getStringOne().substring(y-1, y).equals("''")))
            {
                newView.drawPoint(y+1,0, 255,255,255);
            }
            else
            {
                newView.drawPoint(y+1,0, 255,0,255);
            }

        }
        for(int z = 1; z < newModel.getStringTwo().length(); z++)
        {
            if((newModel.getStringTwo().substring(z-1, z).equals("a")) ||
                    (newModel.getStringTwo().substring(z-1, z).equals("e")) ||
                    (newModel.getStringTwo().substring(z-1, z).equals("o")) ||
                    (newModel.getStringTwo().substring(z-1, z).equals("u")) ||
                    (newModel.getStringTwo().substring(z-1, z).equals("i")))
            {
                newView.drawPoint(0,z+1, 0,255,255);
            }
            else if((newModel.getStringOne().substring(z-1, z).equals(" ")) ||
                    (newModel.getStringOne().substring(z-1, z).equals(",")) ||
                    (newModel.getStringOne().substring(z-1, z).equals("''")))
            {
                newView.drawPoint(0,z+1, 255,255,255);
            }
            else
            {
                newView.drawPoint(0,z+1, 255,0,255);
            }

        }
        for (int i = 0; i < colorTable.length; i++)
        {
            for (int j = 0; j < colorTable[0].length; j++)
            {
                if (colorTable[i][j] == ' ')
                {
                    newView.drawPoint(j+1, i + 1, 0, 255, 0);
                }
                else if (colorTable[i][j] == 'S')
                {
                    newView.drawPoint(j + 1, i + 1, 255, 255, 0);
                }
                else if (colorTable[i][j] == 'D')
                {
                    newView.drawPoint(j + 1, i + 1, 255, 0, 0);
                }
                else
                {
                    newView.drawPoint(j + 1, i + 1, 0, 0, 255);
                }
            }
        }

        this.currentRowNum += 1;
    }
}
