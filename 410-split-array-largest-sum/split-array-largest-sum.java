class Solution {
    public boolean isPossible(int arr[], int k, int x) {
        int totSubArray = 1;
        int sum = 0;
        for(int i:arr) {
            sum += i;
            if(sum>x) {
                totSubArray++;
                sum = i;
            }
        }
        return totSubArray <= k;
    }
    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for(int i:nums) {
            l = Math.max(l,i);
            r += i;
        }
        int ans = 0;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(isPossible(nums, k, mid)) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }
}