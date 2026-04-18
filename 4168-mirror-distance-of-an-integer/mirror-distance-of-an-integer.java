class Solution {
    private int revNum(int n) {
        int rev = 0;
        while(n>0) {
            int rem = n%10;
            rev = rev*10 + rem;
            n = n/10;
        }
        return rev;
    }
    public int mirrorDistance(int n) {
        return Math.abs(revNum(n)-n);
    }
}