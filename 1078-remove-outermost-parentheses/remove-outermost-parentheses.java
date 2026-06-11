class Solution {
    String ans = "";
    public void add(String s, int i, int j) {
        ans += s.substring(i+1,j);
    }
    public String removeOuterParentheses(String s) {
        int open = 0;
        int close = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') open++;
            if(s.charAt(i)==')') close++;
            if(open==close) {
                open = 0;
                close = 0;
                add(s, start, i);
                start = i+1;
            }
        }
        return ans;
    }
}