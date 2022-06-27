// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        int res[] = new int[n];
        res[0] = 1;
        for(int i=1;i < n; i++)
        {
            int count = 1;
            int j = i-1;
            if(price[i] >= price[i-1])
            {
                count += res[j];
                j = i - res[j]-1;
            }
           
            while(j >= 0 && price[i] >= price[j])
            {
                count++;
                j--;
            }
            res[i] = count;
        }
        return res;
    }
}