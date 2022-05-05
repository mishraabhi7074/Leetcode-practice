class Solution {
    public int climbStairs_memo(int n, int[] dp) {
    if (n <= 1)
        return dp[n] = 1;
    if (dp[n] != 0)
        return dp[n];

    return dp[n] = climbStairs_memo(n - 1, dp) + climbStairs_memo(n - 2, dp);
  }
    public int climbStairs(int n) {
    int[] dp = new int[n + 1];
    return climbStairs_memo(n, dp);
  }
}