/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
*/


class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        
        //The idea is to turn border Os into 1s and then mark everything else as X apart from the 1s which should stay as Os. 
        connectBorder0s(board); //turn all 0s into 1s
        
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++)
                //At this point only border Os are marked as 1s
                if(board[i][j] == '1') //Border Os marked as 1s
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X'; //Turn everything else into X
        }
    }
    private void connectBorder0s(char[][] board){
        int rows = board.length, cols = board[0].length;
        
        for(int j=0; j < cols; j++){ //bfs call column. 
            bfs(board, 0, j);
            bfs(board, rows-1, j);
        }
        
        for(int i=0; i < rows; i++){ //bfs call row
            bfs(board, i, 0);
            bfs(board, i, cols-1);
        }
    }
    private void bfs(char[][] board, int i, int j){
        
        if(i < board.length && j < board[0].length && i >= 0 && j >= 0 && board[i][j] == 'O'){ //Bounds check 
            board[i][j] = '1';
            bfs(board, i+1, j); //go right 
            bfs(board, i-1, j); // go left 
            bfs(board, i, j+1); // go up 
            bfs(board, i, j-1); // go down 
        }
    }
}
