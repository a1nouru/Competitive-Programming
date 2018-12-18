/*

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

*/

class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        int carry = 0;
        char[] result = a.toCharArray();
        for(int i = 0; i < result.length; i++) {
            if(i >= b.length() && carry == 0) {
                return new String(result);
            }
            int sum = (result[result.length - 1 - i] - '0') + carry;
            if(i < b.length()) {
                sum += (b.charAt(b.length() - 1- i) - '0');
            }
            result[result.length - 1 - i] = (char) (sum % 2 + '0');
            carry = sum / 2;
        }
        if(carry == 1) {
            return "1" + new String(result);
        }

        return new String(result);
    }
}
