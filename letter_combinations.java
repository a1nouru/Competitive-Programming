// Author = 'Nouru Muneza'


package sample;
import java.util.*;

public class Main {

    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        result.add("");

        String[] map = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

       char [] x = digits.toCharArray();

       for(int i = 0; i < x.length; i++){

           ArrayList<String> temp = new ArrayList<>();
           for (char letter : map[x[i]-'0'].toCharArray()){
               for (String str : result){
                   temp.add(str + letter);
               }
           }
           result = temp;
       }
        Collections.sort(result); // sorting the list
        return result;
    }
    public static void main(String[] args) {
        String digits = "234";
        String[] map = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        char[] c = digits.toCharArray();
        for (int i = 0; i < c.length; i++) {
            String num = map[digits.charAt(i) - '0'];
            //System.out.println(num);
        }
        System.out.println(letterCombinations(digits));
    }
}
