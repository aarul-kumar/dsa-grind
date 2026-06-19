class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
        }

        int len = 0;
        boolean odd = false;

        for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if(entry.getValue()%2==0) {
                len += entry.getValue();
            } else {
                len += entry.getValue()-1;
                odd = true;
            }
        }

        if(odd) {
            len++;
        }

        return len;
    }
}