/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // using two pointers technique we can solve this
        // given 2 linkedlists and there are some nodes that are repeated in both lists
        // if we calculate sum of both the linkedliists size will be some n
        // if we start 1 pointer at 1st list and 2nd one at 2nd list and when it reaches tail, reference it to other lists head and they'll meet at the intersection node; 
        // 
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        while(ptr1!=ptr2){
            // increment both the pointers
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            
            if(ptr1==ptr2){
                return ptr1;
            }
            
            // if ptr1 --> headA reaches tail, reference it to headB
            if(ptr1==null){
                ptr1 = headB;
            }
            
            // if ptr2 --> headB reaches tail, reference it to headA
            if(ptr2==null){
                ptr2 =headA;
            }
        }
        
        return ptr1;
    }
}