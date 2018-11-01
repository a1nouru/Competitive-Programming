/*

Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

*/

  public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if(nums == null) return null;
        List<String> results = new ArrayList<String>();
        if(nums.length == 0) {
            mergeRanges(results,lower,upper);
            return results;
        }

        int tempLow;
        int tempUpper;

        if (nums.length == 1){
            if (lower+1 < nums[0]-1) //merge first
                mergeRanges(results, lower+1, nums[0]-1);
            else if (nums[0]+1 < upper-1)
                mergeRanges(results, nums[0]+1, upper);

            return results;

        }
        for (int i = -1; i < nums.length-1; i++){
            String tempStr = "";
            if (i == -1){

                tempLow = lower+1;
                tempUpper = nums[0] - 1;
                if (tempLow ==tempUpper )
                {
                    results.add(String.valueOf(tempLow));
                }
                else if(Math.abs(lower - nums[0]) != 0 && lower+1 != nums[0]) { //pre merge
                    mergeRanges(results, lower+1,nums[0]-1  );
                    continue;
                }
            }
            if (i == -1)
                i = 0;
            tempLow = nums[i]+1;
            tempUpper = nums[i+1]-1; //check for size 1
            if (tempUpper > tempLow ){
                mergeRanges(results, tempLow, tempUpper);
            }
            else if(tempLow == tempUpper) //single value
                results.add(String.valueOf(tempLow));
        }

        String tempStr = "";
        if(nums[nums.length-1] < upper) //merge end
        {
            tempLow = nums[nums.length-1]+1;
            mergeRanges(results, tempLow, upper);
        }
        return results;
    }

    public static void mergeRanges(List<String>results, int low, int upper){
        if (low == upper){
            results.add(String.valueOf(low));
            return;

        }
        String tempStr = "";
        tempStr += String.valueOf(low);
        tempStr +=  " -> ";
        tempStr += String.valueOf(upper);
        //System.out.println("HEY4");
        results.add(tempStr);
    }
