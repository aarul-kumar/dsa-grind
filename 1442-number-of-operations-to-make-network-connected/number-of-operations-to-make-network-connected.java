class Solution {
    class Edge {
        int src;
        int dest;
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public void createGraph(ArrayList<Edge> graph[], int arr[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<arr.length; i++) {
            graph[arr[i][0]].add(new Edge(arr[i][0],arr[i][1]));
            graph[arr[i][1]].add(new Edge(arr[i][1],arr[i][0]));
        }
    }
    public int dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        int discon = 0;
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                discon++;
                dfsUtil(graph, vis, i);
            }
        }
        return discon;
    }
    public void dfsUtil(ArrayList<Edge> graph[], boolean vis[], int curr) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsUtil(graph, vis, e.dest);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) {
            return -1;
        }
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, connections);
        return dfs(graph)-1;
    }
}