/*

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
*/

class Solution1 {

    public List<Integer> findClosestK(int [] num, int k, int x){
        List<Integer> results = new ArrayList<>();
        PriorityQueue<Integer> pq  = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { //order by how far elem is from x 
                return Math.abs(o1 - x) - Math.abs(o2-x);
            }
        });

        for (int temp : num){
            pq.add(temp);
        }

        for (int temp : pq){
            results.add(pq.poll());
        }

        Collections.sort(results);

        return results.subList(0,k);
    }
}
