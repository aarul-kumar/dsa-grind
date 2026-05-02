class Solution {
    int count;
    private void checkNum(int i) {
        int n = 0;
        while(i>0) {
            int rem = i%10;
            if(rem==3 || rem==4 || rem==7) {
                n=0;
                break;
            }
            if(rem==2 || rem==5 || rem==6 || rem==9) {
                n=1;
            }
            i/=10;
        }
        count+=n;
    }
    public int rotatedDigits(int n) {
        for(int i=1; i<=n; i++) {
            checkNum(i);
        }
        return count;
    }
}