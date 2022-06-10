// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        int i =0;
        for(i = N-2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                break;
            }
        }
        if(i >= 0){
            for(int j = N -1; j >=i; j--){
                if(arr[j] >arr[i]){
                    swap(arr, i, j);
                    break;
                }
            }
        }
        
        reverse(arr, i+1, N-1);
        
        List<Integer> list = new ArrayList<>();
        for(int x : arr){
            list.add(x);
            
        }
        return list;
        
    }
    
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void reverse(int [] arr, int s, int e){
        while(s <= e){
            swap(arr ,s++, e-- );
        }
    }
}













