class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
               if(visited[i][j] == false && grid[i][j] == '1'){
                   count++;
                   traversal(grid, visited, i, j);
                   
               }   
            }
        }
        return count;
    }
    
    public void traversal(char[][] grid, boolean[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }else if(visited[i][j] == true){
            return;
        }else if(grid[i][j] == '0'){
            return;
        }
        visited[i][j] = true;
        traversal(grid, visited, i-1, j);
        traversal(grid, visited, i+1, j);
        traversal(grid, visited, i, j-1);
        traversal(grid, visited, i, j+1);
    }
}