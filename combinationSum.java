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


class Solution {
    public List<List<Integer>> combinationSum (int[] candidates, int target){
    Arrays.sort(candidates);

    List<List<Integer>> results = new ArrayList<>();
    combinationSumHelper(results, new ArrayList<>(), candidates, target, 0);
    return results;
    }

    public void combinationSumHelper(List<List<Integer>> results, List<Integer> tempResult, int[] candidates,       int target, int start) {
        if (target == 0) {
        results.add(new ArrayList<>(tempResult));
            return;
        }
        for (int i=start; i<candidates.length; i++) {
        if (candidates[i] > target) {
            break;
        }
        if (i != 0 && candidates[i] == candidates[i - 1]) { //duplicates 
            continue;
        }
        tempResult.add(candidates[i]);
        combinationSumHelper(results, tempResult, candidates, target - candidates[i], i);
        tempResult.remove(tempResult.size()-1);
        }
    }
}
