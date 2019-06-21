/*

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
*/ 

class Solution {
    public int findPeakElement(int[] a) {
        int lo = 0, hi = a.length-1;
        
        while (lo < hi){
            int mid = (lo + hi)/2;
            if (a[mid] < a[mid+1]) lo = mid + 1;
            else hi = mid;
        }
    return lo;
    }
}
