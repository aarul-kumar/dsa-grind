class Solution {
    class Edge {
        int src;
        int dest;
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public void createGraph(ArrayList<Edge> graph[], int grid[][]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<grid.length; i++) {
            int src = grid[i][0];
            int dest = grid[i][1];
            graph[src].add(new Edge(src,dest));
        }
    }
    ArrayList<Integer> l = new ArrayList<>();
    public void topSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, vis, i, s);
            }
        }
        while(!s.isEmpty()) {
            l.add(s.pop());
        }
    }
    public void topSortUtil(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> s) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, vis, e.dest, s);
            }
        }
        s.push(curr);
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<Edge> graph[] = new ArrayList[numCourses];
        createGraph(graph, prerequisites);
        topSort(graph);
        List<Boolean> list = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<l.size(); i++) {
            hm.put(l.get(i),i);
        }
        for(int i=0; i<queries.length; i++) {
            if(hm.get(queries[i][0])<hm.get(queries[i][1])) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}