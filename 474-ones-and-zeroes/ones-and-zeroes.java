class Solution {
    class Pair {
        int zero;
        int one;
        Pair(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }
    ArrayList<Pair> arr = new ArrayList<>();
    public void count(String s) {
        int z = 0;
        int o = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='0') z++;
            else o++;
        }
        arr.add(new Pair(z,o));
    }
    public int findMaxForm(String[] strs, int m, int n) {
        for(String s:strs) {
            count(s);
        }
        int dp[][][] = new int[strs.length+1][m+1][n+1];
        for(int i=1; i<=strs.length; i++) {
            Pair p = arr.get(i-1);
            int z = p.zero;
            int o = p.one;
            for(int j=0; j<=m; j++) {
                for(int k=0; k<=n; k++) {
                    if(z<=j && o<=k) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-z][k-o]+1);
                    } else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}