class Solution {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        long lhs[] = new long[n];
        long rhs[] = new long[n];

        Arrays.sort(beans);

        lhs[0] = 0;
        long same = 1;
        for(int i=1; i<n; i++) {
            if(beans[i]==beans[i-1]) {
                same++;
                lhs[i] = lhs[i-1];
            } else {
                lhs[i] = same*beans[i-1]+lhs[i-1];
                same = 1;
            }
        }

        rhs[n-1] = 0;
        long sum = beans[n-1];
        long count = 1;
        for(int i=n-2; i>=0; i--) {
            if(beans[i]==beans[i+1]) {
                rhs[i] = rhs[i+1];
            } else {
                rhs[i] = sum - beans[i]*count;
            }
            sum += beans[i];
            count++;
        }

        long ans = Long.MAX_VALUE;
        for(int i=0; i<n; i++) {
            long val = lhs[i]+rhs[i];
            ans = Math.min(ans,val);
        }

        return ans;
    }
}