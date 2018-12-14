/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/


class Solution {
    
    private static final String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (!digits.isEmpty()) {
            rec(digits, res, sb);            
        }
        return res;
    }
    
    public void rec(String digits, List<String> res, StringBuilder sb) {
        if (sb.length() == digits.length()){
            res.add(sb.toString());
            return; 
        } 
        String tempComb = map[digits.charAt(sb.length()) - '0'];
        for (int i = 0; i < tempComb.length(); ++i) {
            sb.append(tempComb.charAt(i)); //explore
            rec(digits, res, sb); //visit
            sb.deleteCharAt(sb.length()-1);//UnExplore or trackback
        }
    }
}
