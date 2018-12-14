/*

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

*/

public boolean isMatch(String s, String p) {
  // pattern is empty 
  if (p.isEmpty()) return s.isEmpty();
  if(p.length()>1 && p.charAt(1)=='*'){ 
    // check with zero occurences || more than one occurance if s and p start with same char or '.'
      return isMatch(s,p.substring(2))||( !s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')
                                               && isMatch(s.substring(1),p));
  }
  else {
    //if s and p start with same char or '.' && s[1....n] and p[1...m] matches 
         return !s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')
                                               && isMatch(s.substring(1),p.substring(1));
        }
    }
