class Solution {
    public boolean canAliceWin(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int ss=0;
        int ds = 0;
        while(i<nums.length && nums[i]<10) {
            ss+=nums[i];
            i++;
        }
        while(i<nums.length) {
            ds+=nums[i];
            i++;
        }
        if(ss!=ds) {
            return true;
        } else {
            return false;
        }
    }
}