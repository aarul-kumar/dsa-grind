class Solution {
    int m;
    int n;
    private int solve(int[][] grid, int k, int i, int j, int cost, int dp[][][]) {
        if(i>=m || j>=n) {
            return -1;
        }
        int newCost = cost + (grid[i][j] == 0 ? 0 : 1);
        if (newCost > k) return -1;

        if(i==m-1 && j==n-1) {
            return grid[i][j];
        }
        if(dp[i][j][newCost]!=Integer.MIN_VALUE) {
            return dp[i][j][newCost];
        }
        int right = solve(grid, k, i, j+1, newCost, dp);
        int down = solve(grid, k, i+1, j, newCost, dp);
        int next = Math.max(right, down);
        if(next==-1) {
            return dp[i][j][newCost] = -1;
        }
        return dp[i][j][newCost] = grid[i][j]+next;
    }
    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int dp[][][] = new int[m][n][k+1];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return solve(grid, k, 0, 0, 0, dp);
    }
}