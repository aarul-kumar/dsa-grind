class Solution {
    class Point implements Comparable<Point> {
        int idx;
        int dist;

        Point(int idx, int dist) {
            this.idx=idx;
            this.dist=dist;
        }

        @Override
        public int compareTo(Point p) {
            return this.dist-p.dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<points.length; i++) {
            int dist = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            pq.add(new Point(i, dist));
        }
        int ans[][] = new int[k][2];
        for(int i=0; i<k; i++) {
            Point curr = pq.remove();
            ans[i][0] = points[curr.idx][0];
            ans[i][1] = points[curr.idx][1];
        }
        return ans;
    }
}