class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long maxdp[][] = new long[n][m];
        long mindp[][] = new long[n][m];

        maxdp[0][0] = grid[0][0];
        mindp[0][0] = grid[0][0];

        for(int i=1; i<n; i++) {
            maxdp[i][0] = maxdp[i-1][0]*grid[i][0];
            mindp[i][0] = maxdp[i][0];
        }

        for(int j=1; j<m; j++) {
            maxdp[0][j] = maxdp[0][j-1]*grid[0][j];
            mindp[0][j] = maxdp[0][j];
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                long val = grid[i][j];
                long a = maxdp[i][j-1]*val;
                long b = maxdp[i-1][j]*val;
                long c = mindp[i][j-1]*val;
                long d = mindp[i-1][j]*val;
                maxdp[i][j] = Math.max(Math.max(a,b), Math.max(c,d));
                mindp[i][j] = Math.min(Math.min(a,b), Math.min(c,d));
            }
        }
        long res = maxdp[n-1][m-1];
        if(res<0) {
            return -1;
        }
        return (int)(res%1000000007);
    }
}