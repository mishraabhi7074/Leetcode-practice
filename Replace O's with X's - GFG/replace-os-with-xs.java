// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char board[][])
    {
        // code here
    if(board.length == 0) return board;
      for(int i=0; i < board[0].length; i++){
       if(board[0][i] =='O') DFS(board,0,i);
       if(board[board.length-1][i] == 'O') DFS(board, board.length-1, i);
      }

      for(int i =0; i < board.length; i++){
        if(board[i][0] =='O') DFS(board,i,0);
        if(board[i][board[0].length-1] == 'O') DFS(board, i, board[0].length -1);
      }

      for(int i =0; i < board.length; i++){
          for(int j =0; j < board[0].length; j++){
              if(board[i][j] == '#') board[i][j] ='O';
              else if(board[i][j] == 'O') board[i][j] ='X'; 
          }
      }
      return board;
    }

     static void DFS(char[][] board, int i, int j){
        if(i <0 || j <0|| i >= board.length || j >=board[0].length || board[i][j] != 'O') return;
        board[i][j] = '#';
        DFS(board, i+1,j);
        DFS(board, i-1,j);
        DFS(board, i, j+1);
        DFS(board, i, j-1);
     }
    }
