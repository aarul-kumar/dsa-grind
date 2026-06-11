class Solution {
    public int getMaxRow(int mat[][], int col, int n) {
        int max = 0;
        int rowIdx = 0;
        for(int i=0; i<n; i++) {
            if(mat[i][col]>max) {
                max = mat[i][col];
                rowIdx = i;
            }
        }
        return rowIdx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int l = 0;
        int r = m-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            int maxRow = getMaxRow(mat, mid, n);

            int left = mid-1 >= 0 ? mat[maxRow][mid-1] : -1;
            int right = mid+1 < m ? mat[maxRow][mid+1] : -1;
            int curr = mat[maxRow][mid];

            if(curr>left && curr>right) return new int[]{maxRow, mid};
            else if(curr<left) r = mid-1;
            else l = mid+1;
        }
        return new int[]{-1,-1};
    }
}