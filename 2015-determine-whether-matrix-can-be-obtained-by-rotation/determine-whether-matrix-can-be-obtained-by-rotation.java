class Solution {
    private void rotate(int mat[][]) {
        int sr = 0;
        int er = mat.length-1;
        while(sr<er) {
            for(int i=0; i<mat.length; i++) {
                int temp = mat[sr][i];
                mat[sr][i] = mat[er][i];
                mat[er][i] = temp;
            }
            sr++;
            er--;
        }
        for(int i=0; i<mat.length; i++) {
            for(int j=i; j<mat.length; j++) {
                int temp  = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    private boolean match(int mat[][], int target[][]) {
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat.length; j++) {
                if(mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0; i<4; i++) {
            rotate(mat);
            if(match(mat, target)) {
                return true;
            }
        }
        return false;
    }
}