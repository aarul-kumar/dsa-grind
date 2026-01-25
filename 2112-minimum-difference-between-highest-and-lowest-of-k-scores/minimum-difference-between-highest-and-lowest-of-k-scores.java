class Solution {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<=nums.length-k; i++) {
            int min = nums[k-1+i] - nums[i];
            ans = Math.min(ans, min);
        }
        return ans;
    }
}