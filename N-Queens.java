/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.


Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
*/


public List<List<String>> solveNQueens(int n) {
        int[] pos = new int[n];
        List<List<String>> res = new ArrayList<List<String>>();
        solveNQueens(n, 0, pos, res);
        return res;
    }
    
    public void solveNQueens(int n, int cur, int[] pos, List<List<String>> res) {
        
        //if(cur == n) means we have found all position where to put Qs, so now create a chess board. 
        if(cur == n) { 
            List<String> temp = new ArrayList<String>();
            for(int i=0;i<n;i++){
                char[] ch = new char[n];
                Arrays.fill(ch, '.');
                ch[pos[i]] = 'Q';
                temp.add(new String(ch));
            }
            res.add(temp);
            return; 
        }
        
        /*
        How this works:
        Create an array of positions: For every i, put it at pos[cur] and call isValid to validate that position.
        If isValid == true then rec call solveNQueens(n, cur+1, pos, res); where cur is incremented to go find the next pos[cur+1] valid position to place another Q. 
        cur is the ith position of of Q for every row where Q goes. 
        
        See for visualization: https://www.youtube.com/watch?v=xouin83ebxE
        */
        for(int i=0;i<n;i++){
            pos[cur] = i;
            if(isValid(n, cur, i, pos)){
                solveNQueens(n, cur+1, pos, res); 
            }
        }
    }
    
    //Validating if pos[i](where to place the Queen. Formular: index+j == pos[i] || index-j == pos[i] means queen can attach each other).
    private boolean isValid(int n, int cur, int index, int[] pos){
        for(int i=cur-1,j=1;i>=0;i--,j++){
            if(pos[i] == index || pos[i] == index+j || pos[i] == index-j) return false;
        }
        return true; //we can put a queen on pos[i]
    }
