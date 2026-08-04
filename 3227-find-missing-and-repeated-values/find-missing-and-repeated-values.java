class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<grid[0].length; j++) {
                hm.put(grid[i][j],hm.getOrDefault(grid[i][j],0)+1);
            }
        }
        int ans[] = new int[2];
        for(int i=1; i<=n*n; i++) {
            if(!hm.containsKey(i)) {
                ans[1] = i;
            } else if(hm.get(i)==2) {
                ans[0] = i;
            }
        }
        return ans;
    }
}