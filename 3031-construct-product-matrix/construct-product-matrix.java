class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        int prefixProd[][] = new int[n][m];
        int suffixProd[][] = new int[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 && j==0) {
                    prefixProd[i][j] = 1;
                } else if(j==0) {
                    prefixProd[i][j] = (int)((long)prefixProd[i-1][m-1]*grid[i-1][m-1]%mod);
                } else {
                    prefixProd[i][j] = (int)((long)prefixProd[i][j-1]*grid[i][j-1]%mod);
                }
            }
        }

        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                if(i==n-1 && j==m-1) {
                    suffixProd[i][j] = 1;
                } else if(j==m-1) {
                    suffixProd[i][j] = (int)((long)suffixProd[i+1][0]*grid[i+1][0]%mod);
                } else {
                    suffixProd[i][j] = (int)((long)suffixProd[i][j+1]*grid[i][j+1]%mod);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                grid[i][j] = (int)((long)prefixProd[i][j]*suffixProd[i][j]%mod);
            }
        }

        return grid;
    }
}