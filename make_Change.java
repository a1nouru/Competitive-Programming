/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
*/

class Solution{
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    for (int i = 1; i <= amount; i++) {
        int min = Integer.MAX_VALUE;
        for (int coin : coins) { //for all available coin changes in coins arr. 
            if (coin <= i && dp[i - coin] >= 0) //dp[i-coin] can't be -1. It has to be previously defined in order to be used by dp[i]
                 min = Math.min(min, dp[i - coin] + 1); //+1 cause change was made. 
        }
        dp[i] = (min == Integer.MAX_VALUE) ? -1 : min; //If change cant' be made(min will stay == Integer.MAX_VALUE), mark dp[i] as -1. 
    }
    return dp[amount];


}
}


