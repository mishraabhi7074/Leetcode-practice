class Solution {
    public int numIslands(char[][] grid) {
        int lands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    lands++;
                    DFS(grid,i,j);
                }
            }
        }
        return lands;
    }
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public void DFS(char[][] grid,int row, int col){
        if (row < 0 || row >= grid.length || col < 0 || col >=grid[0].length || grid[row][col] == '0'){ 
           return;
        }
        grid [row][col] = '0';
        for(int [] curr:dirs){
            int x = row+curr[0];
            int y = col+curr[1];
            DFS(grid,x,y);
        }
    }
}