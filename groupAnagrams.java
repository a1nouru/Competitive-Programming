/*
EX: 
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

*/
 
 public void groupAnagrams(List<String> list){

        if(list.size() <= 1) System.out.println("List is empty");

        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : list){
            int sumAscii = 0;
            for (char chr : str.toCharArray()){
               sumAscii += chr;
            }
            if(!map.containsKey(sumAscii)) map.put(sumAscii, new ArrayList<>());
            map.get(sumAscii).add(str);
        }
    }
