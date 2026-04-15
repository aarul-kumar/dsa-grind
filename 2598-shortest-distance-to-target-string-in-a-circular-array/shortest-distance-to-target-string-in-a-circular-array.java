class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        int n = words.length;
        for(int i=0; i<n; i++) {
            if(words[i].equals(target)) {
                int d = Math.min(Math.abs(i-startIndex), n-Math.abs(i-startIndex));
                ans = Math.min(ans,d);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}