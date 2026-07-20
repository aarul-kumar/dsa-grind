class Solution {
    public void reverse(int arr[], int start, int end) {
        while(start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int arr[] = new int[n*m];
        int l = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[l] = grid[i][j];
                l++;
            }
        }
        int rot = k%arr.length;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,rot-1);
        reverse(arr,rot,arr.length-1);
        List<List<Integer>> list = new ArrayList<>();
        l = 0;
        for(int i=0; i<n; i++) {
            List<Integer> list1 = new ArrayList<>();
            for(int j=0; j<m; j++) {
                list1.add(arr[l]);
                l++;
            }
            list.add(list1);
        }
        return list;
    }
}