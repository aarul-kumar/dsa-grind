class Solution {
    public boolean isTrionic(int[] nums) {
        int p = 0;
        int q = 0;
        int count = 0;
        if(nums[0]>nums[1] || nums[nums.length-1]<nums[nums.length-2]) {
            return false;
        }
        for(int i=1; i<nums.length-1; i++) {
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) {
                p = i;
                count++;
            }
            if(nums[i]<nums[i-1] && nums[i]<nums[i+1]) {
                q = i;
                count++;
            }
            if(nums[i]==nums[i-1] || nums[i]==nums[i+1]) {
                return false;
            }
        }
        if(p>0 && p<q && q<nums.length-1 && count==2) {
            return true;
        } else {
            return false;
        }
    }
}