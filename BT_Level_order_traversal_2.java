/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

class Solution {
    List<List<Integer>> results = new ArrayList<>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrderBottom(root, 0);
        return results;
    }
    
    public void levelOrderBottom(TreeNode root, int level){
        if (root == null) return; 
        if (level >= results.size()) results.add(0, new ArrayList<>());
        
        results.get(results.size() - 1 - level).add(root.val);
        levelOrderBottom(root.left, level+1);
        levelOrderBottom(root.right, level+1);
    }
}
