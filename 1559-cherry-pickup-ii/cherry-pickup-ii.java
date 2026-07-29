class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n+1][m+2][m+2];
        for(int i=n-1; i>=0; i--) {
            for(int j=m; j>=1; j--) {
                for(int k=m; k>=1; k--) {
                    int best = 0;
                    for(int r1=-1; r1<=1; r1++) {
                        for(int r2=-1; r2<=1; r2++) {
                            best = Math.max(best,dp[i+1][j+r1][k+r2]);
                        }
                    }
                    if(j==k) {
                        dp[i][j][k] = grid[i][j-1]+best;
                    } else {
                        dp[i][j][k] = grid[i][j-1]+grid[i][k-1]+best;
                    }
                }
            }
        }
        return dp[0][1][m];
    }
}