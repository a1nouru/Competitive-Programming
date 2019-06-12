/*

Given an unsorted array of integers, find the length of longest increasing subsequence.
Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
*/

//**BIG O(nlog(n))
public class Solution{
    public int lengthOfLIS(int [] nums){
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        
        for(int num : nums){
            if (list.isEmpty() || list.get(list.size()-1) < num) // increasing senquence. 
                list.add(num);
            else {
                int index = binarySearch(list, 0, list.size()-1, num);
                list.set(index, num);
            }
        }
        return list.size();
    }
    
    public int binarySearch(List<Integer> list, int start, int end, int val){
        while(start <= end){
            int mid = (start + end)/2;
            if (val > list.get(mid)) start = mid+1;
            else if (val < list.get(mid)) end = mid-1;
            else return mid;
        }
        return start; 
    }
}




