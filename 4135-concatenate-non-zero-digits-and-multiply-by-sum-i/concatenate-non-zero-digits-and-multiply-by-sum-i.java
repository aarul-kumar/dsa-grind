class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch!='0') {
                sb.append(ch);
                sum += ch-'0';
            }
        }
        if(sb.length()==0) {
            return 0;
        }
        long ans = Long.parseLong(sb.toString());
        return ans*sum;
    }
}