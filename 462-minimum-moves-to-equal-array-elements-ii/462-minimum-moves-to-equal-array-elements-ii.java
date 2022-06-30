//do it again
class Solution {
    public int minMoves2(int[] nums) {
        if(nums.length == 1) return 0;
        
        Arrays.sort(nums);
        
        int n = nums.length;
        int median = 0;
        
        if(n%2 == 0){
            median = (nums[n/2] + nums[n/2-1])/2;
        }
        else{
            median = nums[n/2];
        }
        
        int res = 0;
        
        for(int num : nums){
            res += Math.abs(num-median);
        }
        
        return res;
    }
}