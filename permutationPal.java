/*
267. Palindrome Permutation II
Medium
182
28

Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

Example 1:

Input: "aabb"
Output: ["abba", "baab"]
Example 2:

Input: "abc"
Output: []
*/

class Solution{
    public List<String> generatePalindromes(String s) {
    List<String> res = new ArrayList<>();
        int[] table = new int[128];
        int cnt = 0;
        for(int i=0;i<s.length();i++){ //add occcurencies
            table[s.charAt(i)]++;
            cnt = (table[s.charAt(i)] % 2 == 0) ? cnt - 1 : cnt + 1;
        }
        if(s.equals("") || cnt > 1){ //edge case
            return res;
        }
        String temp = "";
        for(int i=0;i<128 && cnt == 1;i++){
            if(table[i] % 2 == 1){ //find mid index
                temp += (char) i; //i is char cause (char) changes to chr
                break;
            }
        }
        backtrackHelper(table,temp,res,s.length());

        return res;
    }

    public void backtrackHelper(int[] table,String curr,List<String> res,int l){
        if(curr.length() == l){ //base case if pal is equal == to string
            res.add(curr);
            return;
        }
        for(int i=0;i<128;i++){
            if(table[i] > 1){
                table[i] -= 2;
                char c = (char) i;
                String temp = c + curr + c;
                backtrackHelper(table,temp,res,l);
                table[i] += 2;
            }
        }
    }
}
