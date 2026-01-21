class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans[] = new int[nums.size()];
        for(int i=0; i<nums.size(); i++) {
            if((nums.get(i)&1)==0) {
                ans[i] = -1;
                continue;
            }
            for(int j=0; j<31; j++) {
                if((nums.get(i)&(1<<j)) == 0) {
                    ans[i] = nums.get(i)^(1<<(j-1));
                    break;
                }
            }
        }
        return ans;
    }
}