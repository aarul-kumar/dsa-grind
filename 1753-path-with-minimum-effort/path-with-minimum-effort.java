class Solution {
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int ef;

        Pair(int x, int y, int ef) {
            this.x = x;
            this.y = y;
            this.ef = ef;
        }

        @Override
        public int compareTo(Pair p) {
            return this.ef-p.ef;
        }
    }
    public int dijkstras(int[][] graph) {
        int r = graph.length;
        int c = graph[0].length;
        int effort[][] = new int[r][c];
        boolean vis[][] = new boolean[r][c];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                effort[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        pq.add(new Pair(0,0,0));
        effort[0][0] = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            
            if(curr.x==r-1 && curr.y==c-1) {
                return curr.ef;
            }

            if(!vis[curr.x][curr.y]) {
                vis[curr.x][curr.y] = true;

                for(int[] d:dir) {
                    int nx = curr.x+d[0];
                    int ny = curr.y+d[1];

                    if(nx>=0 && nx<r && ny>=0 && ny<c) {
                        int wt = Math.abs(graph[curr.x][curr.y]-graph[nx][ny]);
                        int newEffort = Math.max(curr.ef, wt);

                        if(newEffort<effort[nx][ny]) {
                            effort[nx][ny] = newEffort;
                            pq.add(new Pair(nx, ny, newEffort));
                        }
                    }
                }
            }
        }
        return effort[r-1][c-1];
    }
    public int minimumEffortPath(int[][] heights) {
        return dijkstras(heights);
    }
}