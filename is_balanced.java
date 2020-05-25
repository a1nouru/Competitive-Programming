/* 
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

*/


class Solution {
    public boolean isBalanced(TreeNode root) {
       
        return depth(root) != -1;
    }
    
    public int depth(TreeNode root){
       if (root == null) return 0;
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        if (left == -1 || right == -1 || Math.abs(left-right) > 1)
            return -1;
        
        return Math.max(left, right) + 1;
    }
}
