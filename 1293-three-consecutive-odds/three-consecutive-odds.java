class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int i=0;
        int j=i+2;
        while(j<arr.length) {
            if(arr[i]%2!=0 && arr[i+1]%2!=0 && arr[j]%2!=0) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
}