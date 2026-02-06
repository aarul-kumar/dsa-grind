class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int ans=0;
        for(int j=0; j<nums.length; j++){
            while((long)nums[j]>(long)nums[i]*k){
                i++;
            }
            ans=Math.max(ans, j-i+1);
        }
        return nums.length-ans;
    }
}