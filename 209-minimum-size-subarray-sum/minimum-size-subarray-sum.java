class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int minSize = Integer.MAX_VALUE;
        int currSum = 0;
        for(int r=0; r<nums.length; r++) {
            currSum += nums[r];
            while(currSum>=target) {
                currSum -= nums[l];
                minSize = Math.min(minSize,r-l+1);
                l++;
            }
        }
        return minSize==Integer.MAX_VALUE?0:minSize;
    }
}