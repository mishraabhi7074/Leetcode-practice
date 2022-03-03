class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int c=0;
        for(int i=0;i+2<nums.length;i++)
        {
            int a=0;
            int dif=nums[i+1]-nums[i];
            for(int j=i+1;j<i+3 || j<nums.length;j++)
            {
                if(nums[j]-nums[j-1]!=dif)
                {
                    a=1;
                    break;
                }
                if(j>=i+2)
                {
                    a=1;
                    c++;
                }
            }
            if(a==0)
                c++;
        }
        return c;
    }
}