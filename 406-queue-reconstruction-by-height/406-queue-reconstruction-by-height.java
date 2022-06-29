//do it again
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        LinkedList<int[]> list = new LinkedList();
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for(int[] p: people) {
            map.putIfAbsent(p[0], new TreeSet());
            map.get(p[0]).add(p[1]);
        }
        
        for(int key: map.keySet()) {
            for(int v: map.get(key)) {
                list.add(v, new int[]{key, v});
            }
        }
        
        int[][] ans = new int[people.length][2];
        int i = 0;
        for(int[] ele: list) {
            ans[i] = ele;
            i++;
        }
        return ans;
    }
}