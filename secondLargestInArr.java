/*

Given an array of integers, our task is to write a program that efficiently finds the second largest element present in the array.

Example:

Input : arr[] = {12, 35, 1, 10, 34, 1}
Output : The second largest element is 34.
*/

//A more Efficient Solution can be to find the second largest element in a SINGLE TRAVERSAL. 

public static void print2largest(int arr[],  
                                     int arr_size) 
    { 
        int i, first, second; 
       
        /* There should be atleast two elements */
        if (arr_size < 2) 
        { 
            System.out.print(" Invalid Input "); //or return exception 
            return; 
        } 
       
        first = second = Integer.MIN_VALUE; 
        for (i = 0; i < arr_size ; i++) 
        { 
            /* If current element is smaller than  
            first then update both first and second */
            if (arr[i] > first) 
            { 
                second = first; 
                first = arr[i]; 
            } 
       
            /* If arr[i] is in between first and  
               second then update second  */
            else if (arr[i] > second && arr[i] != first) 
                second = arr[i]; 
        } 
          
        if (second == Integer.MIN_VALUE) //in case you have all duplicates 
             System.out.print("There is no second largest"+ 
                                 " element\n"); 
        else
             System.out.print("The second largest element"+ 
                                      " is "+ second); 
    } 
