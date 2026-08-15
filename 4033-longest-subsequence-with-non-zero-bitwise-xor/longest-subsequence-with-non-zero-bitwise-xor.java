class Solution {
    public int longestSubsequence(int[] nums) {
        boolean allZero = true;
        int totalXor = 0;
        for(int n:nums) {
            totalXor ^= n;
            if(n!=0) {
                allZero = false;
            }
        }
        if(allZero) {
            return 0;
        }
        if(totalXor==0) {
            return nums.length-1;
        } else {
            return nums.length;
        }
    }
}