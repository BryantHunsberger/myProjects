// C343 / Summer 2020
// Homework-04
// Bryant Hunsberger | bjhunsbe


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Scanner;
import java.io.FileReader;

public class HW04Model extends Observable
{
    private int widthOfScreen;
    private int heightOfScreen;
    private File textOne;
    private File textTwo;
    private String stringOne;
    private String stringTwo;
    private Scanner scanOne;
    private Scanner scanTwo;

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentVal() {
        return currentVal;
    }

    private int currentRow;
    private int currentVal;

    public char[][] getE() {
        return e;
    }

    public void setE(char[][] e) {
        this.e = e;
    }

    private int[][] myTable;
    private char[][] e;

    public HW04Model(int width, int height)
    {
        this.widthOfScreen = width;
        this.heightOfScreen = height;
    }

    public void confirmView()
    {
        if (this.widthOfScreen > 1200)
        {
            System.out.println("\n\nWARNING: Array Width too large for viewing on this model!!!\n\n");
        }
        if (this.heightOfScreen > 715)
        {
            System.out.println("\n\nWARNING: Array Height too large for viewing on this model!!!\n\n");
        }
    }

    public void readFiles() throws FileNotFoundException
    {
        textOne = new File("C:\\Users\\bryant\\IdeaProjects\\Homework02\\lab10Mini\\src\\aFlatlands.txt");
        textTwo = new File("C:\\Users\\bryant\\IdeaProjects\\Homework02\\lab10Mini\\src\\nFlatlands.txt");

        scanOne = new Scanner(textOne);

        while(scanOne.hasNext())
        {
            this.stringOne += scanOne.next();
        }

        scanTwo = new Scanner(textTwo);

        while(scanTwo.hasNext())
        {
            this.stringTwo += scanTwo.next();
        }

    }

    public int dist(String s1, String s2)
    {
        myTable = new int[s1.length() + 1][s2.length() + 1];
        e = new char[s1.length() + 1][s2.length() + 1];

        int myEditDistance = 0;
        int cost = 0;

        myTable[0][0] = 0;

        for (int i = 1; i < s1.length() + 1; i++) {
            myTable[i][0] = i;
        }
        for (int j = 1; j < s2.length() + 1; j++) {
            myTable[0][j] = j;
        }

        for (int k = 1; k < myTable.length; k++) {
            for (int m = 1; m < myTable[0].length; m++) {
                if (s1.substring(k-1, k).equals(s2.substring(m - 1, m))) {
                    cost = 0;
                } else {
                    cost = 1;
                }
                myTable[k][m] = findMin(myTable[k - 1][m] + 1, myTable[k][m - 1] + 1, myTable[k - 1][m - 1] + cost, k, m, e);

                if (s1.substring(k-1, k).equals(s2.substring(m - 1, m))) {
                    e[k][m] = ' ';
                }
            }
            setChanged();
            notifyObservers();
        }
        myEditDistance = myTable[s1.length()][s2.length()];
        setChanged();
        notifyObservers();

        return myEditDistance;
    }

    public static int findMin(int one, int two, int three, int k, int m, char[][] e)
    {
        if ((one <= two ) && (one <= three))
        {
            e[k][m] = 'D';
            return one;
        }
        else if ((two <= one) && (two <= three))
        {
            e[k][m] = 'I';
            return two;
        }
        else
        {
            e[k][m] = 'S';
            return three;
        }

    }

    public int[] dLine(int i)
    {
        int[] currentRow = new int[myTable[0].length];

        int minimumVal = 1000;
        int index = 100;

        for(int b = 0; b < myTable[0].length; b++)
        {
            currentRow[b] = this.myTable[i][b];
            if (currentRow[b] <= minimumVal)
            {
                minimumVal = currentRow[b];
                index = b;
            }
        }
        this.currentRow = i;
        this.currentVal = index;

        return currentRow;
    }

    public char[] eLine(int i)
    {
        char[] currentRow = new char[e[0].length];

        for (int l = 0; l < e[0].length; l++)
        {
            currentRow[l] = this.e[i][l];
        }

        return currentRow;
    }

    public int getWidthOfScreen() {
        return widthOfScreen;
    }

    public String aString()
    {
        return this.stringOne;
    }

    public String bString()
    {
        return this.stringTwo;
    }

    public void setWidthOfScreen(int widthOfScreen) {
        this.widthOfScreen = widthOfScreen;
    }

    public int getHeightOfScreen() {
        return heightOfScreen;
    }

    public void setHeightOfScreen(int heightOfScreen) {
        this.heightOfScreen = heightOfScreen;
    }

    public void setStringOne(String stringOne) {
        this.stringOne = stringOne;
    }

    public void setStringTwo(String stringTwo) {
        this.stringTwo = stringTwo;
    }

    public String getStringOne() {
        return stringOne;
    }

    public String getStringTwo() {
        return stringTwo;
    }

    public int[][] getMyTable() {
        return myTable;
    }

    public void setMyTable(int[][] myTable) {
        this.myTable = myTable;
    }

}
