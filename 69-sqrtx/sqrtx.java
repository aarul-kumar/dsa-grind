class Solution {
    public int mySqrt(int x) {
        int ans = 0;
        int start = 0;
        int end = x;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if((long)mid*mid == x) {
                return mid;
            } else if((long)mid*mid > x) {
                end = mid-1;
            } else if((long)mid*mid < x) {
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
}