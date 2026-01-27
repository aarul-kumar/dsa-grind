class Solution {
    public void sortColors(int[] nums) {
        int lp = 0;
        int rp = nums.length-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                int temp = nums[lp];
                nums[lp] = nums[i];
                nums[i] = temp;
                lp++;
            }
        }
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]==2){
                int temp = nums[rp];
                nums[rp] = nums[i];
                nums[i] = temp;
                rp--;
            }
        }
        return;
    }
}