/*

All values on the left sub tree must be less than root, and all values on the right sub tree 
must be greater than root. So we just check the boundaries for each node.

This solution also goes to the left subtree first. If the violation occurs close to the root but on the right subtree, 
the method still cost O(n).
The second solution below can handle violations close to root node faster.
*/

public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
}
 
public boolean isValidBST(TreeNode p, double min, double max){
    if(p==null) 
        return true;
 
    if(p.val <= min || p.val >= max)
        return false;
 
    return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
}
