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


// num <= nums.length makes sure that if all numbers are > than size, then 1 will be the smallest missing. 
//nums-1 because we start from 1 not 0. So element 1 would match to index 0. Offset applies to all elements. 
//Swapping elements that don't much their index

class Solution {
     public int firstMissingPositive(int[] nums) {
        for(int num : nums) {
            while(num > 0 && num <= nums.length && nums[num-1] != num) { 
                int temp = nums[num-1];
                nums[num-1] = num;
                num = temp;
            }
        }
        int i;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) return i+1;
        }

        return i+1;
    }
}
