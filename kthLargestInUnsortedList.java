/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
*/

/*HOW THIS WORKS:
    Find num of elements less than current mid, then move left or right depending on this.  
*/
class Solution{
    public int findKthLargest(int [] nums, int k){
        int lo = nums[0], hi = nums[0], n = nums.length;
        
        for (int i = 1; i < n; i ++){ // Get max and min. 
            lo = Math.min(lo, nums[i]);
            hi = Math.max(hi, nums[i]);
        }
        
        while (lo < hi){
            int mid = lo + (hi - lo)/2, count = 0;
            
            for (int i =0; i < n; i++)
                if (nums[i] <= mid) count++; // Nums of elem less than current mid. 
            
            if (count <= (n-k)) lo = mid + 1; 
            else hi = mid;
        }
        return lo;
    }
}

