class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long totSum = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                totSum += grid[i][j];
            }
        }
        long rowSum = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                rowSum += grid[i][j];
            }
            if(rowSum == totSum-rowSum) {
                return true;
            }
        }
        long colSum = 0;
        for(int j=0; j<grid[0].length; j++) {
            for(int i=0; i<grid.length; i++) {
                colSum += grid[i][j];
            }
            if(colSum == totSum-colSum) {
                return true;
            }
        }

        return false;
    }
}