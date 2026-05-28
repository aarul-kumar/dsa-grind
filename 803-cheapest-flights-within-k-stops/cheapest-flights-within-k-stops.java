class Solution {
    public class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public void createGraph(ArrayList<Edge>[] graph, int flights[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    public class Info {
        int v;
        int cost;
        int stop;

        Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stop = s;
        }
    }

    public int cheapestFlight(int flights[][], int src, int dest, int k, int n) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stop > k) {
                break;
            }
            for(int i=0; i<graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int v = e.dest;
                int wt = e.wt;
                if(curr.cost + wt < dist[v] && curr.stop <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stop+1));
                } 
            }
        }
        if(dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return cheapestFlight(flights, src, dst, k, n);
    }
}