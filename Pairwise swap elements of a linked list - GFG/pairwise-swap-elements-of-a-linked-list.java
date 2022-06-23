// { Driver Code Starts
import java.util.*;
import java.io.*;

public class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        	int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            HashMap<Node, Integer> mp = new HashMap<Node, Integer>();
            mp.put(head, head.data); 
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
                mp.put(tail, tail.data); 
            }
            
            Node failure = new Node(-1);
            
            Solution g = new Solution();
            head = g.pairwiseSwap(head);
            
            Node temp = head;
            int f = 0;
            while (temp != null) 
    		{ 
    			if(mp.get(temp) != temp.data){
    			    f = 1;
    			}
    			temp = temp.next; 
    		} 
            
            if(f==1){
                printList(failure); 
            }
            else{
                printList(head); 
            }
            t--;
        }
    } 
} 
   
// } Driver Code Ends


/* node class of the linked list

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

*/


class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
        // code here
        if(head == null || head.next == null) return head;
        Node oh = null ,ot = null;
        int len = length(head);
        Node curr = head;

        while(len >= 2){
            int tempk = 2;
             while(tempk-- > 0){
                 Node forw = curr.next;
                 curr.next = null;
                 addFirst(curr);
                 curr = forw;
             }
             if(oh == null){
                 oh = th;
                 ot = tt;
             }else{
                 ot.next = th;
                 ot = tt;
             }
             th = null;
             tt = null;
             len-= 2;

             ot.next = curr;
             

        }
        return oh;
    }
    
    //length of a linked list
    public static int length(Node node){
        int len =0;
        Node curr = node;
        while(curr != null){
          curr = curr.next;
          len++;
        }
        return len;
    }
    // add first
    static Node th = null;
    static Node tt = null;
    public static void addFirst(Node node){
        if(th == null){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }
}