class Solution {
    public int binaryGap(int n) {
        if(Integer.bitCount(n) == 1) {
            return 0;
        }
        int ans = 0;
        while(n>0) {
            int count = 0;
            if((n&1) == 1) {
                n>>=1;
                while(n>0 && (n&1) != 1) {
                    count++;
                    n>>=1;
                }
                ans = Math.max(ans, count);
            } else {
                n>>=1;
            }
        }
        return ans+1;
    }
}