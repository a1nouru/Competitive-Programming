/*

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int area = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    area = Math.max(area, dfs(grid, i,j,0));
            }
        }
        return area;
    }
    
    public Integer dfs(int[][] grid, int i, int j, int area){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)//out ouf bounds  
            return area;

        grid[i][j] = 0; // already visited. 
        area++; 
        area = dfs(grid, i+1, j, area);
        area = dfs(grid, i-1, j, area);
        area = dfs(grid, i, j+1, area);
        area = dfs(grid, i, j-1, area);
        return area;
    }
}

