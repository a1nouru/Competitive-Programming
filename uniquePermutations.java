/*

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // Put all similar elements next to each other. 
        boolean [] visited = new boolean [nums.length];
        helper(nums, visited, new ArrayList<>());
        return res; 
    }
    
    public void helper(int [] nums, boolean [] visited, List<Integer> temp){
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return; 
        }
        
        for(int i = 0; i < nums.length; i++){
            if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) continue; //In a case where curr elemet is == to prev elem and prev element has been cleared to be used again.
            else {
                visited[i] = true;
                temp.add(nums[i]);
                helper(nums, visited, temp);
                visited[i] = false; 
                temp.remove(temp.size()-1);
            }   
        }
    }
}                                                                                       
