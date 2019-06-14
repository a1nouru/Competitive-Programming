/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

*/

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return s;
        int n = s.length();
        String str = "";
        boolean[][] dp = new boolean[n][n];
        
        for(int i=n-1; i >= 0; i--){
            for(int j=i; j < n; j++){ 
                if(s.charAt(i) == s.charAt(j) && (i+1 > j-1 || dp[i+1][j-1] == true) ) {
                    
                    if(str.length() < (j-i+1)) // max new pali.                      
                        str = s.substring(i, j+1);
                    dp[i][j] = true;
                }
            }
        }
        return str;
    }
}
