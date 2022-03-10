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
    public ListNode add(ListNode l1, ListNode l2,int c){
        if(l1 == null && l2==null && c==0 ){
            return null;
        }
        int ans = (l1!=null?l1.val:0)+(l2!=null?l2.val:0)+c;
        ListNode list = new ListNode(ans%10);
        list.next = add(l1!=null?l1.next:null,l2!=null?l2.next:null,ans/10 );
        return list;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       return  add(l1,l2,0);

    }
}