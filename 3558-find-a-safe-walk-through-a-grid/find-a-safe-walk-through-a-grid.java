class Solution {
    class Point implements Comparable<Point> {
        int x;
        int y;
        int wt;

        Point(int x, int y, int wt) {
            this.x = x;
            this.y = y;
            this.wt = wt;
        }

        @Override
        public int compareTo(Point P) {
            return this.wt - P.wt;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int cost[][] = new int[m][n];
        boolean vis[][] = new boolean[m][n];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = grid.get(0).get(0);
        pq.add(new Point(0, 0, cost[0][0]));
        int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (!pq.isEmpty()) {
            int s = pq.size();
            Point curr = pq.remove();
            if (!vis[curr.x][curr.y]) {
                vis[curr.x][curr.y] = true;
                for (int[] d : dir) {
                    int nx = curr.x + d[0];
                    int ny = curr.y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        int wt = grid.get(nx).get(ny);
                        if (cost[curr.x][curr.y] + wt < cost[nx][ny]) {
                            cost[nx][ny] = cost[curr.x][curr.y] + wt;
                            pq.add(new Point(nx, ny, cost[nx][ny]));
                        }
                    }
                }
            }

        }
        return health-cost[m-1][n-1]>=1;
    }
}