class Solution {
    public List<List<Integer>> generate(int numRows) {
        int dp[][] = new int[numRows][numRows];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp.length; j++) {
                if(j==0 || (i==j)) {
                    dp[i][j] = 1;
                }
            }
        }
        for(int i=2; i<dp.length; i++) {
            for(int j=1; j<i; j++) {
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
        }
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0; i<dp.length; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                arr.add(dp[i][j]);
            }
            l.add(arr);
        }
        return l;
    }
}