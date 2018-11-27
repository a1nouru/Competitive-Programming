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

class Solution2 {

    public List<List<Integer>> zizagTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 1;
        int levelNumNodes = 0;

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        boolean flip = false;
        while(!queue.isEmpty()){
            TreeNode current = queue.remove();
            if (flip)
                level.add(current.val);
            else
                level.add(0, current.val);

            currentLevel--;

            if (current.left != null){
                queue.add(current.left);
                levelNumNodes++;
            }

            if (current.right != null){
                queue.add(current.right);
                levelNumNodes++;
            }

            if (currentLevel == 0){
                currentLevel = levelNumNodes;
                levelNumNodes = 0;
                flip = !flip;
                results.add(level);

                level = new ArrayList<>();
            }
        }
        return results;
    }
}
