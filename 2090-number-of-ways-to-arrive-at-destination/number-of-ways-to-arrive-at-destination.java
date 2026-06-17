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
    public void createGraph(ArrayList<Edge> graph[], int arr[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<arr.length; i++) {
            int src = arr[i][0];
            int dest = arr[i][1];
            int wt = arr[i][2];
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));
        }
    }
    class Pair implements Comparable<Pair> {
        int v;
        long path;
        Pair(int v, long path) {
            this.v = v;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p) {
            return Long.compare(this.path, p.path);
        }
    }
    public int dijkstras(ArrayList<Edge> graph[]) {
        int V = graph.length;
        long MOD = 1_000_000_007L;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        long dist[] = new long[V];
        long ways[] = new long[V];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();

            if(curr.path>dist[curr.v]) {
                continue;
            }
            
            for(int i=0; i<graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);

                long newDist = dist[e.src]+e.wt;

                if(newDist < dist[e.dest]) {
                    dist[e.dest] = newDist;
                    ways[e.dest] = ways[e.src];

                    pq.add(new Pair(e.dest, dist[e.dest]));
                } else if(newDist == dist[e.dest]) {
                    ways[e.dest] = (ways[e.dest] + ways[e.src]) % MOD;
                }
            }
            
        }
        return (int) (ways[V-1]%MOD);
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, roads);
        return dijkstras(graph);
    }
}