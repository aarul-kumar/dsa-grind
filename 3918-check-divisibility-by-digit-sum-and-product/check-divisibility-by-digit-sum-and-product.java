class Solution {
    public int prod(int n) {
        int x = 1;
        while(n>0) {
            x *= n%10;
            n = n/10;
        }
        return x;
    }
    public int sum(int n) {
        int x = 0;
        while(n>0) {
            x += n%10;
            n = n/10;
        }
        return x;
    }
    public boolean checkDivisibility(int n) {
        int x = prod(n)+sum(n);
        if(n%x==0) {
            return true;
        }
        return false;
    }
}