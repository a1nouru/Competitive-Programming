/*

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.

*/

/** 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode dummy=new ListNode(0), last=dummy, cur=last;
        cur.next=head;
        while(cur.next!=null){
            ListNode tail=cur, h=cur.next; cur=cur.next; ListNode second=cur.next;
            for(int i=1;i<=k;i++) {
                if(tail.next==null) return dummy.next; //we have got to end of list. 
                tail=tail.next; //Move tail to end of k list
            }
            ListNode next=tail.next; //point to next node of next k list group. 
            while(cur!=tail){
                ListNode nNext=second.next; // nNext would point to 3 for list 1->2->3->4->5 and k=2 for the first iter. 
                second.next=cur; cur=second; second=nNext;
            }
            last.next=tail; last=h;h.next=next; cur=h;
        }
        return dummy.next;
    }
}
