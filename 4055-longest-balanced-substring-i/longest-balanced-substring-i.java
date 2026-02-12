class Solution {
    public int longestBalanced(String s) {
        int maxLen = 0;
        for(int i=0; i<s.length(); i++) {
            HashMap<Character, Integer> hm = new HashMap<>();
            for(int j=i; j<s.length(); j++) {
                hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0)+1);
                int min = Integer.MAX_VALUE;
                int max = 0;
                for(int val : hm.values()) {
                    min = Math.min(min, val);
                    max = Math.max(max, val);
                }
                if(min == max) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
}