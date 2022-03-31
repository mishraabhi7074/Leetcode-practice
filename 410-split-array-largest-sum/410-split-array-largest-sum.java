class Solution {
    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        
        int mid = 0, pieces;
        
        while (start < end) {
            mid = start + (end - start) / 2;
            
            pieces = 1;
            int sum = 0;
            for (int num : nums) {
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                }
                else {
                    sum += num;
                }
            }
            if (pieces > m) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}