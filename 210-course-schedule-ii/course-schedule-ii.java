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
            int src = grid[i][1];
            int dest = grid[i][0];
            graph[src].add(new Edge(src,dest));
        }
    }
    public boolean isCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph,vis,stack,i)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycleUtil(ArrayList<Edge> graph[], boolean vis[], boolean stack[], int curr) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return true;
            } else if(!vis[e.dest] && isCycleUtil(graph,vis,stack,e.dest)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    ArrayList<Integer> arr = new ArrayList<>();
    public void topSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph,vis,s,i);
            }
        }
        while(!s.isEmpty()) {
            arr.add(s.pop());
        }
    }
    public void topSortUtil(ArrayList<Edge> graph[], boolean vis[], Stack<Integer> s, int curr) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph,vis,s,e.dest);
            }
        }
        s.push(curr);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge> graph[] = new ArrayList[numCourses];
        createGraph(graph,prerequisites);
        if(isCycle(graph)) {
            return new int[]{};
        }
        topSort(graph);
        int ans[] = new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}