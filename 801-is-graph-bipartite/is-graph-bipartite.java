class Solution {
    class Edge {
        int src;
        int dest;
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public void createGraph(ArrayList<Edge> graph[], int grid[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                int src = i;
                int dest = grid[i][j];
                graph[src].add(new Edge(src,dest));
                graph[dest].add(new Edge(dest,src));
            }
        }
    }
    public boolean isBipartite(int[][] graphy) {
        ArrayList<Edge> graph[] = new ArrayList[graphy.length];
        createGraph(graph, graphy);
        int col[] = new int[graphy.length];
        for(int i=0; i<col.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(col[i]==-1) {
                q.add(i);
                col[i] = 0;
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if(col[e.dest]==-1) {
                            int nextCol = col[curr] == 0?1:0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if(col[e.dest]==col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}