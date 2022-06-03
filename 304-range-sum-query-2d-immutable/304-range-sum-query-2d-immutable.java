class NumMatrix {

   int[][] dp;
public NumMatrix(int[][] matrix) {
    int m = matrix.length+1;
    int n = matrix[0].length+1;
    dp = new int[m][n];
    
    for(int i = 1; i < m; i++){
        
        for(int j = 1; j < n; j++){
            
            dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
        }
    }
}

// O(1)
public int sumRegion(int row1, int col1, int row2, int col2) {

    int region1 = dp[row2+1][col2+1];
    int region2 = dp[row1][col2+1] + dp[row2+1][col1];
    int region3 = dp[row1][col1];
    return region1 - region2 + region3;
}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */