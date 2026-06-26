class Solution {
    class Edge {
        int src;
        int dest;
        double wt;
        Edge(int src, int dest, double wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    class Pair implements Comparable<Pair> {
        int n;
        double path;
        Pair(int n, double path) {
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p) {
            return Double.compare(p.path,this.path);
        }
    }
    public void createGraph(ArrayList<Edge>[] graph, int[][] edges, double[] weight) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            double wt = weight[i];
            graph[src].add(new Edge(src,dest,wt));
            graph[dest].add(new Edge(dest,src,wt));
        }
    }
    public double dijkstra(ArrayList<Edge> graph[], int src, int end) {
        double prob[] = new double[graph.length];
        prob[src] = 1;
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 1));
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    double wt = e.wt;
                    if(prob[u]*wt>prob[v]) {
                        prob[v] = prob[u]*wt;
                        pq.add(new Pair(v, prob[v]));
                    }
                }
            }
        }
        return prob[end];
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph,edges,succProb);
        return dijkstra(graph,start_node,end_node);
    }
}