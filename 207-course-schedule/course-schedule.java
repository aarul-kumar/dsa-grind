class Solution {
    public class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src=s;
            this.dest=d;
        }
    }

    public void createGraph(ArrayList<Edge> graph[], int[][] prerequisites) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(new Edge(prerequisites[i][1],prerequisites[i][0]));
        }
    }

    public boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph,i,vis,stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph,e.dest,vis,stack)) {
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Edge> graph[] = new ArrayList[numCourses];
        createGraph(graph,prerequisites);
        boolean ans = isCycle(graph);
        return (!ans);
    }
}