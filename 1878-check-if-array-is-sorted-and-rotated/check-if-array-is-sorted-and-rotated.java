class Solution {
    public boolean check(int[] nums) {
        int inv = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]>nums[i+1]) {
                inv++;
            }
        }
        if(nums[0]<nums[nums.length-1]) {
            inv++;
        }
        if(inv > 1) {
            return false;
        } else {
            return true;
        }
    }
}