/*

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, 0, map);
        
        return new ArrayList<>(map.values());
    }
    
    public void dfs(TreeNode root, int index, Map<Integer, List<Integer>> map){
        if (root == null) return; 
        if (map.get(index) == null){  
            map.put(index, new ArrayList<>()); 
            map.get(index).add(root.val);
        }
        else map.get(index).add(root.val);
        
        dfs(root.left, index+1, map);
        dfs(root.right, index+1, map);
    }
}
