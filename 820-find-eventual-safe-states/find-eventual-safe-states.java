class Solution {
    class Edge {
        int src;
        int dest;
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public void calcdeg(ArrayList<Edge> graph[], int outdeg[]) {
        for(int i=0; i<graph.length; i++) {
            outdeg[i] = graph[i].size();
        }
    }
    List<Integer> list = new ArrayList<>();
    public void topSort(ArrayList<Edge> graph[]) {
        int outdeg[] = new int[graph.length];
        calcdeg(graph, outdeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(outdeg[i]==0) {
                q.add(i);
            }
        }
        ArrayList<Edge> transpose[] = new ArrayList[graph.length];
        for(int i=0; i<transpose.length; i++) {
            transpose[i] = new ArrayList<>();
        }
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        while(!q.isEmpty()) {
            int curr = q.remove();
            list.add(curr);
            for(int i=0; i<transpose[curr].size(); i++) {
                Edge e = transpose[curr].get(i);
                outdeg[e.dest]--;
                if(outdeg[e.dest]==0) {
                    q.add(e.dest);
                }
            }
        }
    }
    public void createGraph(ArrayList<Edge> graph[], int[][] arr) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                graph[i].add(new Edge(i,arr[i][j]));
            }
        }
    }
    public List<Integer> eventualSafeNodes(int[][] graphy) {
        ArrayList<Edge> graph[] = new ArrayList[graphy.length];
        createGraph(graph, graphy);
        topSort(graph);
        Collections.sort(list);
        return list;
    }
}