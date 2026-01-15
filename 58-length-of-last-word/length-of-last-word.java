class Solution {
    public int lengthOfLastWord(String s) {
        int l = s.length();
        int lenLast = 0;
        int w = 0;
        for(int i=l-1; i>=0; i--){
            if(s.charAt(i)!=' '){
                lenLast ++;
                w = 1;
            }
            else if(s.charAt(i)==' ' && w==1){
                break;
            }
        }
        return lenLast;
    }
}