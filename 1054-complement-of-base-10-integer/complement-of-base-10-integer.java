class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) {
            return 1;
        }
        int a = 0;
        int b = n;
        while(b>0) {
            a = (a<<1) | 1;
            b = b>>1;
        }
        return a-n;
    }
}