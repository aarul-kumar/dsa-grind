class Solution {
    public int addDigits(int num) {
        while(num >= 10) {
            int q = num/10;
            int rem = num%10;
            num = q+rem;
        }
        return num;
    }
}