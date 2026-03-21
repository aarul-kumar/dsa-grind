class Solution {
    private boolean backtrack(int grid[][], int i, int j, int prevVal, int step) {
        if(i<0||i>=grid.length||j<0||j>=grid.length) {
            return false;
        }
        if(prevVal+1!=(grid[i][j])) {
            return false;
        }
        if(step==(grid.length*grid.length)-1) {
            return true;
        }
        if(backtrack(grid, i-2, j+1, grid[i][j], step+1) || backtrack(grid, i-1, j+2, grid[i][j], step+1) || backtrack(grid, i+1, j+2, grid[i][j], step+1) || backtrack(grid, i+2, j+1, grid[i][j], step+1) || backtrack(grid, i+2, j-1, grid[i][j], step+1) || backtrack(grid, i+1, j-2, grid[i][j], step+1) || backtrack(grid, i-1, j-2, grid[i][j], step+1) || backtrack(grid, i-2, j-1, grid[i][j], step+1)) {
            return true;
        }
        return false;
    }
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0) {
            return false;
        }
        return backtrack(grid, 0, 0, -1, 0);
    }
}