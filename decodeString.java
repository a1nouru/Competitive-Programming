/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/

class Solution {
    private int i = 0; //global i incremented everytime we see '['
    
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '[') {
                i++; //increment every time we are about 
                //get string inside [] --> this is enabled by else sb.append(c)
                String str = decodeString(s); 
                for (int k = 0; k < num; k++) {
                    sb.append(str); //repeat str num times 
                }
                num = 0;
            } else if (c == ']') { //end of string inside []
                return sb.toString();
            } else if (c >= '0' && c <= '9') { //check for num 
                num = num * 10 + c - '0'; //num*10 because ex: 32[a]
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
