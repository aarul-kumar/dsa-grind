class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            hs.add(nums[i]);
        }
        int sum = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i]==nums[i-1]+1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        while(hs.contains(sum)) {
            sum++;
        }
        return sum;
    }
}