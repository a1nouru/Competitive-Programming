/*

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


*/


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> reached = new HashSet<>();
        Set<String> wrdList = new HashSet<>(wordList);
        reached.add(beginWord);
        if(!wrdList.contains(endWord)) return 0;
        int dist =1;
        // while we havent got to the end----- meaning reached does not contain endword.
        while(!reached.contains(endWord)){
            Set<String> toAdd =new HashSet<>();
            /* Why and how 3 nested loops? 
             for -------------> List words in reached leading to endWord. 
             So explore word by word as we get closer to endWord EX: "hit" -> "hot" -> "dot" -> "dog" -> "cog",
              for --------------> currIndex of S being changed
               for ------------> modify S.toCharArray() with 'a' -------- 'z'
            */
            //Pick up the last word that just got created EX: hit to hot(new word that just got added to reached).
            for(String s : reached){ 
                
                for(int i=0;i<s.length();i++) {
                    char[] carr= s.toCharArray();
                    for(char c='a';c<='z';c++)
                    {
                        carr[i]=c;
                        String str = String.valueOf(carr);
                        if(wrdList.contains(str)){
                            toAdd.add(str);
                            wrdList.remove(str); //removing possible duplicates being created
                        }
                    }
                }
            }
            dist++;
            if(toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return dist;
    }
}
