/*

The secret for this problem is the post-order traversal: you want to process a node's right and left subtree before you process the node itself. With the data from a node's right and left subtree you can decide what to return: either:

the value of the node (both subtrees yield negative value) -- even if the node itself is negative, as we need to satisfy the requirement that a path must have at least one node,
the value of the node + the value from its left or right subtree, whichever is positive (one of the subtrees yield negative value)
the value of the node + the value of both subtrees. (if both subtrees yield a positive value)
.
Runtime: O(n)
Space Complexity for balanced tree: O(log n). Worst case (tree degenerated into a linked list) O(n);

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
    
    public int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        
        maxPathSum(root, result);
        
        return result[0];
    }
    
    public int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return -1; 
        }
        
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        
        int cur = root.val + Math.max(left, 0) + Math.max(right, 0);
        if (cur > max[0]) max[0] = cur;
        
        return root.val + Math.max(Math.max(left, right), 0);
    }
}
