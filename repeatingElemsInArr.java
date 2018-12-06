
// Java program to print all elements
// that appear more than once.
//https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/

/*

Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.
For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.

*/ 

public class Main
{

    // Function to find repeating elements
    public static void printDuplicates(int arr[], int n)
    {
        int i;

        // Flag variable used to
        // represent whether repeating
        // element is found or not.
        int fl = 0;

        for (i = 0; i < n; i++)
        {

            // Check if current element is
            // repeating or not. If it is
            // repeating then value will
            // be greater than or equal to n.


            //The idea behind arr[arr[i] % n] is that this is actually a hashcode for a particular index. 
            //So for elements in array at arr[i] they will always hash to the same location. So if we modify the 
            // location to be >= n when we meet the same element later on, we will hash to the same location as before 
            // and that location will give us a value >=n and that is how we will know that the current element is repeating.
            if (arr[arr[i] % n] >= n)
            {

                // Check if it is first
                // repetition or not. If it is
                // first repetition then value
                // at index arr[i] is less than
                // 2*n. Print arr[i] if it is
                // first repetition.
                if (arr[arr[i] % n] < 2 * n)
                {
                    System.out.print( arr[i] % n + " ");
                    fl = 1;
                }
            }

            // Add n to index arr[i] to mark
            // presence of arr[i] or to
            // mark repetition of arr[i].
            arr[arr[i] % n] += n;
        }

        // If flag variable is not set
        // then no repeating element is
        // found. So print -1.
        if (!(fl > 0))
            System.out.println("-1");
    }
    
    public static void main (String[] args)
    {
        int arr[] = { 1, 0, 3, 1, 0, 6, 6 }; //----> Output: 1 0 6
        int arr_size = arr.length;
        printDuplicates(arr, arr_size);
    }
}
// This code is contributed by anuj_67.
