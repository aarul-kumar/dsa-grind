class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0; i<32; i++) {
            int bitmask = n & 1;
            ans = ans<<1;
            ans = ans | bitmask;
            n = n>>1;
        }
        return ans;
    }
}