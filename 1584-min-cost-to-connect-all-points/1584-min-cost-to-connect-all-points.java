class Solution {
    public int minCostConnectPoints(int[][] points) {
    	int n = points.length, res = 0;
    	int[] minEdge = new int[n];
    	boolean[] used = new boolean[n];
    	Arrays.fill(minEdge, Integer.MAX_VALUE);
    	used[0] = true;  
    	for (int cnt = 1, cur = 0; cnt < n; cnt++) { 
    		int min = Integer.MAX_VALUE, next = 0;
    		for (int i = 0; i < n; i++)
    			if (!used[i]) {
	    			minEdge[i] = Math.min(minEdge[i], Math.abs(points[cur][0] - points[i][0]) + Math.abs(points[cur][1] - points[i][1]));
		    		if (min > minEdge[i]) {
		    			min = minEdge[i];
		    			next = i;
		    		}
	    		}
    		res += min;
    		cur = next;
            used[cur] = true;
    	}
    	return res;
    }
}