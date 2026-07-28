class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int dp[][] = new int[n+1][m+1];
        for(int j=0; j<=m; j++) {
            dp[n][j] = Integer.MAX_VALUE;
        }
        for(int i=0; i<=n; i++) {
            dp[i][m] = Integer.MAX_VALUE;
        }
        dp[n][m-1] = 1;
        dp[n-1][m] = 1;
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}