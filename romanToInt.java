/*
Problem:

Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.

Method:

1. This problem has to use HashMap, since we need to quickly look up what does each character mean.
2. Thoughts: if the current char has greater or equal value than the next char, add it; else, minus it(case of IV == 4 so we subtracted I from V). 

*/

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        dict.put('I',1);
        dict.put('V',5);
        dict.put('X',10);
        dict.put('L',50);
        dict.put('C',100);
        dict.put('D',500);
        dict.put('M',1000);
         
        int res = 0;
         
        int i = 0;
         
        for (i = 0; i < s.length()-1; i++){
            if (dict.get(s.charAt(i)) >= dict.get(s.charAt(i+1))){
                res += dict.get(s.charAt(i));
            }else{
                res -= dict.get(s.charAt(i));
            }
        }
         
       res += dict.get(s.charAt(i));
       return res;
         
    }
}
