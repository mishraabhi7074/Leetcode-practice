class Solution {
    List<List<String>> answer;
    public List<List<String>> solveNQueens(int n) {
        answer = new ArrayList<>();
        
        // creating a new n*n chess board
        char[][] chessBoard = new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessBoard[i][j] = '.';
            }
        }
        
        placeNQueens(chessBoard, 0, n); // starting from 0th row
        return answer;
    }
    
    public void placeNQueens(char[][] chessBoard, int row, int n){
        if(row == n){
            List<String> ans = generateList(chessBoard);
            answer.add(ans);
            return;
        }
        
        for(int col = 0; col<n; col++){
            if(isSafe(chessBoard, row, col, n)){
                chessBoard[row][col] = 'Q';
                placeNQueens(chessBoard, row+1, n);
                chessBoard[row][col] = '.';   
            }
        }
    }
    
    private List<String> generateList(char[][] board){
    
        List<String> list = new ArrayList<>();
        
        for(char[] chess:board){
            list.add(String.valueOf(chess));
        }
        return list;
    }
    
    
    public boolean isSafe(char[][] board, int row, int col, int n){
        // vertical safety
        
        for(int i=row-1, j=col; i>=0; i--){
            if(board[i][j]=='Q')
                return false;
        }
        
        // left diagonal
        
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q')
                return false;
        }
        
        // right diagonal
        
        for(int i=row-1, j = col+1; i>=0 && j<n; i--, j++){
            if(board[i][j]=='Q')
                return false;
        }
        
        return true;
    }
}