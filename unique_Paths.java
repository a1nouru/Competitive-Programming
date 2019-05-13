class Solution {
    public int uniquePaths(int m, int n){
        if (m == 0 && n == 0) return 0;
        int [] dp = new int [n];
        dp[0] = 1;
        for (int i = 0; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
