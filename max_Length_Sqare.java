/*
Given a 2D boolean array, find the largest square subarray of
true values. The return value should be the side length of the
largest square subarray subarray.
*/
     
     
     public static int maxLength(boolean[][] arr) {
         int max = 0;
         for (int i = 0; i < arr.length; i++) {
             for (int j = 0; i < arr[0].length; j++){
                 if (arr[i][j]){
                     max = Math.max(max, dfs(arr, i , j));
                 }
             }
         }
         return max;
     }

     public static int dfs(boolean [][] arr, int i, int j){
         if (i == arr.length || j == arr[0].length) return 0;

         if (!arr[i][j]){
             return 0;
         }
         return 1+ Math.min(Math.min(dfs(arr,i+1, j), dfs(arr,i,j+1)),
                 dfs(arr, i+1, j+1)); //sub-problem.
     }
     
     //**************** Bottom up Dynamic Programming VERSION ****************
     
     //Bottom up approach:
/*
1. identify sub_problem
2. identify base cases
3. build from bottom to top with a cache 
*/
 public class Main {
     public static int maxLength(boolean[][] arr) {
         int max = 0;
         int [][] cache = new int[arr.length][arr[0].length];
         cache[0][0] = (arr[0][0]) ? 1:0;
         for (int i = 0;  i < arr.length; i++){
             for (int j = 0; j < arr[0].length; j++){
                 if (arr[i][j]){
                     cache[i][j] = Math.min(Math.min(cache[i-1][j], cache[i][j-1]), cache[i-1][j-1]); //sub_problem
                 }
                 max = Math.max(cache[i][j], max); //update max. 
             }
         }
         return max;
     }
