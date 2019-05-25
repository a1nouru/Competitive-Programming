/*

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:

[
  [3],
  [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        int currLevel = 1, numNodes = 0;
        boolean flip = false;
        que.add(root);
        
        while(!que.isEmpty()){
            TreeNode currNode = que.remove();
            if(flip) temp.add(0, currNode.val); else temp.add(currNode.val);
            currLevel --;
            
            if(currNode.left != null){
                que.add(currNode.left);
                numNodes++;
            }
            
            if(currNode.right != null){
                que.add(currNode.right);
                numNodes++;
            }
            
            if(currLevel == 0){
                currLevel = numNodes;
                numNodes = 0;
                flip = (!flip);
                res.add(temp);
                temp = new ArrayList<>();
            }
        }
        return res;
    }
}



