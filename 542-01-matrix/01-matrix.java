class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }

        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] curr=q.remove();
            for(int d[]:dir){
                int nx=curr[0]+d[0];
                int ny=curr[1]+d[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && mat[nx][ny]==-1){
                    mat[nx][ny] = mat[curr[0]][curr[1]]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return mat;
    }
}