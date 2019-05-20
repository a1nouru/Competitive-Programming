/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/
class Solution{ 
   public boolean exist(char[][] board, String word){
    if (board[0].length == 0 || board.length == 0 || word.length() == 0) return false; 
    int n = board[0].length, m = board.length;
    for (int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if (board[i][j] == word.charAt(0) && DFS(board, word, i, j, 0, new boolean[board.length][board[i].length]))
                return true;
        }
    }
    return false;
}

public boolean DFS (char [][] board,String word, int i, int j, int k, boolean [][] visited){
    if (k == word.length()) return true; 
    
    if(i < 0 || j < 0 || j >=board[0].length 
       || i >= board.length || word.charAt(k) != board[i][j] || visited[i][j]) 
        return false;
        
    visited[i][j] = true;
    if(DFS(board, word, i-1, j, k+1, visited) || 
       DFS(board, word, i+1, j, k+1, visited) || 
       DFS(board, word, i, j-1, k+1, visited) ||
       DFS(board, word, i, j+1, k+1, visited))
        return true;
    
    visited[i][j] = false;
    return false;
}
}
