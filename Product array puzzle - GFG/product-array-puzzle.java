// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  

// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int arr[], int n) 
	{ 
        // code here
        // right side product array
        long [] right = new long[arr.length];
        long prd = 1;
        for(int i = arr.length-1; i >=0; i--){
            prd *= arr[i];
            right[i] = prd;
        }
        
        // result and left side product array
        prd =1;
        long[] res = new long[arr.length];
        for(int i =0; i < arr.length -1; i++){
            long lp = prd;
            long rp = right[i+1];
            res[i] = lp * rp;
            prd *= arr[i];
            
        }
        res[arr.length -1] = prd;
        return res;
	} 
} 
