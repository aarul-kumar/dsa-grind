class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        int flip1 = 0;
        int flip2 = 0;
        int i = 0;
        int j = 0;
        while(j< 2*n) {
            char s1 = (j%2==1) ? '1':'0';
            char s2 = (j%2==1) ? '0':'1';
            if(s.charAt(j%n) != s1) {
                flip1++;
            }
            if(s.charAt(j%n) != s2) {
                flip2++;
            }
            if(j-i+1>n) {
                s1 = (i%2==1) ? '1':'0';
                s2 = (i%2==1) ? '0':'1';
                if(s.charAt(i%n) != s1) {
                    flip1--;
                }
                if(s.charAt(i%n) != s2) {
                    flip2--;
                }
                i++;
            }
            if(j-i+1==n) {
                ans = Math.min(ans, Math.min(flip1, flip2));
            }
            j++;
        }
        return ans;
    }
}