// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
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
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0} ,{-1,1},{1,1},{1,-1},{-1,-1}};
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