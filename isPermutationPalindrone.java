package sample;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.*;

/*

Given a string, determine if a permutation of the string could form a palindrome.

Example 1:
Input: "code"
Output: String is not Palindrome

Example 2:
Input: "aab"
Output: String is Palindrome

Example 3:
Input: "carerac"
Output: String is Palindrome

*/

public class Main {

   public static boolean isPermutationPalindrome(String tempStr){
        if(tempStr.isEmpty())
            return false; // Empty string(Base case)

        int[] howOften = new int[128];
        int countAdd = 0;

        //Constructing array of occurrences.
        for(int i = 0; i<tempStr.length(); i++) {
            int val = tempStr.charAt(i);
            howOften[val] = howOften[val] + 1;
        }

       for(int j = 0; j<tempStr.length(); j++) {
           int val = tempStr.charAt(j);
            if(howOften[val] % 2 != 0)
            {
                countAdd++;
                if((tempStr.length() % 2 == 0))
                return false;
            }
            if((tempStr.length() % 2 != 0) && (countAdd != 1) && countAdd != 0)
            {
                System.out.println(countAdd);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String tempStr = "code";
        if(isPermutationPalindrome(tempStr))
            System.out.println("String is Palindrome");
        else
            System.out.println("String is not Palindrome");
    }
}


