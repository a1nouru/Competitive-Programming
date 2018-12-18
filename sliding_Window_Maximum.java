/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
 */
    class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() + k <= i) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
            deque.offer(i);
            if (i >= k - 1) res[idx++] = nums[deque.peekFirst()];
        }
        return res;
    }
} 

