class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        long val = 0;
        long maxVal = 0;
        for(int i=0; i<nums.length; i++) {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            val += nums[i];
            if(i>=k) {
                int rem = nums[i-k];
                hm.put(rem,hm.get(rem)-1);
                if(hm.get(rem)==0) {
                    hm.remove(rem);
                }
                val -= nums[i-k];
            }
            if(i>=k-1) {
                if(hm.size()==k) {
                    maxVal = Math.max(val, maxVal);
                }
            }
        }
        return maxVal;
    }
}