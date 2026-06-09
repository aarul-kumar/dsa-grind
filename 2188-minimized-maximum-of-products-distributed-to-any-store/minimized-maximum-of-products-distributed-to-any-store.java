class Solution {
    public boolean possible(int n, int[] quantities, int x){
        int totStores = 0;
        for(int i=0; i<quantities.length; i++){
            totStores += (quantities[i]+x-1)/x;
        }
        return totStores<=n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        for(int i=0; i<quantities.length; i++){
            r = Math.max(r,quantities[i]);
        }
        int ans = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(possible(n, quantities, mid)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}