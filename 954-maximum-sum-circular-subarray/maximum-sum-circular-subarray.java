class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum<0) {
                currSum = 0;
            }
        }
        if(maxSum<0) {
            return maxSum;
        }
        int totSum = 0;
        for(int i=0; i<nums.length; i++) {
            totSum += nums[i];
        }
        currSum = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            currSum += nums[i];
            minSum = Math.min(minSum, currSum);
            if(currSum>0) {
                currSum = 0;
            }
        }
        return Math.max(maxSum, totSum-minSum);
    }
}