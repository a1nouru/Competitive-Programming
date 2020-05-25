/*
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2     
     / \   
    1   3
*/

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        
        if (root.val == val)
            return root;
        
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
            
        return (left == null)? right : left;       
    }
}
