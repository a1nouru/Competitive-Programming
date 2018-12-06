/*

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

*/
public class Solution {
    //To better undrstand this, draw a function of domains and co-domains and then trace your 
    public int findDuplicate(int[] nums) {
        int slow = 0; //slow pointer 
        int fast = 0; //fast pointer
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]]; //2 moves at once
        } while(slow != fast);
         int find = 0;
      
        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}
