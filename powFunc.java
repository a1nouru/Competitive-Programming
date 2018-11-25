/*

Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


*/


   class Solution {
       /*Reasoning behind this
       Given x^9 : Express it in Simpler form: 
       
       Subproblems:
       Case 1: x^9 = (x^8)* x = ((x*x)^4) * x 
       Case 2: X^8 = (X*X)^4
       */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        
        if (n < 0) 
            return 1 / x * myPow(1 / x, -(n + 1)); if n < 0 like x^-1 = 1/x 
        
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}



