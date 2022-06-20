/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
            ListNode c1 = head;
            ListNode c2 = head;
        while(n-- > 0){
            c2 = c2.next;
        }
        if(c2 == null){
            return head.next;
        }
        while(c2.next != null){
            c1 = c1.next;
            c2 = c2.next;
        }
        c1.next = c1.next.next;
        return head;
    }
}