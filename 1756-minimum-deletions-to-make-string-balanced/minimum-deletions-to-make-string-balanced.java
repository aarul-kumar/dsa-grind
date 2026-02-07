class Solution {
    public int minimumDeletions(String s) {
        int count=0;
        Stack<Character> st = new Stack<>();
        for(int i=s.length()-1; i>=0; i--) {
            if(!st.isEmpty() && s.charAt(i) == 'b' && st.peek() == 'a') {
                st.pop();
                count++;
            } else {
                st.push(s.charAt(i));
            }
        }
        return count;
    }
}