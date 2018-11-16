
/*
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.

*/


class Solution {
    Map<String, Integer>  count = new Hashtable<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        collect(root);
        return ans;
    }
    
    public String collect(TreeNode node) {
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right); //serialize
        count.put(serial, count.getOrDefault(serial, 0) + 1); //put in map. getOrDefault gets value in map and if value == null, it returns 0 as default val. 
        if (count.get(serial) == 2) //if duplicate 
            ans.add(node); //add to list of duplicates 
        return serial; 
    }
}

