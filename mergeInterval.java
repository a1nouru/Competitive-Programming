/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
     public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((i1, i2) -> i1.start - i2.start); //sort to order by interval.start to ascending
        int i = 0;
        while (i < intervals.size() - 1) {
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i + 1);    
            if (next.start <= curr.end) { //if merge 
                curr.end = Math.max(curr.end, next.end); //keep max end between curr and next 
                intervals.remove(i + 1);
            } else {
                i++;
            }
        }
        return intervals;
    }
}
