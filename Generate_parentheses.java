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

public class Main {
    public static List<String> para(int n){
        List<String> list = new ArrayList<>();

        dfs(list, "", n,n);
        return list;
    }
    public static void dfs(List<String> results, String s, int left, int right){
        if(left > right) return;

        if (left == 0 && right ==0){
            results.add(s);
            return;
        }

        if (left > 0){
            dfs(results, s+'(', left-1, right+1 );
        }

        if (right > 0)
            dfs(results, s+')', left, right-1);
    }
