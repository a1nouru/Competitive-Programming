


//Question proved to be a bit more challenging than I though 

//Big O (n) -> there is a nested loop inside but only get's executed if all characters in T are found in S so overall Big O(n)
public static String minWindow(String S, String T){
        if(S == null || S.length() == 0) return "";

        if (T.length() > S.length()) return "";

        HashMap<Character, Integer> mapT = new HashMap<>();
        HashMap<Character, Integer> mapS = new HashMap<>();

        for(Character chr : T.toCharArray()){
            if(mapT.containsKey(chr)){
                mapT.put(chr, mapT.get(chr)+1); // if already there
            }
            else
                mapT.put(chr, 1);
        }

        int start = 0;
        int end = 0;
        int counter = 0;
        int minLength = Integer.MAX_VALUE;
        int start_index = 0;

        for (int i = 0; i < S.length(); i++){
            char tempChar = S.charAt(i);
            mapS.put(tempChar, mapS.get(tempChar) + 1);

            if(mapT.get(tempChar) != 0 && mapS.get(tempChar) > mapT.get(tempChar)){ //char in T found in S
                counter++;
            }

            if(counter == T.length()){

                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence  in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while(mapS.get(S.charAt(start)) > mapT.get(S.charAt(start)) || !mapT.containsKey(S.charAt(start))){
                    if (mapS.get(S.charAt(start)) > mapT.get(S.charAt(start))){
                        mapS.put(S.charAt(start), mapS.get(S.charAt(start))-1);
                        start++;
                    }
                }

                // update window size
                int len_window = i - start + 1;
                if (minLength > len_window)
                {
                    minLength = len_window;
                    start_index = start;
                }
            }
        }
        return S.substring(start_index, start_index+minLength);
    }
}
