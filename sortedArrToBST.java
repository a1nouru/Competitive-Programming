
/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

*/


* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution{
     public TreeNode sortedArrayToBST(int [] nums){
         if(nums == null || nums.length == 0) return null;
         
         return sortedArrayToBST(nums, 0, nums.length-1);
     }
     
     public TreeNode sortedArrayToBST(int []nums, int left, int right){
         if(left > right) return null;
         
         int mid = left + (right-left)/2;
         
         TreeNode root = new TreeNode(nums[mid]);
         
         root.left = sortedArrayToBST(nums,left, mid-1);
         root.right = sortedArrayToBST(nums,mid+1, right);
         
         return root;
     }   
 }
