package sample;


import java.util.*;

/*
Question:Suppose an array sorted in ascending order is rotated at some pivot unknown
to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 */

//Try to work trough this problem mechanically,
// meaning take baby step and try to patch the solution in the most basic
// way you understand it, it always works for me.

public class Main {

    int GlobalMin;

    public static int MinRotatedArr(int [] arr, int minVal, int left, int right){
        if(arr.length == 0) return -1; //Empty arr base case.

        if (left == right) return minVal; //stopping condition

        int mid  = (right + left) / 2;

        if (arr[mid] < minVal) minVal = arr[mid];
        //System.out.print("we ");

        if (arr[left] < arr[right]) //array never rotated.
            return arr[left];
        else if (arr[left] < arr[mid] && arr[mid] < arr[right])
            return MinRotatedArr(arr, minVal, left, mid);
        else
         return MinRotatedArr(arr, minVal, mid, right);
    }

    public static void main(String[] args) {

        int [] arr = {4,5,6,7,0,1,2};
        int max = Integer.MAX_VALUE; //Start with a max value
        // as your minVal then replace with smaller values
        System.out.print(MinRotatedArr(arr,max,0,arr.length-1));
    }
}
