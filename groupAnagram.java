/*

49. Group Anagrams
Medium
1161
79


Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(String w : strs){
            String key = hash(w); // find hash key           
            if(!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(w);
        }
        
        return new ArrayList<>(map.values());
    }
    
    String hash(String s){
        int[] a = new int[26];
        for(char c : s.toCharArray()) a[c-'a']++; // occurance 
        return Arrays.toString(a);
    }
}
