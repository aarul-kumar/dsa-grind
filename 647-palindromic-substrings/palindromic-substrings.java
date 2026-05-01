class Solution {
    private boolean solve(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(solve(s.substring(i,j+1))) {
                    count++;
                }
            }
        }
        return count;
    }
}