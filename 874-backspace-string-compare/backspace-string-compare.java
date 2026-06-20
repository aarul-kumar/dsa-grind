class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int count1 = 0;
        int count2 = 0;

        while(i>=0 || j>=0) {
            while(i>=0) {
                if(s.charAt(i)=='#') {
                    count1++;
                    i--;
                } else if(count1>0) {
                    i--;
                    count1--;
                } else {
                    break;
                }
            }
            while(j>=0) {
                if(t.charAt(j)=='#') {
                    count2++;
                    j--;
                } else if(count2>0) {
                    j--;
                    count2--;
                } else {
                    break;
                }
            }
            if(i<0 || j<0) {
                return i==j;
            }
            if(s.charAt(i)!=t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}