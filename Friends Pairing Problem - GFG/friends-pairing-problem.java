// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
     public long friendsPairing_tabu(int N, long[] dp) {
        long mod = (long) 1e9 + 7;
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }
            dp[n] = (dp[n - 1] % mod + (dp[n - 2] % mod * (n - 1)) % mod) % mod;
        }

        return dp[N];
    }

    public long countFriendsPairings(int n) {
        long[] dp = new long[n + 1];
        long ans = friendsPairing_tabu(n, dp);
        return ans;
    }
}    
 