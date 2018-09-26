/*

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */ 
 
    //DFS approach
    public void flattern(TreeNode root){
        if (root == null) return;
        
        if (!root.left == null) flattern(root.left); //keep left 
        if (!root.right == null) flattern(root.right); //keep right
        
        TreeNode temp = root.right;
        root.right =root.left;
        root.left = null; //don't keep a dangling pointer. //in c++ this would be a big issue
        
        while (root.right != null) 
            root = root.right; // we move down to the  furthest leaf and then connect last leaf to temp.
        root.right = temp;
        //Just like that and your done :)
    }
