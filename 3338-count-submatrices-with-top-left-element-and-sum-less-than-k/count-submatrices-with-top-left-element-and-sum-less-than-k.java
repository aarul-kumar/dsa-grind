class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int matrix[][] = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 & j==0) {
                    matrix[i][j] = grid[i][j];
                } else if(i==0) {
                    matrix[i][j] = matrix[i][j-1] + grid[i][j];
                } else if(j==0) {
                    matrix[i][j] = matrix[i-1][j] + grid[i][j];
                } else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] + grid[i][j] - matrix[i-1][j-1];
                }
            }
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j]<=k) {
                    count++;
                }
            }
        }
        return count;
    }
}