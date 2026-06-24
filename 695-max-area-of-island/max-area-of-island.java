class Solution {
    public int dfs(int graph[][], int i, int j, int val) {
        if(i<0 || i>=graph.length || j<0 || j>=graph[0].length || graph[i][j]!=1) {
            return 0;
        }
        graph[i][j] = 2;
        return 1+dfs(graph, i-1, j, val)+dfs(graph, i+1, j, val)+dfs(graph, i, j-1, val)+dfs(graph, i, j+1, val);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    int val = dfs(grid, i, j, 0);
                    ans = Math.max(ans, val);
                }
            }
        }

        return ans;
    }
}