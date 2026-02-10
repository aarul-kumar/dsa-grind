class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a = 0;
        int b = 0;
        int arr[] = new int[(grid.length*grid.length)+1];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                arr[grid[i][j]]++;
            }
        }
        for(int i=1; i<arr.length; i++) {
            if(arr[i]>1) {
                a = i;
            }
            if(arr[i]==0) {
                b = i;
            }
        }
        int ans[] = {a,b};
        return ans;
    }
}