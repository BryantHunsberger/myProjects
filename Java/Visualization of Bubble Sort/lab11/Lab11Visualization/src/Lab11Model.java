import java.util.Random;
import java.util.Observable;

import static java.lang.Thread.sleep;

public class Lab11Model extends Observable
{
    private int width;
    private int[] myArray;

    public Lab11Model(int width)
    {
        this.width = width;
        this.myArray = new int[this.width];
    }

    public Lab11Model(){}

    public int[] getArray()
    {
        return this.myArray;
    }

    public void randomize(int valRange)
    {
        Random myRand = new Random();

        System.out.println("\nBefore Bubble Sort\n");
        for(int i = 0; i < this.myArray.length; i++)
        {
            int myVal = (myRand.nextInt(valRange) + 1);

            this.myArray[i] = myVal;
            System.out.print(this.myArray[i] + ",");
        }
    }

    // I will be using the bubble sort algorithm here
    public void sortArray()
    {
        int length = this.myArray.length;

        for (int j = length; j > 0; j--) {
            for (int k = 1; k < j; k++) {
                if (this.myArray[k - 1] > this.myArray[k]) {
                    int valOne = this.myArray[k - 1];
                    int valTwo = this.myArray[k];

                    this.myArray[k - 1] = valTwo;
                    this.myArray[k] = valOne;
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setChanged();
            notifyObservers();
        }

        System.out.println("\n\nAfter Bubble Sort\n");
        for (int i = 0; i < this.myArray.length; i++) {
            System.out.print(this.myArray[i] + ",");
        }

    }


}
