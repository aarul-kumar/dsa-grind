class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        int si=0;
        int ei=si+k-1;
        while(ei<s.length()) {
            set.add(s.substring(si, ei+1));
            si++;
            ei++;
        }
        if(set.size()==Math.pow(2,k)) {
            return true;
        } else {
            return false;
        }
    }
}