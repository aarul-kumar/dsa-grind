class Solution {
    public boolean isPossible(int arr[], int d, int x) {
        int totDays = 1;
        int wt = 0;
        for(int i:arr) {
            wt += i;
            if(wt>x) {
                totDays++;
                wt = i;
            }
        }
        return totDays <= d;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for(int i:weights) {
            r += i;
            l = Math.max(l,i);
        }
        int ans = 0;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(isPossible(weights, days, mid)) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }
}