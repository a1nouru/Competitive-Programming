/*

103. Binary Tree Zigzag Level Order Traversal
DescriptionHintsSubmissionsDiscussSolution
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


public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(root==null)
        return res;
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    int level=1;
    
    ArrayList<Integer> item = new ArrayList<Integer>();
    item.add(root.val);
    res.add(item);
    stack.push(root);
   
   while(!stack.isEmpty())
    {
        LinkedList<TreeNode> newStack = new LinkedList<TreeNode>();
        item = new ArrayList<Integer>();
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            if(level%2==0)
            {
                if(node.left!=null)
                {
                    newStack.push(node.left);
                    item.add(node.left.val);
                }
                if(node.right!=null)
                {
                    newStack.push(node.right);
                    item.add(node.right.val);
                }
            }
            else
            {
                if(node.right!=null)
                {
                    newStack.push(node.right);
                    item.add(node.right.val);
                }
                if(node.left!=null)
                {
                    newStack.push(node.left);
                    item.add(node.left.val);
                }                   
            }
        }
        level++;
        if(item.size()>0)
            res.add(item);
        stack = newStack;
    }
    return res;
}
