/*
[LeetCode] Valid Word Abbreviation Verify Word Abbreviations
 

Given a non-empty string  s and an abbreviation  abbr, return whether the string matches with the given abbreviation.

A string such as  "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", " 2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string  "word". Any other string is not a valid abbreviation of  "word".

Note: 
Assume  s contains only lowercase letters and  abbr contains only lowercase letters and digits.

Example 1:

Given s = "internationalization", abbr = "i12iz4n":

Return true.
 

Example 2:

Given s = "apple", abbr = "a2e":

Return false.
*/


Class Solution {
 public :
     bool validWordAbbreviation( string word, string abbr) {
         int m = word.size(), n = abbr.size(), p = 0 , cnt = 0 ;
         for ( int i = 0 ; i < abbr .size(); ++ i) {
             if (abbr[i] >= ' 0 ' && abbr[i] <= ' 9 ' ) {
                 if (cnt == 0 && abbr[i] == ' 0 ' ) Return False ;
                 //Converting str to int. 
                Cnt = 10 * cnt + abbr[i] - ' 0 ' ;
            } else {
                p += cnt;
                //If total count of length(number + char) 
                 //is greater than actual str.length or if char is not the same as one in original str return false. 
                 if (p >= m || word[p++] != abbr[i]) return  false ; 
                Cnt = 0 ;
            }
        }
        Return p + cnt == m;
    }
};
