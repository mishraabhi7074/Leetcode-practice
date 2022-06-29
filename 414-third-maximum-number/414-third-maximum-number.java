class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int last = nums[nums.length-1];
        int max = last;
        int prev = last;
        int c = 1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]!=prev)
            {
                max = nums[i];
                prev = nums[i];
                c++;
                if(c==3)
                    break;
            }
        }
        if(c!=3)
            return last;
        return max;
    }
}