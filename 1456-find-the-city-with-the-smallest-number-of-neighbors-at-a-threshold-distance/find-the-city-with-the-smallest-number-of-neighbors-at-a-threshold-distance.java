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

    public void createGraph(ArrayList<Edge>[] graph, int[][] arr) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            int src = arr[i][0];
            int dest = arr[i][1];
            int wt = arr[i][2];
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));
        }
    }

    public int[][] floydWarshall(ArrayList<Edge> graph[]) {
        int V = graph.length;
        int dp[][] = new int[V][V];

        for(int i=0; i<V; i++) {
            for(int j=0; j<V; j++) {
                if(i!=j) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i=0; i<V; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int src = e.src;
                int dest = e.dest;
                int wt = e.wt;
                dp[src][dest] = wt;
                dp[dest][src] = wt;
            }
        }

        for(int k=0; k<V; k++) {
            for(int i=0; i<V; i++) {
                for(int j=0; j<V; j++) {
                    if(dp[i][k]!=Integer.MAX_VALUE && dp[k][j]!=Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                    }
                }
            }
        }

        return dp;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, edges);
        int dp[][] = floydWarshall(graph);

        int ans = 0;
        int minCount = Integer.MAX_VALUE;
        for(int i=0; i<dp.length; i++) {
            int count = 0;
            for(int j=0; j<dp[0].length; j++) {
                if(i!=j && dp[i][j]<=distanceThreshold) {
                    count++;
                }
            }
            if(count<=minCount) {
                minCount = count;
                ans = i;
            }
        }
        return ans;
    }
}