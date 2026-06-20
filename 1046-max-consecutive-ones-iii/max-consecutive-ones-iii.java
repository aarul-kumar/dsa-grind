class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        int maxLen = 0;

        while(j<nums.length) {
            if(nums[j]==0) {
                count++;
            }

            while(i<=j && count>k) {
                if(nums[i]==0) {
                    count--;
                }
                i++;
            }

            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }

        return maxLen;
    }
}