class Solution {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int diff = 1;
        for(int i=0; i<candyType.length-1; i++) {
            if(candyType[i]!=candyType[i+1]) {
                diff++;
            }
        }
        int allowed = candyType.length/2;
        return Math.min(diff, allowed);
    }
}