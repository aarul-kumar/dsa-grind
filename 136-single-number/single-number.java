class Solution {
    public int singleNumber(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        if(l>1){
            for(int i=0; i<l; i++){
                if(i==0 || i==l-1){
                    if(nums[0]!=nums[1]){
                        return nums[0];
                    }
                    else if(nums[l-1]!=nums[l-2]){
                        return nums[l-1];
                    }
                }
                else if(nums[i-1]!=nums[i] && nums[i]!=nums[i+1]){
                    return nums[i];
                }
            }
        }
        return nums[0];
    }
}