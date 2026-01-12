class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int xi = points[0][0];
        int yi = points[0][1];
        for(int i=1; i<points.length; i++) {
            int xf = points[i][0];
            int yf = points[i][1];
            time += Math.max(Math.abs(xf-xi), Math.abs(yf-yi));
            xi = xf;
            yi = yf;
        }
        return time;
    }
}