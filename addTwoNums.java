/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1,l2,0);
    }
    
    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) return carry == 0? null : new ListNode(carry); //in case last 2 nodes have carry return new ListNode(carry) to keep the last carry. 
        
        int v1 = l1 == null? 0 : l1.val;
        int v2 = l2 == null? 0 : l2.val;
        
        int val = (v1 + v2 + carry) % 10; // add carry from previous addition or calling func and mod because that's what we keep. remainder 
        int carry2 = (v1 + v2 + carry) / 10; //calculate new carry 
        ListNode head = new ListNode(val); 
        
        head.next = helper(  l1 == null? null : l1.next, l2 == null? null : l2.next, carry2);
        
        return head; //is executed during retrival of call from prev rec call hence giving helper(l1, l2, carry2) == head to head.next. 
        
    }
}
