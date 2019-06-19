/*

Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
*/ 

class Solution {
    public List<Integer> findClosestElements(int []arr, int k, int x){
        if (arr.size() <= k ) return arr;
        
        //Binary search
        int lo = 0, hi = arr.size()-1;
        while (lo + 1 < hi){ //(lo+1 < hi) makes sure that smaller values are preferred if tie. 
            int mid = (lo + hi)/2;
            if (x > arr.get(mid)) lo = mid;
            else hi = mid; 
        }  
        LinkedList<Integer> res = new LinkedList<>();
        while (res.size() < k){
            //if lo = 0. Add arr.get(lo--) then next time we loop here lo == -1. So add arr.get(hi++) instead
            if (lo < 0) res.addLast(hi++); 
            else if (hi >= arr.size()) res.addFirst(lo --); 
            else if (Math.abs(arr.get(lo) - x) <= Math.abs(arr.get(hi)-x))
                res.addFirst(arr.get(lo--)); //How far from x is lo index and hi 
            else res.addLast(arr.get(hi++));
        }
    }
    return res;
}
