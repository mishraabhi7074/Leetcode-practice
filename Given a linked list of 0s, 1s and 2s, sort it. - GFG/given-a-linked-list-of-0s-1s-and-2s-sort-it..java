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
		   
		      head = new Solution().segregate(head);
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
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node zeroHead = new Node(-1);
        Node tempZero = zeroHead;
        Node oneHead = new Node(-1);
        Node tempOne = oneHead;
        Node twoHead = new Node(-1);
        Node tempTwo = twoHead;
        
        Node temp = head;
        
        while(temp != null)
        {
            if(temp.data == 0)
            {
                tempZero.next = new Node(temp.data);
                tempZero = tempZero.next;
            }
            else if(temp.data == 1){
                tempOne.next = new Node(temp.data);
                tempOne = tempOne.next;
            }else{
                tempTwo.next = new Node(temp.data);
                tempTwo = tempTwo.next;
            }
            
            temp = temp.next;
        }
        
        Node res = new Node(-1);
        
        if(zeroHead.next == null){
             
             if(oneHead.next == null){
                  return  twoHead.next; 
             }else{
                  tempOne.next = twoHead.next;
                  return oneHead.next;
             }
        }
        
         if(oneHead.next == null){
             
             
             if(twoHead.next == null){
                  return  zeroHead.next; 
             }else{
                  tempZero.next = twoHead.next;
                  return zeroHead.next;
             }
        }
        
        if(twoHead.next == null)
        {
            tempZero.next = oneHead.next;
            return zeroHead.next;
        }
        
        tempOne.next = twoHead.next;
        tempZero.next = oneHead.next;
        
        return zeroHead.next;
        
        
    }
}


