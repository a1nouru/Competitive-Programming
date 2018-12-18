/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6

*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int col = matrix[0].length;

        int ret = 0;
        int[] heightArray = new int[col];
        for(char[] rows : matrix) {
            for (int i = 0; i < col; i++) {
                if (rows[i] == '1') {
                    heightArray[i] += 1;
                } else {
                    heightArray[i] = 0;
                }
            }
            ret = Math.max(ret, getMax(heightArray));
        }
        return ret;
    }

    private int getMax(int[] heights) {
        int ret = 0;
        int col = heights.length;
        
        int[] leftArray = new int[col];
        leftArray[0] = -1;
        int[] rightArray = new int[col];
        rightArray[col - 1] = col;
        
        for (int i = 1; i < col; i++) {
            int p = i - 1;
            while (p >= 0 && heights[i] <= heights[p]) {
                p = leftArray[p];
            }
            leftArray[i] = p;
        }   
        
        for (int i = col - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < col && heights[i] <= heights[p]) {
                p = rightArray[p];
            }
            rightArray[i] = p;
        }
        
        for (int i = 0; i < col; i++) {
            ret = Math.max(ret, heights[i] * (rightArray[i] - leftArray[i] - 1));
        }
        return ret;
    }
}
