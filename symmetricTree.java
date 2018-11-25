/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.



*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return symmetric(root.left,root.right);
    }
    
    public boolean symmetric(TreeNode leftB, TreeNode rightB){
        if(leftB == null && rightB == null) return true;
        if(leftB == null || rightB == null) return false;
        
        //last line is most important[visualize execution of this statement in the tree to understand]
        return leftB.val == rightB.val && symmetric(leftB.left,rightB.right) && symmetric(leftB.right,rightB.left);

    }
}

