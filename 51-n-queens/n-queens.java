class Solution {
    List<List<String>> list = new ArrayList<>();
    public void NQueens(String board[][], int row){
        if(row==board.length){
            add(board);
            return;
        }
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = "Q";
                NQueens(board, row+1);
                board[row][j] = ".";
            }
        }
    }
    public void add(String board[][]){
        List<String> l = new ArrayList<>();
        int n = board.length;
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                sb.append(board[i][j]);
            }
            l.add(sb.toString());
        }
        list.add(l);
    }
    public boolean isSafe(String board[][], int row, int col){
        for(int i=row-1; i>=0; i--){
            if(board[i][col].equals("Q")){
                return false;
            }
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j].equals("Q")){
                return false;
            }
        }
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j].equals("Q")){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        String board[][] = new String[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = ".";
            }
        }
        NQueens(board,0);
        return list;
    }
}