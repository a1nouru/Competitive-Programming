

/*

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if ( root == null) return result;
        dfs(root, result, 0);
        return result;
    }
    
    /*
    The idea is call rec to the right first. This means right subtrees always get priority and will be the only ones to be added to result. 
    Every rec call should correspond to the level of BT thus this is how we get to add root.val 
    */
    
    //Space: O(log n) where n is the height of the tree.
    public void dfs(TreeNode root, List<Integer>result, int level){
        if(root == null) return;
        
        if(result.size() == level){
            result.add(root.val);
        }
        
        dfs(root.right, result, level+1);
        dfs(root.left, result, level+1);
    }
} 
