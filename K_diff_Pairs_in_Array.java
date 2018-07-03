/* Example: Given an array of distinct integer values, 
count the number of pairs of integers that have di erence k. 
For example, given the array {1, 7, 5, 9, 2, 12, 3} and the di erence k = 2,there are four pairs with difference2: 
(1, 3), (3, 5), (5, 7), (7, 9). */


//Time complexity: Big O(n) where n is the number of elements in the array. 


//********Author: Nouru Muneza*******
package sample;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Integer[] input = {1,7,5,9,2,12,3};
        Hashtable tempTable = new Hashtable();

        List<Integer> list = Arrays.asList(input); //converting an array into an 

        for(int i = 0; i<input.length; i++)
        {
         if(list.contains(input[i]-2))
         {
             System.out.println(input[i] + ","+(input[i]-2)+" ");
         }
         else if(list.contains(input[i]+2))
         {
             System.out.println(input[i]+","+(input[i]+2)+" ");
         }
        }
    }
}

/* Output

1,3 
7,5 
5,3 
9,7 
3,1 

Process finished with exit code 0

*/


