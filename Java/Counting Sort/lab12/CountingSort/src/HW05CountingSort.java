// Date: 7/17/2020 - 11:23a.m.
// Creator: Bryant Hunsberger | bjhunsbe
// Class: C343 - Summer
// Assignment: Lab-12 - Counting Sort

import java.util.Random;

// This class performs counting sort, counting sort takes an array of unsorted elements, creates
// an intermediate array as a table, and then creates a third array to sort the values from
// the first array guided by the intermediate array.
public class HW05CountingSort
{

    public static void main(String[] args)
    {
        Random randomGenerator = new Random(); // This is our random generator
        int[] arrayA = new int[20]; // This is arrayA, which is the unsorted array

        for(int i = 0; i < arrayA.length; i++) // We are going through i values up to the length of array A
        {
            arrayA[i] = randomGenerator.nextInt(50) + 1; // We are randomizing the elements in arrayA (0-->50)
        }

        int[] arrayC = countingSort(arrayA); // I am sending the arrayA into the countingSort method
                                            // This also assigns the value returned to arrayC
        System.out.println("\nArrayA: ");
        for(int d = 0; d < arrayA.length; d++) // We are cycling through d elements of A
        {
            if (d != arrayA.length - 1) // Here I am checking for the last element in arrayA
            {
                System.out.print(arrayA[d] + ", "); // Adding commas for any element not last
            }
            else
            {
                System.out.print(arrayA[d]); // Printing element without comma
            }

        }

        System.out.println("\nArrayC: ");
        for(int i = 0; i < arrayC.length; i++) // I am cycling through i elements of array C
        {
            if (i != arrayA.length - 1) // Checking for the last element in C
            {
                System.out.print(arrayC[i] + ", "); // Commas for all elements that aren't i-1
            }
            else
            {
                System.out.print(arrayC[i]); // last i element gets no comma
            }
        }

    }

    // This method takes an unsorted array @param myArray, and sorts it.
    // @return int[]
    public static int[] countingSort(int[] arrayA)
    {
        int[] arrayC = new int[arrayA.length]; // This is array C, has the same length as arrayA
        int maximumValueInArrayA = -1; // We will record the maximum element in A here

        for(int i = 0; i < arrayA.length; i++) // We are cycling through i elements of arrayA
        {
            if (arrayA[i] >= maximumValueInArrayA) // If an element is greater than the value stored in max
            {
                maximumValueInArrayA = arrayA[i]; // We set the max equal to the new value
            }
        }

        System.out.println("\nThe maximum value in arrayA is: " + maximumValueInArrayA); //Printing max value

        int[] arrayB = new int[maximumValueInArrayA + 1]; // We declare/initialize intermediate array

        for(int k = 0; k < arrayB.length; k++) // Cycle through k arrayB elements
        {
            arrayB[k] = 0; // We are setting all indices of arrayB equal to 0
        }

        for(int j = 0; j < arrayA.length; j++) // We are cycling through j arrayA elements
        {
            arrayB[arrayA[j]] += 1; // We are setting the arrayB indice of the arrayA value + 1 each time
            arrayC[j] = -1; // Setting all arrayC values equal to -1
        }

        for(int x = 0; x < arrayB.length; x++) // Cycling through x arrayB elements
        {
            if (x != arrayB.length - 1) // As long as we are not on the last arrayB indice
            {
                arrayB[x+1] = (arrayB[x] + arrayB[x+1]); // Setting future element equal to future element + current
            }
        }

        for(int z = arrayA.length - 1; z >=0; z--) // Starting from the last index of array A
        {
            int incrementer = 1; // This is used if we have multiple similar elements, sets the new index place
            boolean checker = false; // We check if arrayC value is -1 or not
            if (arrayC[arrayB[arrayA[z]] - 1] == -1) // If arrayC value is -1, then we can input the new value
            {
                arrayC[arrayB[arrayA[z]] - 1] = arrayA[z]; // the new value is:
            }                               // the value of arrayA zth index, as the arrayB index, as the value for
            else                                   // the index of arrayC
            {
                while (!checker) // Check for -1
                {
                    if (arrayC[arrayB[arrayA[z]] - incrementer] != -1) // If we dont have -1, have to check for unused
                    {                                                   // indice
                        incrementer += 1; // Keep going down array for unused indice within C
                    }
                    else
                    {
                        arrayC[arrayB[arrayA[z]] - incrementer] = arrayA[z]; // Now we can set new value assignment
                        checker = true; // Exit the while loop
                    }
                }
            }
        }

        return arrayC; // return our newly sorted arrayC
    }

}
