class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n+1][n+2];
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i-1][j+1]))+matrix[i-1][j-1];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=1; j<n+1; j++) {
            ans = Math.min(ans,dp[n][j]);
        }
        return ans;
    }
}