class Solution {
    public int deleteAndEarn(int[] nums) {
        int dp[] = new int[10001];
        int inc = 0,exc = 0,max = 0;
        
        for(int i = 0;i<nums.length;i++){
            dp[nums[i]]++;
            max =  Math.max(nums[i],max);
        }
        
        for(int i = 1;i<=max;i++){
            int n_inc = exc + (i*dp[i]);
            int n_exc = Math.max(inc,exc);
            inc = n_inc;
            exc = n_exc;
        }
        
        return Math.max(inc,exc);
    }
}