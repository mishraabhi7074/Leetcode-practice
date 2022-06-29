//do it again
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length - 1;i++){
            target -= nums[i];
            for(int j = i + 1;j < nums.length;j++){
                if(target == nums[j]){
                    return new int[]{i, j};
                }
            }
            target += nums[i];
        }
        return new int[]{-1, -1};
    }
}