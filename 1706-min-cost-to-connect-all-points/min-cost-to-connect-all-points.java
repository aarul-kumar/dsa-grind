class Solution {
    class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;
        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge e) {
            return this.wt-e.wt;
        }
    }
    public void createGraph(ArrayList<Edge> graph[], int grid[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid.length; j++) {
                if(i!=j) {
                    int src = i;
                    int dest = j;
                    int wt = Math.abs(grid[i][0]-grid[j][0])+Math.abs(grid[i][1]-grid[j][1]);
                    graph[src].add(new Edge(src, dest, wt));
                }
            }
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<Edge> graph[] = new ArrayList[points.length];
        createGraph(graph, points);
        boolean vis[] = new boolean[points.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0,0,0));
        int min = 0;
        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.src]) {
                vis[curr.src] = true;
                min += curr.wt;
                for(int i=0; i<graph[curr.src].size(); i++) {
                    Edge e = graph[curr.src].get(i);
                    pq.add(new Edge(e.dest,e.src,e.wt));
                }
            }
        }
        return min;
    }
}