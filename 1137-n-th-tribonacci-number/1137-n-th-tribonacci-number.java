class Solution {
   public int tribonacci_memo(int n, int[] dp) {
        if (n <= 2) {
            return dp[n] = (n == 0 ? 0 : 1);
        }

        if (dp[n] != 0)
            return dp[n];
        return dp[n] = tribonacci_memo(n - 1, dp) + tribonacci_memo(n - 2, dp) + tribonacci_memo(n - 3, dp);
    }

    public int tribonacci_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 2) {
                dp[n] = (n == 0 ? 0 : 1);
                continue;
            }

            dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
        }

        return dp[N];
    }

    public int tribonacci_opti(int N) {
        int a = 0, b = 1, c = 1;
        for (int n = 0; n < N; n++) {
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }

        return a;
    }

    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        int ans = tribonacci_memo(n, dp);
        //display(dp);
        return ans;
    }
}