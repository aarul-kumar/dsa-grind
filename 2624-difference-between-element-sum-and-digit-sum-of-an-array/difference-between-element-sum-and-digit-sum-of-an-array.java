class Solution {
    public int differenceOfSum(int[] nums) {
        int es = 0;
        int ds = 0;
        for(int i=0; i<nums.length; i++) {
            es += nums[i];
            if(nums[i]>=10) {
                int val = nums[i];
                while(val>0) {
                    ds += val%10;
                    val = val/10;
                }
            } else {
                ds += nums[i];
            }
        }
        int ans = Math.abs(es-ds);
        return ans;
    }
}