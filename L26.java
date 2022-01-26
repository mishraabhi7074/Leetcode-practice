class Solution {
  public int removeDuplicates(int[] nums) {
      int index = 1; 
      //index is initialise at 1 because first element can not be a repitive one
      for(int i = 1 ; i < nums.length ; i++){
          if(nums[i] != nums[i-1]){
              nums[index++] = nums[i];
             }
          } 
      return index;
  }
}