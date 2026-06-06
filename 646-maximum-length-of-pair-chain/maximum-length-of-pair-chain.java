class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o->o[1]));
        int maxLen = 1;
        int lastEnd = pairs[0][1];
        int n = pairs.length;
        for(int i=1; i<n; i++){
            if(lastEnd<pairs[i][0]){
                maxLen++;
                lastEnd=pairs[i][1];
            }
        }
        return maxLen;
    }
}