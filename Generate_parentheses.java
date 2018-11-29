/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */

class Solution {
 public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, StringBuilder str, int open, int close, int max){
        
        if(str.length() == max*2){ //stopping condition, which should be at top everytime you write a backTrack solution
            list.add(str.toString());
            return;
        }
        
        if(open < max){
            backtrack(list, str.append("("), open+1, close, max); //Entreé
            str.deleteCharAt(str.length()-1); //Exit 
        }
        if(close < open){
            backtrack(list, str.append(")"), open, close+1, max); //Entreé
            str.deleteCharAt(str.length()-1); //Exit 
        }
    }
}
