/*

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

 */

//Big O = m * n * log(K)
public class Main {
    public static int islandCount(char [][]grid){
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++){

            for (int j = 0; i < n; j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }

            }
        }
        return count;
    }

    public static void dfs(char [][]grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i > m-1 || j < 0 || j > n-1 || grid[i][j] != '1' )
            return;

        grid[i][j] = '#'; //Any char basically, we are just trying to remove already visited 1s

        dfs(grid,i+i, j);
        dfs(grid,i-1,j);
        dfs(grid, i, j+1);
        dfs(grid,i,j-1);
    }
