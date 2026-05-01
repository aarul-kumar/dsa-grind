class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
        }
        int dp[] = new int[n];
        for(int i=0; i<n; i++) {
            dp[0] += i*nums[i];
        }
        int max = dp[0];
        for(int i=1; i<n; i++) {
            dp[i] = dp[i-1] + sum - n*nums[n-i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}