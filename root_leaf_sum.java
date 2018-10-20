//Sum of root to direct children only. I will do the sum of root to all descendants later. 

/*Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
*/

public static int temp_sum= 0;
    public static void dfs(TreeNode root, int sum){
         if (root == null) return ;

        if (root.left != null && root.right != null)
            sum += (root.data*10 + root.left.data) + (root.data*10 + root.right.data);

        if (sum > temp_sum) //only keep max sum during back track of call functions
        temp_sum = sum;

        dfs(root.left,sum);
        dfs(root.right, sum);
    }
