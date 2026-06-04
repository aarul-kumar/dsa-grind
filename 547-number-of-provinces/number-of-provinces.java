class Solution {
    class Edge {
        int src;
        int dest;
        Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public void createGraph(ArrayList<Edge> graph[], int grid[][]){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i!=j && grid[i][j]==1){
                    graph[i].add(new Edge(i,j));
                }
            }
        }
    }
    public void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Edge> graph[]=new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i]=new ArrayList<>();
        }
        createGraph(graph, isConnected);
        boolean vis[]=new boolean[n];

        int ans=0;
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                ans++;
                dfs(graph,i,vis);
            }
        }
        return ans;
    }
}