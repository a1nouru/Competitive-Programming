/*
This question is similat to how many unique ways to get to bottom right of the array. 
We use the same analogy of how many ways we can get to a non-boarder grid. 
Meaning we can either get there from left of current grid (grid[i][j-1]) or from prev row grid (grid[i-1][j]). 
So we get the min value from these 2 options and then add it to the current grid(grid[i][j]).
*/

class Solution{
    public int minPathSum(int[][] g){
        int m = g.length;
        int n = g[0].length;
        for (int i = 1; i < m; i++) g[i][0] += g[i-1][0];
        for (int j = 1; j < n; j++) g[0][j] += g[0][j-1];
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                g[i][j] += Math.min(g[i-1][j], g[i][j-1]);
            }
        }
        return g[m-1][n-1];
    } 
} 

    
    
    
    
    
