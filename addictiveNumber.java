/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 

Example 1:

Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199
*/

class Solution {
    public boolean isAdditiveNumber(String num) {
        String a = "";
        String b = "";
        for (int i = 0; i < num.length()/3; i++) {
            a = num.substring(0, i + 1);
            if (a.length() > 1 && a.charAt(0) == '0') {
                continue;
            }
            for (int j = i + 1; j < num.length(); j++) {
                b = num.substring(i + 1, j + 1);
                if (b.charAt(0) == '0' && b.length() > 1) {continue;}
                if (valid(num.substring(j + 1), Long.parseLong(a), Long.parseLong(b))) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean valid(String str, long a, long b) {
        long sum = a + b;
        String tempStr = String.valueOf(sum);
        int len = tempStr.length();
        if (str.length() < len) {return false;}
        if (str.length() == len && str.equals(tempStr)) {return true;}
        if (str.substring(0, len).equals(tempStr)) {
            return valid(str.substring(len), b, sum);
        }
        return false;
    }
}
