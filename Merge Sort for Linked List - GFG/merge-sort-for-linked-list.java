// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null) return head;
        
        Node mid = midNode(head);
        Node nhead = mid.next;
        mid.next = null;

        Node l3 = mergeSort(head);
        Node l4 = mergeSort(nhead);

        return mergeTwoLists(l3, l4);
    }
    
    // midnode
    public static Node midNode(Node head) {
    
         if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            if(fast.next.next == null){
                slow = slow.next;
                fast = fast.next.next;
                return slow.next;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // merge two linked list
    public static Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1:l2;
        Node dummy = new Node(-1);
        Node prev = dummy;

        Node c1 = l1;
        Node c2 = l2;
        while(c1 != null && c2 != null){
            if(c1.data < c2.data){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }

            prev = prev.next;
        }
        prev.next = c1 != null ? c1:c2;
        return dummy.next;
    }
}


