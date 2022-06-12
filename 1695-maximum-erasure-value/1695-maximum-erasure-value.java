class Solution {
public int maximumUniqueSubarray(int[] nums) {
int res =0 , sum =0;
int n = nums.length;
HashMap<Integer,Integer> hm = new HashMap<>();
int[] prefixsum = new int[n+1];
int maxscore = 0;
int l =0 ;
for(int r =0 ;r<nums.length ;r++){
prefixsum[r+1] = prefixsum[r] + nums[r] ;

    if(hm.containsKey(nums[r])){
      l = Math.max(l,hm.get(nums[r])+1);
     
    }
    maxscore = Math.max(maxscore,prefixsum[r+1]-prefixsum[l]);
    hm.put(nums[r],r);
  }
  return maxscore;
 }
}    