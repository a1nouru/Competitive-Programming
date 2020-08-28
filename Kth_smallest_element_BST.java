/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
*/


class Solution {
    int idx = 0, res = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }
    
    void helper(TreeNode root, int k) {
        if(root == null || idx == k) return;
        helper(root.left, k);
        if(++idx == k) {
            res = root.val;
            return;
        }
        helper(root.right, k);
    }
}

Solution here: https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63683/Short-Java-Recursive
