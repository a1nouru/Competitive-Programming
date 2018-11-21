/*

Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.

If there is no solution for the equation, return "No solution".

If there are infinite solutions for the equation, return "Infinite solutions".

If there is exactly one solution for the equation, we ensure that the value of x is an integer.

Example 1:

Input: "x+5-3+x=6+x-2"
Output: "x=2"
Example 2:

Input: "x=x"
Output: "Infinite solutions"

*/

    public String solveEquation(String equation) {
        int temp = 0;
        int sign = 1;

        // if is hasEqual sign = - sign
        boolean hasEqual = false;
        boolean hasNum = false;

        double co = 0;
        double num = 0;

        for (int i = 0; i < equation.length(); i++) {
            char cur = equation.charAt(i);

            if (cur >= '0' && cur <= '9') {
                temp = 10 * temp + cur - '0';
                hasNum = true;
                continue;
            }

            if (cur == 'x') {
                co += hasNum ? sign * temp :sign;

            } else {
                num += sign * temp;
                if (cur == '+') {
                    sign = 1;

                } else if (cur == '-') {
                    sign = -1;

                } else if (cur == '=') {
                    sign = 1;
                    hasEqual = true;
                }
                //after "=" inverse the sign
                if (hasEqual) {
                    sign = -sign;
                }
            }

            hasNum = false;
            temp = 0;
        }



        if (temp != 0) {
            num += sign * temp;
        }
        if (co == 0) {
            if (num == 0) {
                return "Infinite solutions";

            } else {
                return "No solution";
            }
        }
        int result = - (int)Math.round(num / co);
        StringBuilder sb = new StringBuilder();
        sb.append("x=").append(result);

        return sb.toString();
    }
