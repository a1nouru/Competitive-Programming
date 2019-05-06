class Solution{
    public String minWindow(String s, String t){
        int [] table = new int ['z'+1];
        int counter = t.length(), begin = 0, end = 0, len = Integer.MAX_VALUE;
        String ans = "";
        for (char c : t.toCharArray()){ //calculating frequencies. 
            table[c]++;
        }

        while (end < s.length()){
            char endChar = s.charAt(end++);
            
            if(table[endChar] > 0) counter--; // if char if found in t and just got covered in current slidding window. 
            table[endChar]--;
            
            while(counter == 0){ //if all chars in t are covered in slidding window 
                if(end-begin < len){ // calc the new min window length 
                    len = end -begin; 
                    ans = s.substring(begin, end);
                }
                
                char beginChar = s.charAt(begin++);
                if (table[beginChar] ==0) counter++; //window cannot start with a char not from t. so counter ++ to indicate that there is a missing char in current window from t or duplicate if all chars are included. 
                table[beginChar]++; //removing from slidding window. 
            }
        }
        return ans;
    }
}

