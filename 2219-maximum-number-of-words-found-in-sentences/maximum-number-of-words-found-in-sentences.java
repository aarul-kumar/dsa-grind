class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for(int i=0; i<sentences.length; i++) {
            int count = 0;
            String s = sentences[i];
            for(int j=0; j<s.length()-1; j++) {
                if(s.charAt(j)==' ' && s.charAt(j+1)!=' ') {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans+1;
    }
}