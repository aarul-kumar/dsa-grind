class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int tten = 0;
        for(int i=0; i<bills.length; i++) {
            if(bills[i]==5) {
                five++;
            }
            if(bills[i]==10) {
                if(five>0) {
                    five--;
                } else {
                    return false;
                }
                ten++;
            }
            if(bills[i]==20) {
                if(ten>0 && five>0) {
                    ten--;
                    five--;
                } else if(ten==0 && five>=3) {
                    five -= 3;
                } else {
                    return false;
                }
                tten++;
            }
        }
        return true;
    }
}