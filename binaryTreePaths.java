/*
Given a binary tree, return all root-to-leaf paths.
Note: A leaf is a node with no children.
Example:
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]
Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/ 

class Solution {
    List<String> res = new ArrayList<>(); 
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res; 
    }    	
    
    public void dfs(TreeNode root, String str){
        if (root == null) return;
        if (root.left == null && root.right == null) res.add(str + root.val);
        
        dfs(root.left, str + root.val + "->");
        dfs (root.right, str + root.val + "->");
    }
}
