/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
*/

/* How this works:
----> Check if sum if even? if sume is even, we then only need to substract larger values of the arr from 
half/sum and then recursively call dfs till target == 0. Here we will have found part of the subset which sums up to half sum. 
We don't need to find the other half because we have made sure that our sum is even and so 
if we can find sum/2 it automatically means that the other half is also present in the array. 
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) //find total sum 
            sum += num;
        if (sum % 2 == 1) return false; //if sum is not even 
        
        Arrays.sort(nums);
        if (nums[nums.length-1] > sum/2) return false; // if largest element in arr is greater than it's half 
        return dfs(nums, sum/2, nums.length-1);
    }
    
    public boolean dfs(int[] nums, int target, int end) {
        if (0 == target) return true; //we found subset which adds up to sum/2
        
        for (int i = end; i >= 0; i--) {
            if (target - nums[i] >= 0 && dfs(nums, target-nums[i], i-1))
                return true;
        }
        return false; 
    }
}
