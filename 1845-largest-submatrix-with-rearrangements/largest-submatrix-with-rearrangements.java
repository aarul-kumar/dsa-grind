class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int ans = 0;
        int arr[] = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]==1) {
                    arr[j] += 1;
                } else {
                    arr[j] = 0;
                }
            }
            Integer temp[] = new Integer[arr.length];
            for(int j=0; j<temp.length; j++) {
                temp[j] = arr[j];
            }
            Arrays.sort(temp, Collections.reverseOrder());
            
            for(int j=0; j<temp.length; j++) {
                int area = temp[j]*(j+1);
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}