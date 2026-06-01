class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans=0;
        int ni=cost.length-3;
        for(int i=cost.length-1; i>=0; i--) {
            if(i==ni) {
                ni-=3;
                continue;
            } else {
                ans+=cost[i];
            }
        }
        return ans;
    }
}