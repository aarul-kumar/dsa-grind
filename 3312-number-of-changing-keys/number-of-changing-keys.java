class Solution {
    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        int i=0;
        int j=i+1;
        int count = 0;
        while(j<s.length()) {
            if(s.charAt(i)!=s.charAt(j)) {
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}