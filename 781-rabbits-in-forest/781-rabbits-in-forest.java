class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : answers){
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        int ans =0;
        
        for(int keys:map.keySet()){
            int gs = keys + 1;
            int reportees = map.get(keys);
            int ng = (int)Math.ceil(reportees * 1.0 / gs * 1.0);
            ans += ng * gs;
        }
        return ans;
    }
}