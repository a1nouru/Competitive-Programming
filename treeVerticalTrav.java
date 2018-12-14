/*

Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
*/

class Solution {
    Map<Integer, List<Integer>> map;
    Queue<TreeNode> que = new LinkedList<>();
    Queue<Integer> col = new LinkedList<>();
        
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new TreeMap<Integer, List<Integer>>();
        add(root, 0);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            int curCol = col.poll();
            if (cur == null) continue;
            List<Integer> colVal = map.getOrDefault(curCol, new ArrayList<Integer>());
            colVal.add(cur.val);
            map.put(curCol, colVal);
            add(cur.left, curCol - 1);
            add(cur.right, curCol + 1);
        }
        
        return new ArrayList<List<Integer>>(map.values());
    }

    private void add(TreeNode cur, int colIdx) {
        que.add(cur);
        col.add(colIdx);
    }
}```
