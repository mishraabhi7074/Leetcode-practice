class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, n = nums.length, maxSum = 0, sumSF = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sumSF += i * nums[i];
        }

        maxSum = sumSF;
        for (int i = 0; i < n; i++) {
            sumSF = sumSF - sum + n * nums[i];
            maxSum = Math.max(maxSum, sumSF);
        }

        return maxSum;
    }
}