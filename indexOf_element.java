/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int [] temp = {-1,-1};
        if(nums == null) return temp;
        
        int [] temp1 = {0,0};
        if(nums.length == 1){
            if(nums[0] == target)
                return temp1;
        }
        
        int left = 0;
        int right = nums.length-1;
        boolean found = false;
        while(left < right){
            if(nums[left] < target)
                left++;
            if(nums[right] > target)
                right--;
            if(nums[left] == target && nums[right] == target){
                found = true;
                break;
            }
                
        }
        int []results = {left, right};
        if(!found)
            return temp;
        
        return results;
    }
}
