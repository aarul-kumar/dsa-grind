class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int cons = 0;
        long ans = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                ans += cons + 1;
                cons++;
            } else {
                cons = 0;
            }
        }
        return ans;
    }
}