class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        long val = nums[nums.length-1]-nums[0];
        long totVal = val*k;
        return totVal;
    }
}