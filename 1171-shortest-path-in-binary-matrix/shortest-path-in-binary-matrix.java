class Solution {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[grid.length-1][grid.length-1]==1) {
            return -1;
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        grid[0][0] = 1;
        int length = 1;

        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Point curr = q.remove();

                if(curr.x==n-1 && curr.y==n-1) {
                    return length;
                }

                for(int[] d:dir) {
                    int nx = curr.x + d[0];
                    int ny = curr.y + d[1];

                    if(nx>=0 && nx<n && ny>=0 && ny<n && grid[nx][ny]==0) {
                        q.add(new Point(nx, ny));
                        grid[nx][ny] = 1;
                    }
                }
            }
            length++;
        }
        return -1;
    }
}