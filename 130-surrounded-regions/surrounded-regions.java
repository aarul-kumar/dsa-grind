class Solution {
    public void dfs(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='X' || grid[i][j]=='S') {
            return;
        }
        grid[i][j] = 'S';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
    public void solve(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='O' && (i==0 || i==board.length-1 || j==0 || j==board[0].length-1)) {
                    dfs(board, i, j);
                }
            }
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]!='S') {
                    board[i][j] = 'X';
                }
            }
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='S') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
}