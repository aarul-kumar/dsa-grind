class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int prefixMax[] = new int[n];
        prefixMax[0] = nums[0];
        for(int i=1; i<n; i++) {
            prefixMax[i] = Math.max(nums[i], prefixMax[i-1]);
        }
        int suffixMin[] = new int[n];
        suffixMin[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i+1]);
        }
        int ans[] = new int[n];
        int st = 0;
        for(int i=0; i<n-1; i++) {
            if(prefixMax[i]<=suffixMin[i+1]) {
                int max = prefixMax[i];
                for(int j=st; j<=i; j++) {
                    ans[j] = max;
                }
                st = i+1;
            }
        }
        int max = prefixMax[n-1];
        for(int j=st; j<n; j++) {
            ans[j] = max;
        }
        return ans;
    }
}