class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            int sum = nums[i] + nums[nums.length-1-i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}