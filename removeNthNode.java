/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
*/

public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1), pre = dummy, t = dummy;
        dummy.next = head;
        while(n-- >= 0) t = t.next;
        while(t != null) {
            pre = pre.next;
            t = t.next;
        }
        
        pre.next = pre.next.next;
        return dummy.next;
    }
