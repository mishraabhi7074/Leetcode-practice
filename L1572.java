class Solution {
    public int diagonalSum(int[][] mat) {
        
        int  diasum = 0;
        int n = mat.length;
        
        for(int i = 0; i < n; i++){
            diasum += mat[i][i] + mat[i][n-i -1];
        }
        
        if(n % 2 != 0) diasum -= mat[n/2][n/2];
        
        return  diasum;
    }
}

