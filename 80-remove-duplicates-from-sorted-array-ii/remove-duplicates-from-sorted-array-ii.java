class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 2;
        for(int i=2; i<nums.length; i++) {
            if(nums[p-2]!=nums[i]) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}