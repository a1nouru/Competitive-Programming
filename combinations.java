/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1, new ArrayList<>());
        return res;
    }
 
    public void helper(int n, int k, int indx, List<Integer> temp){
        if (temp.size() == k){
            res.add(new ArrayList<>(temp));
            return; 
        }
        
        for(int i = indx; i <= n; i++){
            temp.add(i);
            helper(n, k, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
