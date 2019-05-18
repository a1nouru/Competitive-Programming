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
    The desired area is a valley. 
    We have curr p1 and p2 which are indexes from left p1 and p2 from right. 
    we can only have a valey on the left if p1 < p2 and p1 < lmax and then we calculate water trapped as lmax - arr[p1]
    
    //Same applies to p2 from the right. 
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
