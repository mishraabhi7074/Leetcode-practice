class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] efforts = new int[m][n]; 
        for(int i = 0; i < m; i++)
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        //dist, row, col --> int[]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,0,0});
        
        int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            int[] min = pq.poll();
            int dist = min[0], row = min[1], col = min[2];
            if(dist > efforts[row][col])
                continue;
            if(row == m-1 && col == n-1)
                return dist;
            for(int[] d : dir){
                int newRow = row+d[0];
                int newCol = col+d[1];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n){
                    int newDist = Math.max(dist, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if(newDist < efforts[newRow][newCol]){
                        efforts[newRow][newCol] = newDist;
                        pq.offer(new int[]{newDist, newRow, newCol});
                    }
                }
            }
        }
        return 0;
    }
}