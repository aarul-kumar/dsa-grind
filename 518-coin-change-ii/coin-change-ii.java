class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        int n=dp.length;
        int m=dp[0].length;
        for(int i=0; i<n; i++) {
            dp[i][0]=1;
        }
        for(int j=1; j<m; j++) {
            dp[0][j]=0;
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(coins[i-1]<=j) {
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n-1][m-1];
    }
}