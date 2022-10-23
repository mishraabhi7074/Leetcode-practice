class Solution {
    private boolean isPossibleToPlaceNumber(char[][]board, int r , int c, int num){
        //row
        for(int i =0; i < 9; i++){
            if(board[i][c] - '0'== num) return false;
        }
        //col
        for(int j =0; j < 9; j++){
            if(board[r][j] - '0' == num) return false;
        }
        //3x3
        r = (r/3) * 3; // compression and decompression technique
        c = (c/3) * 3;
        for(int i =0; i < 3; i++){
            for(int j =0; j < 3; j++){
                if(board[r+i][c+j] -'0' == num) return false;
            }
        }
        return true;
    }
     public boolean sudokuSolver(char[][] board, ArrayList<Integer> list, int idx) {
        if (idx == list.size())
            return true;

        int r = list.get(idx) / 9;
        int c = list.get(idx) % 9;

        for (int num = 1; num <= 9; num++) {
            if (isPossibleToPlaceNumber(board, r, c, num)) {
                board[r][c] = (char) ('0' + num);

                if (sudokuSolver(board, list, idx + 1))
                    return true;

                board[r][c] = '.';
            }
        }

        return false;
    }
    public void solveSudoku(char[][] board) {
       ArrayList<Integer> list = new ArrayList<>();
       int n =9;
       for(int i =0; i < n; i++){
           for(int j =0; j < n; j++){
               if(board[i][j] == '.'){
                   list.add(i * n + j);
               }
           }
       }
        sudokuSolver(board, list, 0);
    }
}