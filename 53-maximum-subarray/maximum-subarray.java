class Solution {
    public int maxSubArray(int[] nums) {
        boolean val = true;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                val = false;
                break;
            }
        }
        if(val){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }
        if(nums.length==1){
            return nums[0];
        } else {
            int currSum = 0;
            int MaxSum = 0;
            for(int i=0; i<nums.length; i++){
                currSum += nums[i];
                if(currSum<0){
                    currSum=0;
                }
                MaxSum = Math.max(MaxSum, currSum);
            }
            return MaxSum;
        }
        
    }
}