/*
Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.
This is a famous Google interview question, also being asked by many other companies now a days.

Consider the following dictionary 
{ i, like, sam, sung, samsung, mobile, ice, 
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes 
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" 
or "i like sam sung".
*/

//For this problem assume we have a function that checks if a word isValid. 
public boolean wordBreak(String str){
  
  if(str.length == 0) return true; //Base case.
  
  for(int i = 1; i < str.length; i++){
    
    //Check validity of str.substring(0,i) and do rec call on str.substring(i, str.length-1)
    if(isValid(str.subString(0, i)) && wordBreak(i, str.length-1)){
      return true; //or add to list if problem says to add to list 
    }
  }
  return false;
}
