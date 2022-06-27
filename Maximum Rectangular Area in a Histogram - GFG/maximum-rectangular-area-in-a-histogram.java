// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long a[], long n) 
    {
        // your code here
    long [] rb = new long[a.length];
    Stack<Integer> st = new Stack<>();
    st.push(a.length -1);
    rb[a.length -1] = a.length;
    for( int i = a.length -2; i >= 0; i--){
        while(st.size() > 0 && a[i] <= a[st.peek()]){
            st.pop();
        }
        if( st.size() ==0){
            rb[i] = a.length;
        }else{
            rb[i] = st.peek();
        }
        st.push(i);
    }
    // next smallest element to the lest
    long [] lb = new long[a.length];
    st = new Stack<>();
    st.push(0);
    lb[0] = -1;
    for( int i =1;  i < a.length; i++){
        while(st.size() > 0 && a[i] <= a[st.peek()]){
            st.pop();
        }
        if( st.size() ==0){
            lb[i] = -1;
        }else{
            lb[i] = st.peek();
        }
        st.push(i);
    }
    // area
    long maxArea =0;
    for( int i =0; i < a.length; i++){
        long width = rb[i] - lb[i] -1;
        long area = a[i] * width;
        if(area > maxArea){
            maxArea = area;
        }
    }
    return maxArea;
    }
        
}



