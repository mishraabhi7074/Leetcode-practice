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
    public ListNode swapNodes(ListNode head, int k) {
        
        
        // convert linkedlist to ArrayList
        ListNode node = head;
        List<ListNode> list = new ArrayList<>();
        
        while(node!=null)
        {
            list.add(node);
            node = node.next;
        }
        
        int len = list.size();
        
        //swap the values
        int temp = list.get(k-1).val;
        list.get(k-1).val =  list.get(len-k).val;
        list.get(len-k).val  = temp;
       
        return head;
        
    }
}