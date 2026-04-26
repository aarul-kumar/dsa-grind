class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        if(flowerbed.length==1) {
            if(flowerbed[0]==0) {
                if(n>1) {
                    return false;
                } else {
                    return true;
                }
            } else {
                if(n<1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        for(int i=0; i<flowerbed.length; i++) {
            if(i==0) {
                if(flowerbed[i]==0 && flowerbed[i+1]==0) {
                    ans++;
                    i++;
                }
            }
            else if(i==flowerbed.length-1) {
                if(flowerbed[i-1]==0 && flowerbed[i]==0) {
                    ans++;
                    i++;
                }
            }
            else if(flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0) {
                ans++;
                i++;
            }
        }
        return ans>=n;
    }
}