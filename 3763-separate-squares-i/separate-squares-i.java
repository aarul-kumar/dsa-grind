class Solution {
    public boolean check(int squares[][], double midy, double total) {
        double botarea = 0;
        for(int i=0; i<squares.length; i++) {
            double y = squares[i][1];
            double l = squares[i][2];

            double boty = y;
            double topy = y+l;

            if(midy>=topy) {
                botarea += l*l;
            } else if(midy>boty) {
                botarea += l*(midy-boty);
            }
        }
        return botarea>=total/2.0;
    }
    public double separateSquares(int[][] squares) {
        double low = Integer.MAX_VALUE;
        double high = 0;
        double total = 0;

        for(int i=0; i<squares.length; i++) {
            double y = squares[i][1];
            double l = squares[i][2];
            low = Math.min(low, y);
            high = Math.max(high, y+l);
            total += l*l;
        }

        double ans = 0;
        while(high-low > 1e-6) {
            double midy = low + (high-low)/2;
            ans = midy;
            if(check(squares, midy, total)) {
                high = midy;
            } else {
                low = midy;
            }
        }
        return ans;
    }
}