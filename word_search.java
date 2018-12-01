public static boolean exist(char [][] arr, String word){
        if (arr.length == 0 && arr[0].length == 0) return false; // base case

        int m = arr.length;
        int n = arr[0].length;

        for (int i = 0; i< m; i++){
            for (int j = 0; j < n; j++){
                if (DFS(arr,word,i,j,0)) return true;
            }
        }
        return false;
    }

    private static boolean DFS(char[][] arr,String word, int i, int j, int k){
        int m = arr.length;
        int n = arr[0].length;

        if (i < 0 || j < 0 || i > m || j> n) //checking if out of bounds
            return false;
        if (arr[i][j] == word.charAt(k)){
            if (k == word.length()-1) // we are at the end of the word and all the characters have been found.
                return true;
            else if( DFS(arr,word,i-1,j,k+1) //going left
                || DFS(arr,word,i+1,j,k+1) //going right
                || DFS(arr,word,i,j-1,k+1) //going down
                || DFS(arr,word,i,j+1,k+1)) //going up
                return true;
        }
        return false;
    }


//Extended part of the problem 

import java.io.*;
import java.util.*;

class Solution {
  // Determine if we can find the input word in the grid by taking a
  // path through adjacent letters.
  public static boolean findWord(char[][] grid, String word) {
    
    if (grid.length == 0 && grid[0].length == 0) return false; // base case
    
    for(int i = 0; i < grid.length; i++){
    for(int j = 0; j < grid[0].length; j++){
     if(word.charAt(0) == grid[i][j]){ //finding first char of word
       if(dfs(grid,word,i , j, 0))
         return true;
     }
  }
  }
    return false;
  }
  
  public static boolean dfs(char [][] grid, String tempStr,int i, int j,int k){
    int m = grid.length;
    int n= grid[0].length;
    
    if(i <0 || j< 0 || i >= m || j >= n){ //checking out of bounds
      return false;
    }
    
    // String out of bounds 
    if(k >= tempStr.length()){
      return false;
    }
    
     //if char index not match with grid[i][j] 
    if(grid[i][j] != tempStr.charAt(k)){
      return false;
    }
    
    //we know that we have come to the end of our rec call and found string. 
    if(k == tempStr.length()-1){
        return true;
    }
    else if(dfs(grid,tempStr,i-1,j,k+1) //going left
                || dfs(grid,tempStr,i+1,j,k+1) //going right
                || dfs(grid,tempStr,i,j-1,k+1) //going up
                || dfs(grid,tempStr,i,j+1,k+1)){ //going down 
                return true;
    }
        return false;
  }
  
  public static void main(String[] args) {
    
    char[][] testGrid = {{'c', 'b', 'd', 'k'},
                         {'e', 'a', 'q', 'c'},
                         {'d', 't', 't', 'a'},
                         {'z', 'w', 'b', 'i'}};

    String[] testStrings = {"cat", "bike", "bat","cax", "ci", "cxxxxxxxa"};
    for (String s : testStrings) {
      findWord(testGrid, s);
      
      System.out.println(findWord(testGrid, s));
    }
  }
}
