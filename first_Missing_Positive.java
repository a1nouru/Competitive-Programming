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
Note:

Your algorithm should run in O(n) time and uses constant extra space.

*/

class Solution {

    public int firstMissingPositive(int[] nums) {
    //Convert the array to list, then search from 1 to MAX

    List<Integer> list = new ArrayList<Integer>();
    for(int num:nums) if(num>0) {list.add(num);}
    int ans = 1;
    while(ans<Integer.MAX_VALUE){
	    if(list.contains(ans)){ans++;}
	    else return ans;
    }
    return ans;
    }
}
