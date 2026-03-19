class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mat[][] = new int[n][m];
        int xCount[][] = new int[n][m];

        if(grid[0][0]=='X') {
            mat[0][0] = 1;
            xCount[0][0] = 1;
        } else if(grid[0][0]=='Y') {
            mat[0][0] = -1;
        } else {
            mat[0][0] = 0;
        }

        for(int i=1; i<n; i++) {
            int x = 0;
            if(grid[i][0]=='X') {
                mat[i][0] = mat[i-1][0] + 1;
                x = 1;
            } else if(grid[i][0]=='Y') {
                mat[i][0] = mat[i-1][0] - 1;
            } else {
                mat[i][0] = mat[i-1][0];
            }
            xCount[i][0] = xCount[i-1][0] + x;
        }
        
        for(int j=1; j<m; j++) {
            int x = 0;
            if(grid[0][j]=='X') {
                mat[0][j] = mat[0][j-1] + 1;
                x = 1;
            } else if(grid[0][j]=='Y') {
                mat[0][j] = mat[0][j-1] - 1;
            } else {
                mat[0][j] = mat[0][j-1];
            }
            xCount[0][j] = xCount[0][j-1] + x;
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                int val = 0;
                int x = 0;
                if(grid[i][j]=='X') {
                    val = 1;
                    x = 1;
                }
                if(grid[i][j]=='Y') {
                    val = -1;
                }
                mat[i][j] = mat[i-1][j] + mat[i][j-1] + val - mat[i-1][j-1];
                xCount[i][j] = xCount[i-1][j] + xCount[i][j-1] - xCount[i-1][j-1] + x;
            }
        }

        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j]==0 && xCount[i][j]>0) {
                    count++;
                }
            }
        }
        return count;
    }
}