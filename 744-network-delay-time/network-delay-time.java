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
            graph[arr[i][0]].add(new Edge(arr[i][0], arr[i][1], arr[i][2]));
        }
    }

    class Pair implements Comparable<Pair> {
        int n;
        int path;
        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p) {
            return this.path-p.path;
        }
    }

    public int dijkstras(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for(int i=1; i<dist.length; i++) {
            if(i!=src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    if(dist[e.src]!=Integer.MAX_VALUE &&  dist[e.src]+e.wt<dist[e.dest]) {
                        dist[e.dest] = dist[e.src]+e.wt;
                        pq.add(new Pair(e.dest, dist[e.dest]));
                    }
                }
            }
        }
        int ans = 0;
        for(int i=1; i<dist.length; i++) {
            if(dist[i]==Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n+1];
        createGraph(graph, times);
        return dijkstras(graph, k);
    }
}