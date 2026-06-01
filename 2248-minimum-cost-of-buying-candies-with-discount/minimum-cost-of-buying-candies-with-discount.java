class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans=0;
        int n=cost.length;
        int ni=n-3;
        for(int i=n-1; i>=0; i--) {
            if(i==ni) {
                ni-=3;
            } else {
                ans+=cost[i];
            }
        }
        return ans;
    }
}