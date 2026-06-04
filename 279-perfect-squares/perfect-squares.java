class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1; i*i<=n; i++) {
            arr.add(i*i);
        }
        int dp[][] = new int[arr.size()+1][n+1];
        for(int j=1; j<dp[0].length; j++) {
            dp[0][j] = Integer.MAX_VALUE-1;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(arr.get(i-1)<=j){
                    dp[i][j] = Math.min(dp[i][j-arr.get(i-1)]+1,dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}