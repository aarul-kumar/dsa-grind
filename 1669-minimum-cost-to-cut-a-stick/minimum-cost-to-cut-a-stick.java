class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int pos[] = new int[cuts.length+2];
        pos[0] = 0;
        for(int i=0; i<cuts.length; i++) {
            pos[i+1] = cuts[i];
        }
        pos[pos.length-1] = n;
        int m = pos.length;
        int dp[][] = new int[m][m];
        for(int len=2; len<m; len++) {
            for(int i=0; i+len<m; i++) {
                int j = i+len;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i+1; k<=j; k++) {
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]+pos[j]-pos[i]);
                }
                if(dp[i][j]==Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][m-1];
    }
}