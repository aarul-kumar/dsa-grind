class Solution {
    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length-1;
        int maxWater = 0;
        while(lp < rp) {
            int currWater = Math.min(height[lp], height[rp]) * (rp-lp);
            maxWater = Math.max(maxWater, currWater);
            if(height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }
}