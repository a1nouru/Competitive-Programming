/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/
class Solution {
    public int maximalSquare(char [][] grid){
        if (grid.length == 0) return 0;
        int side = 0; 
        int [][] dp = new int [grid.length+1][grid[0].length+1];
        
        for(int i = 1; i <= grid.length; i++){
            for(int j = 1; j <= grid[0].length; j++){
                if(grid[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    side = Math.max(side, dp[i][j]);
                }
            }
        }
        return side * side; 
    }  
}
