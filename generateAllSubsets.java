/*

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Backtracking
        // Edge case
        if(nums == null || nums.length == 0) return new ArrayList<>();
        
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, temp, result);
        return result;
    }
    public void helper(int[] nums, int start, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp)); //for every rec call, add temp to results. 
        for(int i = start; i < nums.length; i++) {
            // choose
            temp.add(nums[i]);
            // explore
            helper(nums, i + 1, temp, result);
            // unchoose
            temp.remove(temp.size() - 1); //remvove recently added item in temp to reconstruct(add next elem of num[i])
        }
    }
}
