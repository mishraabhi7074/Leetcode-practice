class Solution {
  public int singleNumber(int[] nums) {
      int cnt = 0;
      for(int i : nums){
          //bit manipulation used here
          cnt ^= i;
      }
      return cnt;
  }
}