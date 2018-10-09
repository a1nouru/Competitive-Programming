/*
The DFS approach is super expensive, working on a Dynamic programming version of solution. 


Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/

public int minPathSum(int [][] grid){
        if (grid == null) return -1;
        else
            return DFS(0,0,grid);
    }
    public int DFS(int i, int j, int [][]grid){
        if (grid.length == 0 || grid[0].length == 0)
            return grid[i][j];

        if (i < grid.length-1 && j < grid[0].length-1) {
            int r1 = grid[i][j] + DFS(i+1, j, grid);
            int r2 = grid[i][j] + DFS(i, j+1, grid);

            return Math.min(r1, r2);
        }

        if (i < grid.length-1)
            return grid[i][j] + DFS(i+1, j, grid);

        if (j < grid[0].length-1)
            return grid[i][j] + DFS(i, j+1, grid);

        return 0;

    }
