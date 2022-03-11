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
    public ListNode rotateRight(ListNode head, int k) {
        
        //edge cases
        if(head==null || head.next==null || k==0) {
            return head;
        }
        
        //calculate length of linked list
        ListNode dummy = head;
        int len = 1;
        while(dummy.next != null) {
            len++;
            dummy = dummy.next;
        }
        
        //reach to desired node
        dummy.next = head;
        k = k % len;
        k = len - k;
        
        while(k != 0) {
            dummy = dummy.next;
            k--;
        }
        
        //make the node head and break the connection
        head = dummy.next;
        dummy.next = null;
        
        return head;
        
    }
}