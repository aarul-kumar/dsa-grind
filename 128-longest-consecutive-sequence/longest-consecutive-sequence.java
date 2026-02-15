class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int maxCount = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            if(nums[i+1]==(nums[i]+1)){
                count++;
                maxCount = Math.max(count, maxCount);
            }else{
                count = 0;
            }
        }
        return maxCount+1;
    }
}