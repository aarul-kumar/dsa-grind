class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int rs = x;
        int re = x+k-1;
        while(rs<re) {
            for(int i=y; i<y+k; i++) {
                int temp = grid[rs][i];
                grid[rs][i] = grid[re][i];
                grid[re][i] = temp;
            }
            rs++;
            re--;
        }
        return grid;
    }
}