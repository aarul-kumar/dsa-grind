class Solution {
    public boolean judgeCircle(String moves) {
       int y=0;
       int x=0;
       for(int i=0; i<moves.length(); i++) {
        char c = moves.charAt(i);
        if(c=='U') {
            y++;
        } else if(c=='D') {
            y--;
        } else if(c=='L') {
            x--;
        } else {
            x++;
        }
       }
       if(x==0 && y==0) {
        return true;
       } else {
        return false;
       }
    }
}