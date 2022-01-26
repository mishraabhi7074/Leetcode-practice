class Solution {
  public void rotate(int[] nums, int k) {
  k = k % nums.length;
  //part 1
  reverse(nums, 0, nums.length - k-1);
  //part 2
  reverse(nums, nums.length - k, nums.length -1);
  //part3
  reverse(nums, 0, nums.length -1);
  }
  
  public  void reverse(int[]nums, int i, int j){
  int li =i;
  int ri = j;
  while(li < ri){
      int temp = nums[li];
      nums[li] = nums[ri];
      nums[ri] = temp;
      
      li++;
      ri--;
  }
}
}