class Solution {
    public int reverseDegree(String s) {
        int val = 0;
        for(int i=0; i<s.length(); i++) {
            val += (26-(s.charAt(i)-'a'))*(i+1);
        }
        return val;
    }
}