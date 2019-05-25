/*

All values on the left sub tree must be less than root, and all values on the right sub tree 
must be greater than root. So we just check the boundaries for each node.

This solution also goes to the left subtree first. If the violation occurs close to the root but on the right subtree, 
the method still cost O(n).
The second solution below can handle violations close to root node faster.
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        helper(root, res);
        return res; 
    }
    
    public void helper(TreeNode root, List<Integer> res){
        if (root == null) return;
        
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    } 
}
 
