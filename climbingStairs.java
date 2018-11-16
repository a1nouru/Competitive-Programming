/*

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

//Brute force (Won't pass online judge)
class Solution { //wrapper function 
    public int climbStairs(int n) {
        return climbStairs(0, n);
    }
    public int climbStairs(int i, int n){
         if (i > n)
        return 0;
    if (i == n)
        return 1;
    return clim_stair(i+1, n) + clim_stair(i+2, n);
    }
}

//Dynammic programming 

class Solution {
    public int climbStairs(int n) {
    
        if (n ==1) return 1;
        
        int [] dp  = new int [n+1];
        
        dp[1] = 1;
        dp [2]  = 2;
        
        for(int i = 3; i < dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}



