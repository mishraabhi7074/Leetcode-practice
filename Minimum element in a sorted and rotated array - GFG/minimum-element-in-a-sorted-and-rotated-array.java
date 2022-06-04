// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int nums[], int n)
    {
        //complete the function here
        int lo = 0;
        int hi = nums.length -1;
        
        // if array is not rotated
        if(nums[lo] <= nums[hi]){
            return nums[0];
        }
        
        while(lo <= hi){
            int mid = (lo + hi)/2;
            
            if(nums[mid] > nums[mid +1]){
                return nums[mid + 1];
            }else if(nums[mid] < nums[mid -1]){
                return nums[mid];
            }else if(nums[lo] <= nums[mid]){
                lo = mid + 1;
            }else if(nums[mid] <= nums[hi]){
                hi = mid -1;
            }
        }
        return -1;
    }
}
