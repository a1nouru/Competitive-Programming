/*

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

*/

class Solution {
    public int minDistance(String a, String b) {
        if (a.length() == 0 || b.length() == 0) return a.length() + b.length();
        
        int[][] memo = new int[a.length()][b.length()];
        for (int[] row: memo) Arrays.fill(row, -1);
        return getDistance(a, b, 0, 0, memo);
    }
    
    private int getDistance(String a, String b, int aloc, int bloc, int[][] memo) {
        if (aloc == a.length()) return b.length() - bloc;
        if (bloc == b.length()) return a.length() - aloc;
        if (memo[aloc][bloc] != -1) return memo[aloc][bloc];
        
        int result = 0;
        if (a.charAt(aloc) == b.charAt(bloc)) {
            result = getDistance(a, b, aloc+1, bloc+1, memo);
        } else {
            result = 1 + Math.min(Math.min(getDistance(a, b, aloc+1, bloc, memo), getDistance(a, b, aloc, bloc+1, memo)),
                                  getDistance(a, b, aloc+1, bloc+1, memo));
        }
        return memo[aloc][bloc] = result;
    }
}
