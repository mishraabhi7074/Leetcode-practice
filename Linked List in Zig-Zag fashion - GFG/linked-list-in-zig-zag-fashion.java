// { Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
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
        
        while(t-- > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            Solution g = new Solution();
            printList(g.zigZag(head));
        }
    } 
}
// } Driver Code Ends


/*Node is as follows:

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
	public static Node zigZag(Node head){
        //add code here.
        if(head == null || head.next == null) return head;
        Node node = head;
        boolean flag = true;
        while(node.next != null){
            if(flag){
                if(node.data > node.next.data){
                    int t = node.data;
                    node.data = node.next.data;
                    node.next.data = t;
                }
                flag = !flag;
              }else{
                  if(node.data < node.next.data){
                      int t = node.data;
                      node.data = node.next.data;
                      node.next.data = t;
                  }
                  flag = !flag;
              }
              node = node.next;
            }
            return head;
        }
    }










