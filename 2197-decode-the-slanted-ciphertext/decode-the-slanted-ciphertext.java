class Solution {
    private String rtrim(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        return s.substring(0, end + 1);
    }
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length()/rows;
        char mat[][] = new char[rows][cols];
        int k=0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                mat[i][j] = encodedText.charAt(k);
                k++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<cols; j++) {
            int col = j;
            for(int i=0; i<rows; i++) {
                sb.append(mat[i][col++]);
                if(col>=cols) {
                    break;
                }
            }
        }
        return rtrim(sb.toString());
    }
}