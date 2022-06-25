class Solution {
    public boolean checkPossibility(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                if(i<nums.length-2 && nums[i+2]<nums[i]){
                    nums[i]=nums[i+1];                    
                }
                else{
                    nums[i+1]=nums[i];
                }
                break;
            }
        }
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
}