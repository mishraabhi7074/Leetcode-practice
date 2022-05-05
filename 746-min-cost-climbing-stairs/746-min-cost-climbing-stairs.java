class Solution {
   public int minCostClimbingStairs_memo(int[] cost, int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }

        if (dp[n] != 0)
            return dp[n];

        int fcall = minCostClimbingStairs_memo(cost, n - 1, dp);
        int scall = minCostClimbingStairs_memo(cost, n - 2, dp);
        int ans = Math.min(fcall, scall) + (n == cost.length ? 0 : cost[n]);

        return dp[n] = ans;
    }

    public int minCostClimbingStairs_tabu(int[] cost, int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = cost[n];
                continue;
            }

            dp[n] = Math.min(dp[n - 1], dp[n - 2]) + (n == cost.length ? 0 : cost[n]);
        }

        return dp[N];
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        return minCostClimbingStairs_memo(cost, n, dp);
    }
}