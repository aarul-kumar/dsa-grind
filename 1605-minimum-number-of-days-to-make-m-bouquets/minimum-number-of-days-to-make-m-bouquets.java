class Solution {
    public boolean isPossible(int arr[], int m, int k, int x) {
        int bloomed = 0;
        int boq = 0;
        int n = arr.length;
        for(int i=0; i<n; i++) {
            if(arr[i]<=x) {
                bloomed++;
                if(bloomed==k){
                    boq++;
                    bloomed = 0;
                }
            } else {
                bloomed = 0;
            }
        }
        return boq>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        for(int i:bloomDay) {
            r = Math.max(r,i);
        }
        int ans = 0;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(isPossible(bloomDay, m, k, mid)) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return ans==0?-1:ans;
    }
}