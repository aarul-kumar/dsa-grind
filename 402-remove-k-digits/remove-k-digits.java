class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        int rem = 0;
        for(int i=0; i<num.length(); i++) {
            while(!s.isEmpty() && num.charAt(i)<s.peek() && rem<k) {
                s.pop();
                rem++;
            }
            s.push(num.charAt(i));
        }
        while(rem < k) {
            s.pop();
            rem++;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0)=='0') {
            sb.deleteCharAt(0);
        }
        return sb.length()==0?"0":sb.toString();
    }
}