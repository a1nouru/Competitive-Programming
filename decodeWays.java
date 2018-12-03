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
        if(s == null || s.length() == 0) return 0;
        // Index to NumOfWays mapping
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>(); //Map to keep pre calculated totals. 
        return dfs(s, 0, memo);
    }
    
    private int dfs(String s, int start, Map<Integer, Integer> memo){
        if(start > s.length() + 1) return 0; //start goes beyond s.length()
        if(start == s.length()){ // we are at end of string
            return 1;
        } 
                    
        int total = 0;
        
        if(memo.containsKey(start)) return memo.get(start); //if total already calculted at a previsited startIndex. (DONT RE-CALCULATE)
        
        //choose single digit
        String currStr = s.substring(start, start + 1);
        Integer currInt = Integer.valueOf(currStr);
        if(currInt == 0) return 0;
        if(currInt >= 1 && currInt <= 26)
            total = dfs(s, start + 1, memo);

        //choose two digits (if possible)
        if(start < s.length() - 1){  //if start + 2 if within limit 
            currStr = s.substring(start, start + 2);
            currInt = Integer.valueOf(currStr);
            if(currInt >= 1 && currInt <= 26)
                total += dfs(s, start + 2, memo); //add pick 2 char rec call to pick 1 char. 
        }
        
        memo.put(start, total); //keep pre calculated totals at startIndex
        return total; //return total to calling rec call
    }
}
