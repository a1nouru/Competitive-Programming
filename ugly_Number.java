/*
Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/

class Solution {
   public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] dp = new int[n+1]; // dp[i] holds the ith's ugly number
        dp[1] = 1;
        int p2=1, p3=1, p5=1;
        for(int i=2; i<=n; i++){ // loop invariant:dp[i] holds the smallest ith uglynumber
            dp[i] = Math.min(2*dp[p2], Math.min(3*dp[p3],5*dp[p5])); // the next ugly number must be built from a smaller ugly number
            if(dp[i]==2*dp[p2])p2++; 
            if(dp[i]==3*dp[p3])p3++;
            if(dp[i]==5*dp[p5])p5++;
        }
        return dp[n];
   }
}
