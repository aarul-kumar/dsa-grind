class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";
        for(int i=2; i<=n; i++) {
            StringBuilder rev =  new StringBuilder(s);
            rev.reverse();
            for(int j=0; j<rev.length(); j++) {
                if(rev.charAt(j)=='0') {
                    rev.setCharAt(j, '1');
                } else {
                    rev.setCharAt(j, '0');
                }
            }
            s = s + "1" + rev.toString();
        }
        return s.charAt(k-1);
    }
}