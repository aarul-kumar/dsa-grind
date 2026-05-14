class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        if(nums.length != max+1) {
            return false;
        }
        int j = 1;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]!=j) {
                return false;
            }
            j++;
        }
        if(nums[nums.length-1]==max) {
            return true;
        }
        return false;
    }
}