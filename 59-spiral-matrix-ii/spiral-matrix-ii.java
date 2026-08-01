class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][] = new int[n][n];
        int startRow = 0;
        int startCol = 0;
        int endRow = n-1;
        int endCol = n-1;
        int val = 1;
        while(startRow<=endRow && startCol<=endCol) {
            for(int j=startCol; j<=endCol; j++) {
                mat[startRow][j] = val++;
            }
            for(int i=startRow+1; i<=endRow; i++) {
                mat[i][endCol] = val++;
            }
            if(startRow<endRow) {
                for(int j=endCol-1; j>=startCol; j--) {
                    mat[endRow][j] = val++;
                }
            }
            if(startCol<endCol) {
                for(int i=endRow-1; i>=startRow+1; i--) {
                    mat[i][startCol] = val++;
                }
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return mat;
    }
}