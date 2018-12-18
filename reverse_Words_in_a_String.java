/*

Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.

*/

/*We start at the end of the string and find complete words from its last letter (integer i) to the first letter (integer j).
We know it is the first letter of the word if the character before it is a space (j - 1 == ' ').
After we find the first letter of the word, denoted by j, then we append it to our StringBuilder and add a space.
Since j - 1 is a space, in a normal sentence, j - 2 would be the next letter. So we set i = j - 2.
If i = j - 2 is still a space, we have a while loop to decrement i until it is not a space.
We do this until we reach the start of the string (index 0).
We take out the final space in our StringBuilder before returning the final String.
*/

public class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder(); 
        int i = s.length() - 1; 
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--; // in case we get strings like "   the sky    is blue"
            if (i >= 0) { // if i < 0 that means the first few characters were spaces (e.g. "    apple")
                int j = i;
                while (j > 0 && s.charAt(j - 1) != ' ') j--; // finding the first letter of the word (e.g. 'b' in "blue")
                builder.append(s.substring(j, i + 1));
                builder.append(" "); // this will add a space after every word
                i = j - 2;
            }
        }
        if (builder.length() > 0) builder.setLength(builder.length() - 1); // take out the space at the end
        return builder.toString(); 
    }
}
