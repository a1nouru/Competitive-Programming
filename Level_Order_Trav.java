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
  List<List<Integer>> res = new ArrayList<List<Integer>>();
  levelOrder(root, res, 0);
  return res;
}

public void levelOrder(TreeNode root, List<List<Integer>> res, int level){
  if(root == null) return;
  if(level >= res.size()){ //if level exceeds size of res then create new list to accomodate new level's nodes. 
    res.add(new ArrayList<Integer>());
  }
  
  res.get(level).add(root.val); //Get corresponding level list in res. This is the same level as map.get(level).add(root.val);
  levelOrder(root.left, res, level+1);
  levelOrder(root.right, res, level+1);

}

}

