class Solution {
    public int largestAltitude(int[] gain) {
        int maxh = 0;
        int lasth = 0;
        for(int i=0; i<gain.length; i++) {
            lasth += gain[i];
            maxh = Math.max(maxh, lasth);
        }
        return maxh;
    }
}