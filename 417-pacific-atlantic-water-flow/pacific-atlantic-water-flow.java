class Solution {
    public void dfs(int graph[][], int x, int y, int prev, boolean vis[][]) {
        if(x<0 || x>=graph.length || y<0 || y>=graph[0].length || graph[x][y]<prev || vis[x][y]) {
            return;
        }
        vis[x][y] = true;
        dfs(graph, x-1, y, graph[x][y], vis);
        dfs(graph, x+1, y, graph[x][y], vis);
        dfs(graph, x, y-1, graph[x][y], vis);
        dfs(graph, x, y+1, graph[x][y], vis);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> l = new ArrayList<>();
        boolean atl[][] = new boolean[m][n];
        boolean pac[][] = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 || j==0) {
                    dfs(heights, i, j, -1, pac);
                }
                if(i==m-1 || j==n-1) {
                    dfs(heights, i, j, -1, atl);
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(atl[i][j] && pac[i][j]) {
                    l.add(Arrays.asList(i,j));
                }
            }
        }
        return l;
    }
}