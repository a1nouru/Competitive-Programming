/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.


*/

class Solution {
    HashMap<Integer,Integer> result = new HashMap<>();
    public int numSquares(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(result.containsKey(n)){
            return result.get(n);
        }
        int max = (int)Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for(int i=max;i>=1;i--){
            int c = numSquares(n - i*i)+1;
            min = Math.min(min,c);
        }
        result.put(n,min);
        return min;
    }
}
