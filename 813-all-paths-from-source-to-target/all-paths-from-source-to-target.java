class Solution {
    class Edge {
        int src;
        int dest;
        Edge(int src, int dest) {
            this.src=src;
            this.dest=dest;
        }
    }

    List<List<Integer>> ans = new ArrayList<>();

    public void allPath(ArrayList<Edge> graph[], int src, int dest, ArrayList<Integer> path) {
        path.add(src);
        if(src==dest) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPath(graph, e.dest, dest, path);
        }
        path.remove(path.size()-1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int V = graph.length;
        ArrayList<Edge> graphy[] = new ArrayList[V];
        for(int i=0; i<V; i++) {
            graphy[i] = new ArrayList<>();
        }
        for(int i=0; i<V; i++) {
            for(int j=0; j<graph[i].length; j++) {
                graphy[i].add(new Edge(i, graph[i][j]));
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        allPath(graphy, 0, V-1, path);
        return ans;
    }
}