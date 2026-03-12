class Solution {
    public int countDigits(int num) {
        int n = num;
        int ans = 0;
        while(n>0) {
            int d = n%10;
            if(num%d == 0) {
                ans++;
            }
            n=n/10;
        }
        return ans;
    }
}