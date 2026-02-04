class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        return pow2(x, N);
    }
    private double pow2(double x, long n){
        if(n==0){
            return 1;
        }
        double halfPower = pow2(x,n/2);
        double halfPowerSq = halfPower*halfPower;
        if(n%2!=0){
            halfPowerSq = x*halfPowerSq;
        }
        return halfPowerSq;
    }
}