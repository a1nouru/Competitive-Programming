/* 

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited=new boolean[nums.length];
        List list=new ArrayList();
        List<List<Integer>> result=new ArrayList<>();
        combine(nums,visited,list,result);
        return result;
    }
    public void combine(int[] nums,boolean[] visited,List list,List<List<Integer>> result){
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;//entry
                list.add(nums[i]);
                combine(nums,visited,list,result);
                //exit //to be the next starting num ie: if curr perm is 123 
                //the next will be 132 since visited at 2 is false
                visited[i]=false;
                list.remove(list.size()-1); //prevent list from filling allowing next num to be added 
            }
        }
    }
}
