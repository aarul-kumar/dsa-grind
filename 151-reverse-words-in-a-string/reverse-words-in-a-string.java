class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i=s.length()-1;
        for(int j=s.length()-1; j>=0; j--) {
            if(s.charAt(j)==' ') {
                if(j+1<=i) {
                    sb.append(s.substring(j+1,i+1)).append(" ");
                }
                i=j-1;
            }
        }
        if(i>=0) {
            sb.append(s.substring(0,i+1));
        }
        return sb.toString().trim();
    }
}