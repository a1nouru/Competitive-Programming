/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

*/ 

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], length = nums.length;
        for (int i = 1; i < length; i++){
            if(nums[i-1] > 0) nums[i] += nums[i-1];
            if(nums[i] > maxSum) maxSum = nums[i];
        }
        return maxSum;
    }
} 
