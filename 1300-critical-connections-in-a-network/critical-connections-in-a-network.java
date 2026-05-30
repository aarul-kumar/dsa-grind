class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src=s;
            this.dest=d;
        }
    }
    public void createGraph(ArrayList<Edge> graph[], List<List<Integer>> connections) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<connections.size(); i++) {
            int a=connections.get(i).get(0);
            int b=connections.get(i).get(1);
            graph[a].add(new Edge(a,b));
            graph[b].add(new Edge(b,a));
        }
    }
    public void tarjans(ArrayList<Edge> graph[], int V) {
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;
        boolean vis[]=new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,vis,time);
            }
        }
    }
    public void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time) {
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            int neigh=e.dest;
            if(neigh==par) {
                continue;
            }
            else if(!vis[neigh]) {
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(dt[curr]<low[neigh]) {
                    List<Integer> list=new ArrayList<>();
                    list.add(curr);
                    list.add(neigh);
                    ans.add(list);
                }
            }
            else {
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Edge> graph[]=new ArrayList[n];
        createGraph(graph, connections);
        tarjans(graph, n);
        return ans;
    }
}