class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int freq[] = new int[A.length+1];
        int ans[] = new int[A.length];
        int val = 0;
        for(int i=0; i<A.length; i++) {
            freq[A[i]]++;
            if(freq[A[i]]==2) {
                val++;
            }
            freq[B[i]]++;
            if(freq[B[i]]==2) {
                val++;
            }
            ans[i] = val;
        }
        return ans;
    }
}