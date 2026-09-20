class Solution {
    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length-1;
        int maxVol = 0;
        while(lp<rp) {
            int w = rp-lp;
            int h = Math.min(height[rp],height[lp]);
            int currVol = w*h;
            maxVol = Math.max(maxVol,currVol);
            if(height[lp]<height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxVol;
    }
}