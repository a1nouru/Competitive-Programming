package sample;


import java.util.*;

/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
 */




public class Main {

    public static int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;

        return binaryTraverse(nums, 0, nums.length-1);
    }

    static int binaryTraverse(int []nums, int left, int right){

        int mid = (left+right)/2;
        System.out.println(mid);
        if (mid < 0 || mid > (nums.length-1) || left > right || right < left) return -1;

        if( mid == 0)
        {
            if (nums[mid] > nums[mid+1] && nums[mid] > Integer.MIN_VALUE) return mid;
        }
        else if (mid == nums.length -1)
        {
            if (nums[mid] > nums[mid-1] && nums[mid] > Integer.MIN_VALUE) return mid;
            //System.out.println("we");
        }

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) //checking for peak element.
                return mid;
        //recording indexes
        int indexLeft = binaryTraverse(nums, left, mid - 1);
        int indexRight = binaryTraverse(nums, mid + 1, right);

        // create two indexes, one for left recursion and other for right recursion.
        // Then check if either is -1 then return the non -1.
        if (indexLeft != -1)
            return indexLeft;
        else
            return indexRight; 
    }


    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 5, 4};
        int sum = 10;
        System.out.println(findPeakElement(arr));

    }
}
