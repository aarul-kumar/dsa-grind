class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int dash = 0;
        int val = 0;
        for(int i=0; i<moves.length(); i++) {
            char c = moves.charAt(i);
            if(c=='L') {
                val--;
            } else if(c=='R') {
                val++;
            } else {
                dash++;
            }
        }
        if(val>=0) {
            val += dash;
            return val;
        } else {
            val -= dash;
            return (-1*val);
        }
    }
}