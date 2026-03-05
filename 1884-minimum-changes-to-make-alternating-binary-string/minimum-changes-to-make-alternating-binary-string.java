class Solution {
    private int startZero(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(i%2==0) {
                if(s.charAt(i)!='0') {
                    count++;
                }
            } else {
                if(s.charAt(i)!='1') {
                    count++;
                }
            }
        }
        return count;
    }
    private int startOne(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(i%2==0) {
                if(s.charAt(i)!='1') {
                    count++;
                }
            } else {
                if(s.charAt(i)!='0') {
                    count++;
                }
            }
        }
        return count;
    }
    public int minOperations(String s) {
        return Math.min(startZero(s), startOne(s));
    }
}