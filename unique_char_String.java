package sample;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.*;

/*

Question: Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures? Meaning no hashTable(Life would be so much easier).

******* Reasoning behind code: ********
create an array of boolean values, where the flag at index i indicates whether character i in the alphabet is
contained in the string. The second time you see this character you can immediately return false.

*/

//The time complexity:BigO(n), in case a string a unique, for loop runs throught the whole string of n size. 
//The space complexity: BigO(1).

public class Main {

   public static boolean isUnique(String tempStr){
        if(tempStr.length() > 128)
            return false; // you can't form a string of more than 128 unique characters

        boolean[] found = new boolean[128];
        for(int i = 0; i<tempStr.length(); i++){

            int indexVal = tempStr.charAt(i);
            if(found[indexVal]){
                return false; // we have already seen this character
            }
            else
                found[indexVal] = true;
        }
        return true;
    }

    public static void main(String[] args) {

        String tempStr = "nameska";
        if(isUnique(tempStr))
            System.out.println("String is unique");
        else
            System.out.println("String is not unique");
    }
}
