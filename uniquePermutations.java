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
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permut(nums, new boolean[nums.length], nums.length, new ArrayList<>(), res);
        return res;
    }
    
    private void permut(int[] nums, boolean[] visited, int rest, List<Integer> cur, List<List<Integer>> res){
        if(rest == 0){ //nums.length == cur.length ? can also work 
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || (i != 0 && nums[i - i] == nums[i] && !visited[i - 1])) continue; //check for visit || or duplicate || prev not visited
            visited[i] = true;
            rest--;
            cur.add(nums[i]);
            permut(nums, visited, rest, cur, res);
            cur.remove(cur.size() - 1);
            rest++;
            visited[i] = false;
        }
    }
}
