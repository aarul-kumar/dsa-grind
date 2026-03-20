class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n-k+1][m-k+1];
        for(int i=0; i<=n-k; i++) {
            for(int j=0; j<=m-k; j++) {
                TreeSet<Integer> ts = new TreeSet<>();
                for(int a=i; a<=i+k-1; a++) {
                    for(int b=j; b<=j+k-1; b++) {
                        ts.add(grid[a][b]);
                    }
                }
                if(ts.size()==1) {
                    ans[i][j] = 0;
                    continue;
                }
                int minDiff = Integer.MAX_VALUE;
                Integer prev = null;
                for(Integer curr:ts) {
                    if(prev!=null) {
                        minDiff = Math.min(minDiff, curr-prev);
                    }
                    prev = curr;
                }
                ans[i][j] = minDiff;
            }
        }
        return ans;
    }
}