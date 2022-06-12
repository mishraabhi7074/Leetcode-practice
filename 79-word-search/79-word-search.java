class Solution {
    private boolean search(char[][]arr, String s, int i, int j, int ind, boolean[][]visit){
        if(ind == s.length()){
            return true;
        }

        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j] != s.charAt(ind) || visit[i][j]){
            return false;
        }

        visit[i][j] = true;

        boolean up = search(arr, s, i-1, j, ind+1, visit);
        boolean down = search(arr, s, i+1, j, ind+1, visit);
        boolean right = search(arr, s, i, j+1, ind+1, visit);
        boolean left = search(arr, s, i, j-1, ind+1, visit);

        visit[i][j] = false;

        return up || down || right || left;
    }

    
    public boolean exist(char[][] arr, String s) {
        int n = arr.length;
        int m = arr[0].length;

        boolean[][]visit = new boolean[n][m]; 

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(s.charAt(0) == arr[i][j] ){
                    
                    if( search(arr, s, i, j, 0, visit)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}