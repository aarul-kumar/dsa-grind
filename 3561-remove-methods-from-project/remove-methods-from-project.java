class Solution {
    class Edge {
        int src;
        int dest;
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public void createGraph(ArrayList<Edge> graph[], int grid[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<grid.length; i++) {
            int src = grid[i][0];
            int dest = grid[i][1];
            graph[src].add(new Edge(src,dest));
        }
    }
    public boolean[] dfs(ArrayList<Edge> graph[], int k) {
        boolean vis[] = new boolean[graph.length];
        dfsUtil(graph, k, vis);
        return vis;
    }
    public void dfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, invocations);
        boolean sus[] = dfs(graph, k);
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<invocations.length; i++) {
            int src = invocations[i][0];
            int dest = invocations[i][1];
            if(sus[src]==false && sus[dest]==true) {
                List<Integer> list = new ArrayList<>();
                for(int j=0; j<n; j++) {
                    list.add(j);
                }
                return list;
            }
        }
        for(int i=0; i<n; i++) {
            if(!sus[i]) {
                l.add(i);
            }
        }
        return l;
    }
}