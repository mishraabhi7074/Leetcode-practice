class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int[] count = new int[n];
        int[] dp = new int[n];
        int maxLen = 0, maxCount = 0;

        for (int i = 0; i < n; i++) {
            count[i] = 1;
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 == dp[i])
                        count[i] += count[j];
                    else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }

            }

            if (maxLen == dp[i])
                maxCount += count[i];
            else if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxCount = count[i];
            }
        }

        return maxCount;
    }
}