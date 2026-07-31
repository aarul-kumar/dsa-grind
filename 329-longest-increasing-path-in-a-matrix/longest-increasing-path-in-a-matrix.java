class Solution {
    public int dfs(int matrix[][], int i, int j, int dp[][]) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length) {
            return 0;
        }
        if(dp[i][j]!=0) {
            return dp[i][j];
        }
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        if(j-1>=0 && matrix[i][j-1]>matrix[i][j]) {
            left = dfs(matrix, i, j-1, dp);
        }
        if(j+1<matrix[0].length && matrix[i][j+1]>matrix[i][j]) {
            right = dfs(matrix, i, j+1, dp);
        }
        if(i-1>=0 && matrix[i-1][j]>matrix[i][j]) {
            top = dfs(matrix, i-1, j ,dp);
        }
        if(i+1<matrix.length && matrix[i+1][j]>matrix[i][j]) {
            bottom = dfs(matrix, i+1, j, dp);
        }
        return dp[i][j] = Math.max(left, Math.max(right, Math.max(top, bottom)))+1;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }
        return ans;
    }
}