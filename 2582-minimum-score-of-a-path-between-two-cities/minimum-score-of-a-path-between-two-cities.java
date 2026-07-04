class Solution {
    class Edge {
        int src;
        int dest;
        int wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public void createGraph(ArrayList<Edge> graph[], int roads[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<roads.length; i++) {
            int src = roads[i][0];
            int dest = roads[i][1];
            int wt = roads[i][2];
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));
        }
    }
    public int minScore(int n, int[][] roads) {
        ArrayList<Edge> graph[] = new ArrayList[n+1];
        createGraph(graph, roads);
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n+1];
        q.add(1);
        vis[1] = true;
        int minWt = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int curr = q.remove();
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                minWt = Math.min(minWt, e.wt);
                if(!vis[e.dest]) {
                    vis[e.dest] = true;
                    q.add(e.dest);                    
                }
            }
        }
        return minWt;
    }
}