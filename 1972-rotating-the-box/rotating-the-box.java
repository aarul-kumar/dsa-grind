class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int rows = boxGrid.length;
        int cols = boxGrid[0].length;
        for(int r=0; r<rows; r++) {
            int empty = cols-1;
            for(int c=cols-1; c>=0; c--) {
                if(boxGrid[r][c]=='*') {
                    empty = c-1;
                } else if(boxGrid[r][c]=='#') {
                    boxGrid[r][c] = '.';
                    boxGrid[r][empty] = '#';
                    empty--;
                }
            }
        }
        char[][] rotatedBox = new char[cols][rows];
        for(int i=0; i<cols; i++) {
            for(int j=0; j<rows; j++) {
                rotatedBox[i][j] = boxGrid[rows-1-j][i];
            }
        }
        return rotatedBox;
    }
}