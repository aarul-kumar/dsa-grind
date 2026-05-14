class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n-1];
        if(n != max+1) {
            return false;
        }
        int j = 1;
        for(int i=0; i<n-1; i++) {
            if(nums[i]!=j) {
                return false;
            }
            j++;
        }
        if(nums[n-1]==max) {
            return true;
        }
        return false;
    }
}