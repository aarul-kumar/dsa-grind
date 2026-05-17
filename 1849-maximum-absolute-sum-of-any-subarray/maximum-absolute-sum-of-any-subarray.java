class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0;
        int currMax = 0, currMin = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            currMax += nums[i];
            if(currMax < 0) {
                currMax = 0;
            }
            maxSum = Math.max(currMax, maxSum);
            currMin += nums[i];
            if(currMin > 0) {
                currMin = 0;
            }
            minSum = Math.min(currMin, minSum);
        }
        return Math.max(maxSum, Math.abs(minSum));
    }
}