/*
Question: https://leetcode.com/problems/find-k-closest-elements/
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104

To be honest, if you don't think of a priority queue solution at first, don't beat your selfup. I also had a hard time figuring out that this is a priorityQueue problem. 

However, if you think of a general case plus a couple of clues given in the question; like: sorted array, and closest element, you figure out that you need to use a priorityQueue. 
You can also use Collection sort to solve this problem. 
*/
 
 public static List<Integer> find(int [] arr, int k, int x){
         //if repeat
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>{
            @Override
            public int compare(Integer o1, Integer o2){
                return Math.abs(o1 - x) - Math.abs(o2 - x);
            }
        });
         for(int i = 0; i < arr.length; i++) {
             pq.add(arr[i]);
         }
         List<Integer> results = new ArrayList<>();
         for(int i = 0; i < arr.length; i++){
             results.add(pq.poll());
         }
         Collections.sort(results);
         
         return results.subList(0,k);
     }
