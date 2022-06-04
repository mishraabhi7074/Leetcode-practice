class Solution {
    public int[] twoSum(int[] nums, int target) {
         int max = nums.length; 
    for(int i = 0;i<max;i++)
    {
        int diff = target - nums[i];
        for(int j=i+1;j<max;j++)
        {
            if(nums[j] == diff)
            {
                return new int[]{i,j};
            }
        }
    }
    return new int[]{0,0};   
    }
}