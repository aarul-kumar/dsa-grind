class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int m = amount;
        int dp[][] = new int[n+1][m+1];
        for(int j=1; j<m+1; j++) {
            dp[0][j] = Integer.MAX_VALUE-1;
        }
        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(coins[i-1]<=j) {
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m]==Integer.MAX_VALUE-1?-1:dp[n][m];
    }
}