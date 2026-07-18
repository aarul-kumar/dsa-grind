class Solution {
    public int[] findErrorNums(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for(int num:nums) {
            xor ^= num;
        }
        for(int i=1; i<=n; i++) {
            xor ^= i;
        }
        int sb = xor & -xor;
        int a = 0;
        int b = 0;
        for(int num:nums) {
            if((num & sb)!=0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        for(int i=1; i<=n; i++) {
            if((i & sb)!=0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        for(int num:nums) {
            if(num==a) {
                return new int[]{a,b};
            }
        }
        return new int[]{b,a};
    }
}