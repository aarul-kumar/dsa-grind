class Solution {
    public class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
        @Override
        public int compareTo(Edge e) {
            return this.wt-e.wt;
        }
    }

    public void createGraph(int[][] points, ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points.length; j++) {
                if(i!=j) {
                    int src=i;
                    int dest=j;
                    int wt=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                    graph[src].add(new Edge(src,dest,wt));
                }
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        ArrayList<Edge> graph[] = new ArrayList[points.length];
        createGraph(points,graph);
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0,0,0));
        int minCost = 0;
        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.src]) {
                vis[curr.src]=true;
                minCost+=curr.wt;
                for(int i=0; i<graph[curr.src].size(); i++) {
                    Edge e = graph[curr.src].get(i);
                    pq.add(new Edge(e.dest,0,e.wt));
                }
            }
        }
        return minCost;
    }
}