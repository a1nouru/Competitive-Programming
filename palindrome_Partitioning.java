/*

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

*/

class Solution {
    List<List<String>> res;
    String str; 
    public List<List<String>> partition(String s) {
        res = new LinkedList<>(); 
        str = s; 
        backTrack(new LinkedList<String>(), 0);
        return res;
    }
    
    void backTrack(List<String> tmp, int start) {
        if (start == str.length()) {
            res.add(new LinkedList<String>(tmp));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) { 
                tmp.add(str.substring(start, i + 1)); 
                backTrack(tmp, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }            
    }
    
    boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true; 
    }
}
