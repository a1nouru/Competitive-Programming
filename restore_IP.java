/*
R
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

*/


class Solution {
    public List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    util(ans, new ArrayList<>(), 0, s.toCharArray());
    return ans;
}

public void util(List<String> ans, List<String> tillNow, int start, char[] orig) {
    if(tillNow.size() == 4) {
        if(start == orig.length)
            ans.add(tillNow.get(0) + "." + tillNow.get(1) + "." + tillNow.get(2) + "." + tillNow.get(3));
        return;
    }
    for( int i = 0; i < 3 && start + i < orig.length; i++) {
        
        String slot = String.valueOf(orig, start, i+1);
        Integer curr = Integer.valueOf(slot);
        
        if( curr <= 255) { //Bounds 
            tillNow.add(slot);
            util(ans, tillNow, start+i+1, orig);
            tillNow.remove(tillNow.size()-1);
        }
        if((orig[start+i] == '0' && i == 0)) break;
    }
}
}
