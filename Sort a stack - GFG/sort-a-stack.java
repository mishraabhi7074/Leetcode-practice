// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> st)
	{
		//add code here.
		if(st.isEmpty()){
		    return null;
		}
		int temp = st.pop();
		sort(st);
		insert_at_correct_position(st, temp);
		return st;
	}
	public static void insert_at_correct_position(Stack<Integer> st, int temp){
	    if(st.isEmpty() || st.peek() < temp){
	        st.push(temp);
	        return;
	    }
	    int ele = st.pop();
	    insert_at_correct_position(st, temp);
	    st.push(ele);
	}
}