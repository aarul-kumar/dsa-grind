class Solution {
    int count = 0;
    private void check(String s, int i, int j, int n) {
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }
    public int countSubstrings(String s) {
        int n = s.length();
        for(int i=0; i<n; i++) {
            check(s, i, i, n);
            check(s, i, i+1, n);
        }
        return count;
    }
}