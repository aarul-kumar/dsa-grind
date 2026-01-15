class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxh = 1;
        int currh = 1;
        for(int i=1; i<hBars.length; i++) {
            if(hBars[i]-hBars[i-1]==1) {
                currh++;
            } else {
                currh = 1;
            }
            maxh = Math.max(maxh, currh);
        }
        int maxv = 1;
        int currv = 1;
        for(int i=1; i<vBars.length; i++) {
            if(vBars[i]-vBars[i-1]==1) {
                currv++;
            } else {
                currv = 1;
            }
            maxv = Math.max(maxv, currv);
        }
        int len = Math.min(maxh, maxv)+1;
        return len*len;
    }
}