/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container,such that the container contains the most water.
Note: You may not slant the container and n is at least 2.
The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/
 
 
 public static int findMaxArea(int [] arr){
        if(arr == null || arr.length == 0 ) return 0;
        if (arr.length == 2) return 2 * Math.min(arr[0],arr[1]);
        int left = 0;
        int right = arr.length-1;
        int max = 0;
        while(left < right){
            max = Math.max(max, ((right - left) * Math.min(arr[left], arr[right])));
            if (arr[left] < arr[right])
                left++;
            else
                right--;
        }
        return max;
    }
