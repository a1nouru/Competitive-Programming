/*
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

*/

class Solution {
    List<Integer> listLeaf1 = new ArrayList<>();
    List<Integer> listLeaf2 = new ArrayList<>();
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        leafSimilarTraverse(root1, listLeaf1);
        leafSimilarTraverse(root2,listLeaf2);
    
        return listLeaf1.equals(listLeaf2);
    }
    
    public void leafSimilarTraverse(TreeNode root, List<Integer> listLeaf){
        if (root == null) return;
        
        if (root.left == null && root.right == null)
            listLeaf.add(root.val);
        
        leafSimilarTraverse(root.left, listLeaf);
        leafSimilarTraverse(root.right, listLeaf);
    }
}
