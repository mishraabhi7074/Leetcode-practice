class Solution {
    // memoised solution
    public int climbStairs_memo(int n, int[] dp) {
    if (n <= 1)
        return dp[n] = 1;
    if (dp[n] != 0)
        return dp[n];

    return dp[n] = climbStairs_memo(n - 1, dp) + climbStairs_memo(n - 2, dp);
  }
    
    //tabulated solution
    public int climbStairs_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[N];
    }
    public int climbStairs(int n) {
      int[] dp = new int[n + 1];
      return climbStairs_tabu(n, dp);
  }
}