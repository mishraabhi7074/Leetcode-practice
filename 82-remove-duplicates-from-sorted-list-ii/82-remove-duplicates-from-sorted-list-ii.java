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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode sortedList = new ListNode(0,head);
        ListNode current=null;
        ListNode prev = sortedList;
        boolean isDuplicate = false;
        while(head!=null)
        {
            current = head;
            isDuplicate = false;
            while(head.next!=null&&current.val==head.next.val)
            {
                isDuplicate = true;
                head = head.next;
            }
            if(isDuplicate)
            {
                prev.next = head.next;                
            }
            else
            {
                prev = prev.next;
            }
            head = head.next;
        }
        return sortedList.next;
    }
}