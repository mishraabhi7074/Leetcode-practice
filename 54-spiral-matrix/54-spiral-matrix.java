class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int minr = 0;
        int minc = 0;
        int maxr = arr.length -1;
        int maxc = arr[0].length -1;
        int cnt =0;
        int tne = arr.length * arr[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(cnt < tne){
        //top wall
        for(int i = minr, j = minc; j <= maxc && cnt <tne; j++){
            list.add(arr[i][j]);
            cnt++;
        }
        minr++;
        //right wall
         for(int i = minr, j = maxc; i <= maxr && cnt <tne; i++){
            list.add(arr[i][j]);
            cnt++;
        }
        maxc--;
        //bottom wall
         for(int i = maxr, j = maxc; j >= minc && cnt <tne; j--){
            list.add(arr[i][j]);
            cnt++;
        }
        maxr--;
        //left wall
         for(int i = maxr, j = minc; i >= minr && cnt <tne; i--){
            list.add(arr[i][j]);
            cnt++;
        }
        minc++;
     }
        return list;
    }    
}