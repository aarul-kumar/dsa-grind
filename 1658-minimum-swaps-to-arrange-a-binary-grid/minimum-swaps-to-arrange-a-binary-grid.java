class Solution {
    public int minSwaps(int[][] grid) {
        ArrayList<Integer> endZero = new ArrayList<>();
        for(int i=0; i<grid.length; i++) {
            int j = grid.length-1;
            int count = 0;
            while(j>=0 && grid[i][j]==0) {
                count++;
                j--;
            }
            endZero.add(count);
        }
        int steps = 0;
        for(int i=0; i<grid.length; i++) {
            int need = grid.length-i-1;
            int j = i;
            while(j<grid.length && endZero.get(j) < need) {
                j++;
            }
            if(j==grid.length) {
                return -1;
            }
            steps += j-i;
            while(j>i) {
                Collections.swap(endZero, j, j-1);
                j--;
            }
        }
        return steps;
    }
}