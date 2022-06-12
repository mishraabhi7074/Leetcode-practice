class Solution {
    public void setZeroes(int[][] matrix) {
        int row0=1;
        int col0=1;
        for(int row = 0; row < matrix.length;row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(row==0){
                    if(matrix[row][col] == 0) row0=0;
                }
                if(col==0){
                    if(matrix[row][col] ==0) col0=0;  }
                
                if(matrix[row][col] ==0){
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
                 }        
        }
        for(int row=1; row<matrix.length;row++){
            for(int col=1; col<matrix[0].length;col++){
                if(matrix[row][0] == 0 || matrix[0][col] ==0){
                    matrix[row][col] =0;
                }
            }
        }
      for(int col=0; col<matrix[0].length;col++){
          if(row0 == 0){
              matrix[0][col] = 0;
          }
      }
      for(int row=0; row<matrix.length;row++){
          if(col0 == 0){
              matrix[row][0] = 0;
          }
      }
}    
}