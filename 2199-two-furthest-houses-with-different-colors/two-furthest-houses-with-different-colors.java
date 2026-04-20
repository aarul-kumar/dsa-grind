class Solution {
    private int lf(int[] colors) {
        int rp = colors.length-1;
        while(0<rp) {
            if(colors[0]!=colors[rp]) {
                return rp-0;
            }
            rp--;
        }
        return -1;
    }
    private int rf(int colors[]) {
        int lp = 0;
        while(lp<colors.length-1) {
            if(colors[lp]!=colors[colors.length-1]) {
                return colors.length-1-lp;
            }
            lp++;
        }
        return -1;
    }
    public int maxDistance(int[] colors) {
        int alf = lf(colors);
        int arf = rf(colors);
        return Math.max(Math.abs(alf), Math.abs(arf));
    }
}