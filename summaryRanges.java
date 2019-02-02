/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*/

public static List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<String>();
        if(nums.length==0) return result;
        int curr=1,start=0;

        while(curr<=nums.length){
            if(curr==nums.length||nums[curr]-nums[curr-1]!=1){ //add item
                if(curr-1==start){
                    result.add(Integer.toString(nums[start]));
                }else{
                    result.add(Integer.toString(nums[start])+"->"+Integer.toString(nums[curr-1]));
                }
                start=curr; //increment
            }
            curr++;
        }
        return result;
    }
