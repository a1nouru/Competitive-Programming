/*

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/
class Solution { 
    public int numDecodings(String s) {
        if (s == null || s.lengthf() == 0) return 0;
        int n = s.length();
        int [] dp = new int [n+1]; //dp[i]: The number of the ways for i length string (i=1..n)
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 0; i <= n; i++){  //i is the length,not index
            if(s.charAt(0) != '0')  // 0 doesn't count 
                dp[i] = dp[i-1];
            int twoDigits = s.substring(i-2, i);  // 2 digits 
            if(twoDigits >= 10 && twoDigits <= 26)
                dp[i] += dp[i-2];  //Adding all ways 
        }
    }
}

