/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

class Solution{
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int [] num, int target){
        if (num == null  || num.length == 0) return res;
        Arrays.sort(num);
        helper(num, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void helper(int [] num, int target, int indx, List<Integer>temp, List<List<Integer>> res){
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return; 
        }
        if(target < 0) return;
        for(int i = indx; i < num.length; i++){
            temp.add(num[i]);
            helper(num, target-num[i], i, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}


