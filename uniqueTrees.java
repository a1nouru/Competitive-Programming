/*

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/ 
class Solution {
    public int numTrees(int n) {
        //n + 1 to accomodate the 0 subproblem
        int dp [] = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        //Start with a tree of 2 nodes --> i=2
        for(int i = 2; i <= n; i++){ //for every i as number of nodes in subtree 
            for (int j = 1; j <= i; j++) //For every j as root
                //dp[j-1] left subtree --> all prev num nodes. 
                //dp[i-j] right subtree
                //(*) means: taking all pairs between the two sets of possibilites.
                
                //F(j, n) = G(j - 1) * G(n - j)
                dp[i] += dp[j-1] * dp[i-j];
        }
        return dp[n];
    }
}
