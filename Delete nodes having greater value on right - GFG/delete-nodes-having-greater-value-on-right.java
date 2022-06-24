// { Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        // your code here
        if(head == null || head.next == null) return head;
        head = reverseofll(head);
        Node curr = head, prev = head;
        int max = head.data;
        while(prev.next != null){
            if(head.data >= max){
                max = head.data;
                prev = head;
                head = head.next;
            }else{
                prev.next = head.next;
                head = prev.next;
            }
        }
        head = reverseofll(curr);
        return head;
    }
    
     public static Node reverseofll(Node head) {
        if(head == null || head.next == null) return head;
        Node curr = head;
        Node prev = null;
        Node forw = null;
        
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr= forw;
        }
        return prev;
    }
}
  