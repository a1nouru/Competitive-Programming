/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

*/

class Solution {
    
    //How this works: 
    
    /*
    water can only be trapped if the current index is under both left and right max(a valley). 
    The solution also calculates both valleys from left and from right depending 
    on if(height[p1] < height[p2]) 
    
    if(height[p1] < lmax)  means height[p1] is less than lMax and also height[p1] < height[p2] 
    which might be rmax or less than rmax, so either way we lmax is the min compared to rmax and height[p2]
    
    So basically we are calculating water traps both from right and left using current height[p1]/ left and 
    height[p2] / right while making sure that both current are under lmax and rmax. 
    */
    
    
     public int trap(int[] height) {
        int p1 = 0, p2 = height.length-1, total =0,
        lmax = 0, rmax = 0;
        while(p1 < p2)  
            if(height[p1] < height[p2]) 
                if(height[p1] < lmax)  total+=lmax-height[p1++]; else lmax = height[p1++]; 
            else
                if(height[p2] < rmax) total+=rmax-height[p2--]; else rmax = height[p2--];  
        return total;
    }
}
