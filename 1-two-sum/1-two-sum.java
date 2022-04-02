class Solution {
    
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        int[] temparr = new int[2];
            for (int i = 0; i < nums.length; i++) {

                if(map.containsKey(target-nums[i])){
                     
                    temparr[0] = map.get(target - nums[i]);
                    temparr[1] = i;
                    return temparr;
                }

                else
                {
                    map.put(nums[i], i );
                }
                    
            
            }
            return temparr;
    }
}