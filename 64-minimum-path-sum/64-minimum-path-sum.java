class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length, ER = n - 1, EC = m - 1;
        int[][] dp = new int[n][m];
        int[][] dir = { { -1, 0 }, { 0, -1 } };
        for (int er = 0; er <= ER; er++) {
            for (int ec = 0; ec <= EC; ec++) {
                if (er == 0 && ec == 0) {
                    dp[er][ec] = grid[er][ec];
                    continue;
                }

                int min = (int) 1e9;
                for (int d = 0; d < dir.length; d++) {
                    int r = er + dir[d][0];
                    int c = ec + dir[d][1];
                    if (r >= 0 && c >= 0 && r < n && c < m) {
                        min = Math.min(min, dp[r][c]);
                    }
                }
                dp[er][ec] = min + grid[er][ec];
            }
        }

        return dp[ER][EC];
    }
}