class Solution {
    private int gcd(int l1, int l2) {
        while(l1%l2!=0) {
            int r = l1%l2;
            l1 = l2;
            l2 = r;
        }
        return l2;
    }
    public String gcdOfStrings(String str1, String str2) {
        String s1 = str1+str2;
        String s2 = str2+str1;
        if(s1.equals(s2)) {
            int l1 = str1.length();
            int l2 = str2.length();
            int l = gcd(l1, l2);
            return str2.substring(0,0+l);
        } else {
            return "";
        }
    }
}