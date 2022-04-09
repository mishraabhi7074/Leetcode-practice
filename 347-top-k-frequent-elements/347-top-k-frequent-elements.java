class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1 );
        }
        
        System.out.println("Initial Mappings are: " + map);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);        
        
        for (int key : map.keySet())
        {
            pq.add(new int[]{key,map.get(key) } );
        }
        
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll()[0];
        }
        return ans;

    }
}