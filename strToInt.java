//Always make sure all base cases are covered. I've also learnt to plan and think of the whole 
//code thoroughly before moving on to the coding part

//Question from Leetcode. 
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.


class Solution {
    boolean isNegative = false;
    int i = 0; // string iterator position

    public int myAtoi(String str) {
        int solution = 0;

        if (str == null || str.isEmpty()) {
            return 0;
        }
        while (i < str.length() && str.charAt(i) == ' ') {
            i++; // discard leading whitespace
        }
        checkSign(str);
        for (; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int prev = solution; // keep solution from last iter to check for overflow
                solution = solution*10; // move number left one position
                solution = solution+(str.charAt(i)-'0'); // increase solution by curr integer
                if (isOverflow(prev, solution)) {
                    if (isNegative) {
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                }
            } else {
                return signSolution(solution); // we've reached a non-integer character before end of string
            }
        }
        return signSolution(solution); // last character of string is an integer
    }

    boolean isOverflow(int prev, int curr) {
        // prev = value at last iteration
        // curr = value after current iteration
        if (curr/10 == prev) {
            return false;
        }
        return true;
    }

    void checkSign(String str) {
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            isNegative = true;
            i++;
        }
    }

    int signSolution(int solution) {
        if (isNegative) {
            return solution*-1;
        }
        return solution;
    } 
  }
