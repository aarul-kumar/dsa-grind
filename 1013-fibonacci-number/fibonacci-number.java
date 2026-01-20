class Solution {
    public int fib(int n) {
        //base case
        if(n==0 || n==1) {
            return n;
        }
        //kaam
        return (fib(n-1) + fib(n-2));
    }
}