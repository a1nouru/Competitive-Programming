/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/

class Solution {
    // (i - j*j) is the subprobllem. 
    public int numSquares(int n) {
        int [] dp = new int [n+1];
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++)
                min = Math.min(min, dp[i - j*j] + 1);
            dp[i] = min; 
        }
        return dp[n];
    }
}
