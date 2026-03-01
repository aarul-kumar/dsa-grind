class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for(int i=0; i<n.length(); i++) {
            char ch = n.charAt(i);
            int val = ch - '0';
            ans = Math.max(ans, val);
        }
        return ans;
    }
}