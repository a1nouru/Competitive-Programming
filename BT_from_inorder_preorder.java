
/* How this works 
To start the traversal, we want to find the root node, which can be provided by the preorder traversal. 
The root is preorder[preIndex=0]...3. Since root is different from inorder[inIndex=0]...9, meaning root 
is not the left most node, or root must have left nodes. Therefore, we go to preorder[preIndex=1]...9 
(preIndex++), which should be the left node of root by preorder traversal. Now we check 9 against 
inorder[inIndex=0]...9, which is the same, meaning 9 is the left most node of the tree, or it has no 
left node. inIndex++ progress through inorder traversal, we have inorder[inIndex=1]...3 which is equal 
to the root, meaning inorder[inIndex=0]...9 has no right node. Now repeat this alternation between preorder 
and inorder traversal, we will eventually come to the solution.
*/

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
   
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
    private int preIndex = 0;
    private int inIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, null);
    }
    
    public TreeNode dfs(int[] preorder, int[] inorder, TreeNode end){
        if(inIndex > inorder.length - 1 || (end != null && end.val == inorder[inIndex])){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
        root.left = dfs(preorder, inorder, root);
        
        inIndex++;
        root.right = dfs(preorder, inorder, end);
        
        return root;
    }
}

