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
public List<List<Integer>> combine(int n, int k) {
List list = new ArrayList();
    
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean[] used=new boolean[n+1];
		helper(result,list,used,k,1); 
        return result;
}
    
public static void helper(List<List<Integer>> result, List<Integer> list, boolean[] used, int k, int start) {
	if (list.size() == k) {
		result.add(new ArrayList<Integer>(list));
		return;
	}

	for (int i = start; i < used.length; i++) {
		if (!used[i]) {
			list.add(i);
			used[i] = true;
			helper(result, list, used, k, i + 1);
			used[i] = false;
			list.remove(list.size() - 1);
		}
	}
}
}
