class Solution {
    public int numSpecial(int[][] mat) {
        int rowSum[] = new int[mat.length];
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                rowSum[i] += mat[i][j];
            }
        }
        int colSum[] = new int[mat[0].length];
        for(int j=0; j<mat[0].length; j++) {
            for(int i=0; i<mat.length; i++) {
                colSum[j] += mat[i][j];
            }
        }
        int ans = 0;
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j]==1 && rowSum[i]==1 && colSum[j]==1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}