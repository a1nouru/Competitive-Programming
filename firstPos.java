package sample;


import java.util.*;

/*

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1

 */

public class Main {

    public static int firstMissingPositive (int[] arr){
       if (arr.length == 0) return -1;

       int temp;
       for (int i = 0; i < arr.length; i++){
           //ignore out of bounds elements present
           if (arr[i] != i && arr[i] > 0 && arr[i] < arr.length-1){
               temp = arr[i];
               arr[i] = arr[temp];
               arr[temp] = temp;
               //checking if the index that got replaced is out of position.
               if (arr[i] != i )
               {
                   //repeating an index that is out of position after swap.
                   i--;
               }
           }
           //Do not repeat indexes that are less than or greater than max index in arr.

       }
       //Looking for indexes that are not in their position.
       int i;
        for ( i = 0; i < arr.length; i++){
            if (arr[i] != i && i != 0) {
                break;
            }
        }
        //In case it's the last one and you don't want to just return the last one. IE: 1,2,0} return 3;
        if (arr[i] == i && i == arr.length-1)
            return i+1;
        return i;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,0};
        System.out.println(firstMissingPositive(arr));
    }
}
