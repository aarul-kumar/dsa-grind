class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;

        int res[][] = new int[n][m];
        long prefix = 1;
        for(int i=0; i<n*m; i++) {
            int r = i/m;
            int c = i%m;
            res[r][c] = (int)prefix;
            prefix = (prefix*grid[r][c])%mod;
        }

        long suffix = 1;
        for(int i=n*m-1; i>=0; i--) {
            int r = i/m;
            int c = i%m;
            res[r][c] = (int)((res[r][c]*suffix)%mod);
            suffix = (suffix*grid[r][c])%mod;
        }

        return res;
    }
}