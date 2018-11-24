/*

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/
 public static void productOfAllButSelf(int [] nums){
        int [] results = new int [nums.length];

        int [] left = new int [nums.length];
        int [] right  = new int [nums.length];

        left[0] = 1;
        right[nums.length-1] = 1;

        for(int i = 0; i < nums.length-1; i++){ //scan from left to right 
            left[i+1] = nums[i] * left[1];
        }

        for(int i = nums.length-1; i > 0; i--){ //scan from right to left 
            right[i-1] = right[i] * nums[i];
        }

        for(int i=0; i<nums.length; i++){ //left * right 
            results[i] = right[i] * left[i];
        }
        print(results);
        //return results;
    }

//**********************Space O(1)********************
public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length]; //result not counted as extra space created as it is used for output
 
    result[nums.length-1]=1; //scan from right to left 
    for(int i=nums.length-2; i>=0; i--){ 
        result[i]=result[i+1]*nums[i+1];
    }
 
    int left=1;
    for(int i=0; i<nums.length; i++){
        result[i]=result[i]*left;
        left = left*nums[i];
    }
 
    return result;
}
