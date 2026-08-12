class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        for(int r=0; r<nums.length; r++) {
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            while(hm.get(nums[r])>k) {
                hm.put(nums[l],hm.get(nums[l])-1);
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}