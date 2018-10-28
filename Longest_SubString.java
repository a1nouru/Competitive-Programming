/*

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public static int find( String str){
         if (str == null || str.length() == 1) return 1;
         if(str.length() ==0) return 0;
         Map<Character, String> map = new HashMap<>();
         int count = 0;
         int max = 1;
         for (int i = 0; i < str.length(); i++){
             if (!map.containsKey(str.charAt(i))){
                 map.put(str.charAt(i), new String());
                 count ++;
                 max  = Math.max(max, count);
             }
             else {
                 count = 1;
                 map.remove(str.charAt(i));
             }
         }
         return max;
     }
