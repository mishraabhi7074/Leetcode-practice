class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return dfs(triangle, 0, 0, dp);
    }
    
    public int dfs(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        if(dp[row][col] != -1)
            return dp[row][col];
   
            int min = triangle.get(row).get(col);
            if(row < triangle.size()-1) {
                min = min + Math.min(dfs(triangle, row+1, col, dp),   dfs(triangle, row+1, col+1, dp));
            }
     return dp[row][col] = min; 
    }
}