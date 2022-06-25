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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null ) return l1 != null ? l1:l2;
        
        ListNode c1 = reverseofll(l1);
        ListNode c2 = reverseofll(l2);

        ListNode head = new ListNode(-1);
        ListNode itr = head;
        
        int carry =0;
        
        while(c1 != null || c2 != null || carry != 0){
            int sum = carry + (c1 != null? c1.val:0) + (c2 != null? c2.val:0);
            int lg = sum % 10;
            carry = sum / 10;
            itr.next = new ListNode(lg);
            itr = itr.next;
            if(c1 != null) c1 = c1.next;
            if(c2 != null) c2 = c2.next;
        }
        return reverseofll(head.next);
    }
    //reverse of ll
     public static ListNode reverseofll(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        //ListNode forw = null;
        
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr= forw;
        }
        return prev;
    }
}