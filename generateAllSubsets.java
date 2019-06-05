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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    
    public void helper(int []nums, int indx, List<Integer>temp){
        res.add(new ArrayList<>(temp));
        
        for (int i = indx; i < nums.length; i++){
            temp.add(nums[i]);
            helper(nums, i + 1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
